package ConvertPage.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
//import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by Андрей on 10.05.2017.
 * Updated by Александр on 17.04.2022.
 */
public class Convert1000RURIntoUSDTest extends TestBase{

    @Test
    public void Convert1000RURtoUSDTest(){

        String inputCurrencyString = "1000";


        app.openConverterPage();
        app.setRURtoSell();
        app.setUSDtoBuy();
        app.setInputCurrency(inputCurrencyString);

        //output does not change immediately, wait for it
        app.WaitOutputRefresh();

        Double inputCurrencyNumber = Double.parseDouble(inputCurrencyString);
        Double RateVal = app.getConverterRate();
        Double allowedDelta = (RateVal*inputCurrencyNumber)/100.0d;
        Double outputCurrency = app.getOutputCurrency();
        //assert: 1 - value to be checked, 2 - actual value, 3 - allowed delta, 4 - assert text
        Assert.assertEquals(outputCurrency,RateVal*inputCurrencyNumber,allowedDelta,"Expect that output value match with calculated value");


    }


}
