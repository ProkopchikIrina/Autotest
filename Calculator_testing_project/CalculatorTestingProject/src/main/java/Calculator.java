import static java.lang.Double.NaN;

/**
 * Created by Irina on 30.03.2018.
 */

class Calculator {
    double addition(double number1, double number2) {
        return round(number1 + number2);
    }

    double subtraction(double number1, double number2) {
        return round(number1 - number2);
    }

    double multiplication(double number1, double number2) {
        return round(number1 * number2);
    }

    double division(double number1, double number2) {
        if(number2!=0) {
            return round(number1 / number2);
        }
        else {
            return NaN;
        }
    }
    double sqrt(double number) {
        if(number>=0) {
            return round(Math.sqrt(number));
        }
        else
        {
            return NaN;
        }
    }

    double percent(double number1, double number2) {
        return round(number1 * number2 / 100);
    }

    double pow(double number1, double number2) {
        return round(Math.pow(number1,number2));
    }

    private double round(double number)
    {
        number=number*10000;
        int i=(int)Math.round(number);
        number=(double)i/10000;
        return number;
    }
}