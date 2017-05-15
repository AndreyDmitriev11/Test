package ConvertPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Андрей on 14.05.2017.
 */
public class Convert0RublesIntoUSDTest extends TestBase {

    @Test
    public void Convert0RURtoUSDTest(){

        String inputCurrencyString = "0";


        app.openConverterPage();
        app.setRURtoSell();
        app.setUSDtoBuy();
        app.setInputCurrency(inputCurrencyString);

        //output does not change immediately, wait for it
        app.WaitOutputRefresh();

        boolean checkResult = app.checkOutputNoData();
        Assert.assertTrue(checkResult,"Expect 'No data' result");

    }
}
