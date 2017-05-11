package ConvertPage.tests;


import ConvertPage.app.Application;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Андрей on 10.05.2017.
 */
public class Conver1000RublesintoUSD extends TestBase{

    @Test
    public void ConvertTest(){

        Double inputCurrency = 1000.0d;
        app.openConverterPage();
        app.setRURtoSell();
        app.setUSDtoBuy();
        app.setInputCurrency(inputCurrency.toString());

        //output does not change immediately, wait for it
        app.WaitOutputRefresh();


        Double RateVal = app.getConverterRate();
        Double allowedDelta = (RateVal*inputCurrency)/100.0d;
        Double outputCurrency = app.getOutputCurrency();
        //assert: 1 - value to be checked, 2 - actual value, 3 - allowed delta, 4 - assert text
        Assert.assertEquals(outputCurrency,RateVal*inputCurrency,allowedDelta,"Expect that output value match with calculated value");


    }


}
