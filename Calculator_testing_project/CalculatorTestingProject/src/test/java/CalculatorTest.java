import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.NaN;

/**
 * Created by Irina on 30.03.2018.
 */

public class CalculatorTest {

    private Calculator calculator;
    private String message="ќжидаемый результат не соответствует действительному";
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionTest() {
        double result = calculator.addition(51, 15.45);
        Assert.assertEquals(message, 66.45, result, 0);
    }

    @Test
    public void additionTest2() {
        double result = calculator.addition(-672.84, -73);
        Assert.assertEquals(message, -745.84, result, 0);
    }

    @Test
    public void additionTest3() {
        double result = calculator.addition(0, -7);
        Assert.assertEquals(message, -7, result, 0);
    }

    @Test
    public void additionTest4() {
        double result = calculator.addition(1.7, 1.3);
        Assert.assertEquals(message, 3, result, 0);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.subtraction(137, 34.1);
        Assert.assertEquals(message, 102.9, result, 0);
    }

    @Test
    public void subtractionTest2() {
        double result = calculator.subtraction(-4, -12);
        Assert.assertEquals(message, 8, result, 0);
    }

    @Test
    public void subtractionTest3() {
        double result = calculator.subtraction(-4, 0);
        Assert.assertEquals(message, -4, result, 0);
    }

    @Test
    public void subtractionTest4() {
        double result = calculator.subtraction(1.9, 0.9);
        Assert.assertEquals(message, 1, result, 0);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.multiplication(109, 5);
        Assert.assertEquals(message, 545, result, 0);
    }

    @Test
    public void multiplicationTest2() {
        double result = calculator.multiplication(1.25, 5);
        Assert.assertEquals(message, 6.25, result, 0);
    }

    @Test
    public void multiplicationTest4() {
        double result = calculator.multiplication(51, 0);
        Assert.assertEquals(message, 0, result, 0);
    }

    @Test
    public void multiplicationTest5() {
        double result = calculator.multiplication(11, -125);
        Assert.assertEquals(message, -1375, result, 0);
    }

    @Test
    public void multiplicationTest6() {
        double result = calculator.multiplication(-1.1, -15);
        Assert.assertEquals(message, 16.5, result, 0);
    }

    @Test
    public void divisionTest() {
        double result = calculator.division(16.5, 5.5);
        Assert.assertEquals(message, 3, result, 0);
    }

    @Test
    public void divisionTest2() {
        double result = calculator.division(891, 9);
        Assert.assertEquals(message, 99, result, 0);
    }

    @Test
    public void divisionTest3() {
        double result = calculator.division(463, 0);
        Assert.assertEquals(message, NaN,result,0 );
    }

    @Test
    public void divisionTest4() {
        double result = calculator.division(10, 3);
        Assert.assertEquals(message, 3.3333, result, 0);
    }

    @Test
    public void divisionTest5() {
        double result = calculator.division(-6, -3);
        Assert.assertEquals(message, 2, result, 0);
    }

    @Test
    public void divisionTest6() {
        double result = calculator.division(0, 9);
        Assert.assertEquals(message, 0, result, 0);
    }

    @Test
    public void sqrtTest() {
        double result = calculator.sqrt(-81);
        Assert.assertEquals(message, NaN, result, 0);
    }

    @Test
    public void sqrtTest2() {
        double result = calculator.sqrt(9);
        Assert.assertEquals(message, 3, result, 0);
    }
    @Test
    public void sqrtTest3() {
        double result = calculator.sqrt(0);
        Assert.assertEquals(message, 0, result, 0);
    }
    @Test
    public void sqrtTest4() {
        double result = calculator.sqrt(11.5);
        Assert.assertEquals(message, 3.3912, result, 0);
    }

    @Test
    public void percentTest() {
        double result = calculator.percent(10,20);
        Assert.assertEquals(message, 2, result, 0);
    }

    @Test
    public void powTest(){
        double result = calculator.pow(2,6);
        Assert.assertEquals(message, 64, result, 0);
    }

    @Test
    public void powTest2(){
        double result = calculator.pow(-3,5);
        Assert.assertEquals(message, -243, result, 0);
    }

    @Test
    public void powTest3(){
        double result = calculator.pow(2,-3);
        Assert.assertEquals(message, 0.125, result, 0);
    }

    @Test
    public void powTest4(){
        double result = calculator.pow(-1.6,4);
        Assert.assertEquals(message, 6.5536, result, 0);
    }

    @Test
    public void powTest5(){
        double result = calculator.pow(12,0.8);
        Assert.assertEquals(message, 7.3004, result, 0);
    }

    @Test
    public void powTest6(){
        double result = calculator.pow(-1005,0);
        Assert.assertEquals(message, 1, result, 0);
    }

    @Test
    public void powTest7(){
        double result = calculator.pow(0,299);
        Assert.assertEquals(message, 0, result, 0);
    }
    }