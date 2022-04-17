package ConvertPage.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import java.lang.InterruptedException;

import java.text.NumberFormat;
import java.text.ParseException;

import java.util.Locale;
import java.text.DecimalFormat;
/**
 * Created by Андрей on 10.05.2017.
 */
public class ConverterPage extends Page{

    public ConverterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("https://cash.rbc.ru/converter.html");
    }

    //page elements block
    @FindBy(xpath = "//*[@class='calc__side'][1]//*[text() = 'RUR']")
    private WebElement RURtoSell;

    @FindBy(xpath = "//*[@class='calc__side'][2]//*[text() = 'RUR']")
    private WebElement RURtoBuy;

    @FindBy(xpath = "//*[@class='calc__side'][1]//*[text() = 'USD']")
    private WebElement USDtoSell;

    @FindBy(xpath = "//*[@class='calc__side'][2]//*[text() = 'USD']")
    private WebElement USDtoBuy;

    @FindBy(xpath = "//*[@class='calc__side'][1]//*[text() = 'EUR']")
    private WebElement EURtoSell;

    @FindBy(xpath = "//*[@class='calc__side'][2]//*[text() = 'EUR']")
    private WebElement EURtoBuy;

    @FindBy(xpath = "//*[@class='calc__side'][1]//*[text() = 'GBP']")
    private WebElement GBPtoSell;

    @FindBy(xpath = "//*[@class='calc__side'][2]//*[text() = 'GBP']")
    private WebElement GBPtoBuy;

    @FindBy(xpath = "(//*[@class='calc__input_box__input js-converter-input'])[1]")
    private WebElement InputField;

    @FindBy(xpath = "(//*[@class='calc__input_box__input js-converter-input'])[2]")
    private WebElement OutputField;

    @FindBy(xpath = "//*[@class='calc__input_box__rate js-converter-rate-from']")
    private WebElement ConvertRate;
    //end of page elements block


    //page actions block
    public void setRURtoSell(){
        RURtoSell.click();
    }

    public void setRURtoBuy(){
        RURtoBuy.click();
    }

    public void setUSDtoSell(){
        USDtoSell.click();
    }

    public void setUSDtoBuy(){
        USDtoBuy.click();
    }

    public void setEURtoSell(){
        EURtoSell.click();
    }

    public void setEURtoBuy(){
        EURtoBuy.click();
    }

    public void setGBPtoSell(){
        GBPtoSell.click();
    }

    public void setGBPtoBuy(){
        GBPtoBuy.click();
    }

    public void setInputField(CharSequence newVal){
        InputField.clear();
        InputField.sendKeys(newVal);
    }

    public String getOutputField(){

        String innerText = OutputField.getAttribute("value");
        String stringOutputField = innerText.replaceAll("[^0-9?!\\.]","");
        return stringOutputField;

    }

    public String getConverterRate(){

        String innerText = ConvertRate.getAttribute("innerText");
        String numbersOnly = innerText.replaceAll("[^0-9?!\\.]","");
        String stringRate = numbersOnly.substring(1);
       return stringRate;
    }

    public void WaitUntilOutputRefresh(){

        String beforeChange = OutputField.getAttribute("value");
        // flag to set when text is changed, for exiting loop
        boolean hasText = true;

        // counter for # of times to loop, finally timing out
        int tries = 0;

        // until text is found or loop has executed however many times...
        while (hasText == true && tries < 10) {
            try{
                if (
                    OutputField.getAttribute("value").equals(beforeChange)){
                    Thread.sleep(250);
                    tries++;
                }
                else{
                    // text was changed, so set flag to exit loop
                    hasText = false;
                }
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();}
        }
    }

    public boolean checkOutputNoData(){
        if(OutputField.getAttribute("value").equals("")){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean checkOutputZero(){
        if(OutputField.getAttribute("value").equals("0")){
            return true;
        }
        else {
            return false;
        }
    }

    //end of page actions block

}
