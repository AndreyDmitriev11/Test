package ConvertPage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Андрей on 15.05.2017.
 * Updated by Александр on 17.04.2022.
 */
public class Convert000000001RURIntoUSDTest extends  TestBase {

    @Test
    public void Convert000000001RURtoUSDTest(){

        String inputCurrencyString = "0.00000001";


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
