package ConvertPage.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
//import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by Александр on 17.04.2022.
 */
public class Convert1000GBPIntoEURTest extends TestBase{

    @Test
    public void Convert1000GBPtoEURTest(){

        String inputCurrencyString = "1000";


        app.openConverterPage();
        app.setGBPtoSell();
        app.setEURtoBuy();
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
