package ConvertPage.app;

import ConvertPage.pages.ConverterPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Андрей on 10.05.2017.
 */
public class Application{

    private ConverterPage converterPage;

    public Application(WebDriver driver){
        System.out.println("fuck");
        converterPage = new ConverterPage(driver);
    }


    public void openConverterPage(){
        converterPage.open();
    }


    public void setRURtoSell(){
        converterPage.setRURtoSell();
    }

    public void setRURtoBuy(){
        converterPage.setRURtoBuy();
    }

    public void setUSDtoSell(){
        converterPage.setUSDtoSell();
    }

    public void setUSDtoBuy(){
        converterPage.setUSDtoBuy();
    }

    public void setEURtoSell(){
        converterPage.setEURtoSell();
    }

    public void setEURtoBuy(){
        converterPage.setEURtoBuy();
    }

    public void setInputCurrency(CharSequence newVal){
        converterPage.setInputField(newVal);
    }

    public Double getOutputCurrency(){
        return Double.parseDouble(converterPage.getOutputField());
    }

    public Double getConverterRate() {return Double.parseDouble(converterPage.getConverterRate());}

    public void WaitOutputRefresh(){converterPage.WaitUntilOutputRefresh();}

}
