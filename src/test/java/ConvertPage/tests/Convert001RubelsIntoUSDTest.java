package ConvertPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Андрей on 14.05.2017.
 */
public class Convert001RubelsIntoUSDTest extends  TestBase {

    @Test
    public void Convert001RURtoUSDTest(){

        String inputCurrencyString = "0.01";


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
