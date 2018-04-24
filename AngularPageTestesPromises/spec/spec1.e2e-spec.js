var pageObject = require('../page-object.js');
describe('search testes', function() {
    beforeEach(async function () {
        await browser.get('http://www.angular.io/docs');
        await browser.driver.manage().window().maximize();
    });

    //Проверка вставки в поле поиска
    it('checks the pasting into search field', async function () {
        await browser.actions().mouseMove({x: 285, y: 80}).mouseDown().mouseMove({
            x: 445,
            y: 80
        }).mouseUp().keyDown(protractor.Key.CONTROL).sendKeys('c').perform();
        await browser.actions().keyDown(protractor.Key.CONTROL).sendKeys('c').perform();
        var search =pageObject.search;
        await search.click();
        await browser.actions().keyDown(protractor.Key.CONTROL).sendKeys('v').perform();
        expect(await search.getAttribute('value')).toEqual('What is Angular?');
    });

    //Проверка ввода в поле поиска
    it('checks the input into search field', async function () {
        var search = pageObject.search;
        await search.sendKeys("").sendKeys("Search");
        var value = await search.getAttribute('value');
        expect(value).toEqual('Search');
    });

    //Проверка работы поиска
    it('checks search', function (done) {
        var search = pageObject.search;
        var attr= search.getAttribute('.search-results');
        search.sendKeys("Assumptions")
            .then(function () {
                browser.wait(attr.isPresent);
                return attr.isPresent();
            })
            .then(function (attr) {
                expect(attr).toBeTruthy();
            })
            .then(function () {
                done();
            });
    });

    //Проверка того, что после клика по другим элементам страницы, поле поиска не очищается
    it('checks that search field save text after click on anther element of page', function (done) {
        var search = pageObject.search;
        search.sendKeys("Some text")
            .then(function () {
                pageObject.leftMenuItemLevel1.click();
            })
            .then(function () {
                return search.getAttribute('value');
            })
            .then(function (attr) {
                expect(attr).toEqual('Some text');
            })
            .then(function () {
                done();
            });
    });
});

describe('angular.io/docs testes',function() {
    beforeEach(async function () {
        await browser.get('http://www.angular.io/docs');
        await browser.driver.manage().window().maximize();
    });

    //Проверяет, что при наведении на заголовок, элемент "link to this heading" становится видимым
    it('checks that after mouse over on title, element "link to this heading" is visible', function (done) {
        var title=pageObject.title;
        browser.actions().mouseMove(title).perform()
            .then(function () {
                return pageObject.linkToHeading.isPresent()
            })
            .then(function (isPresent) {
                expect(isPresent).toBeTruthy();
            })
            .then(function () {
                done();
            })

    });

    //Проверка работы кнопки закрывающей боковое меню(закрытие меню)
    it('checks that docs menu button close left menu (closing)', function (done) {
        pageObject.leftMenuButton.click()
            .then(function () {
                return pageObject.leftMenu.isPresent();
            })
            .then(function (isPresent) {
                expect(isPresent).toBeFalsy();
            })
            .then(function () {
                done();
            })
    });

    //Проверяет соответсвия текста заголовка ожидаемому
    it('checks the title', function (done) {
        var title=pageObject.title;
        title.getText()
            .then(function (text) {
                expect(text).toEqual('What is Angular?');
            })
            .then(function () {
                done();
            })
    });

    //Проверка того, что боковое меню не отображается при уменьшении размеров окна браузера+++++++++
    it('left menu is not displaying when window size is decreasing', function (done) {
        browser.driver.manage().window().setSize(1000, 1000)
            .then(function () {
                return pageObject.leftMenuGroupOfItemsLevel3.isDisplayed();
            })
            .then(function (isPresent) {
                expect(isPresent).toBeFalsy();
            })
            .then(function () {
                done();
            })
    });

    //Проверка работы кнопки закрывающей боковое меню(открытие меню)
    it('checks that docs menu button close left menu (opening)', async function() {
        await pageObject.leftMenuButton.click().click();
        expect(await pageObject.leftMenu.isDisplayed()).toBeTruthy();
    });

    //Проверка работы бокового меню
    it('checks the condition of the left menu by menu items of level-1 and level-2 deployment', function (done) {
        var menuItemLevel1 = pageObject.leftMenuItemLevel1;
        menuItemLevel1.click()
            .then(function () {
                pageObject.leftMenuItemLevel2.click();
            })
            .then(function () {
                menuItemLevel1.click().click();
            })
            .then(function () {
                return pageObject.leftMenuGroupOfItemsLevel3.isPresent();
            })
            .then(function (idPresent) {
                expect(idPresent).toBeFalsy();
            })
            .then(function () {
                done();
            })
    });

    // Проверка ссылки пункта меню
    it('checks that menu item works correctly', function (done) {
        var mainMenuItem=pageObject.mainMenuItem;
        mainMenuItem.getAttribute('href')
            .then(function (link) {
                expect(link).toEqual('https://angular.io/events');
            })
            .then(function () {
                done();
            })
    });

    //Проверка работы элемента 'Home' (переход на главную страницу)
    it('checks that Home button works correctly', function (done) {
        var home=pageObject.home;
        home.getAttribute('href')
            .then(function (link) {
                expect(link).toEqual('https://angular.io/');
            })
            .then(function () {
                done();
            })
    });

    //Проверка того, что пункты главного меню не отображаются на странице при уменьшении размеров окна
    it('main menu is not displaying when window size is decreasing', function (done) {
        browser.driver.manage().window().setSize(1000, 1000)
            .then(function () {
                return pageObject.mainMenuGroupOfItemsLevel1.isPresent();
            })
            .then(function (isPresent) {
                expect(isPresent).toBeFalsy();
            })
            .then(function () {
                done();
            })
    });

    //Проверка корректности ссылки на китайскую версию страницы
    it('Chinese version link', function (done) {
        var chineseLink=pageObject.linkChineseLangVersion;
        chineseLink.getAttribute('href')
            .then(function (link) {
                expect(link).toEqual('https://angular.cn/');
            })
            .then(function () {
                done();
            })
    });
});

