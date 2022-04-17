package ConvertPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Андрей on 14.05.2017.
 * Updated by Александр on 17.04.2022.
 */
public class Convert0RURIntoUSDTest extends TestBase {

    @Test
    public void Convert0RURtoUSDTest(){

        String inputCurrencyString = "0";


        app.openConverterPage();
        app.setRURtoSell();
        app.setUSDtoBuy();
        app.setInputCurrency(inputCurrencyString);

        //output does not change immediately, wait for it
        app.WaitOutputRefresh();

        boolean checkResult = app.checkOutputZero();
        Assert.assertTrue(checkResult,"Expect 'Zero' result");

    }
}
