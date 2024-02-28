package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoskitaAboutContactPage {

    public static WebDriver webDriver;
//   public WebDriverWait wait;

    public KoskitaAboutContactPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    //About
    @FindBy (xpath = "//ul[@class='flex items-center gap-x-10']/li[contains(text(), 'Tentang')]")
    private WebElement buttonAboutPage;
    @FindBy (xpath = "//h1[contains(text(), 'Tentang Kami - KosKita')]")
    private WebElement verifyAboutPage;

    //Contact
    @FindBy (xpath = "//ul[@class='flex items-center gap-x-10']/li[contains(text(), 'Kontak')]")
    private WebElement buttonContactPage;
    @FindBy (xpath = "//h1[contains(text(), 'Hubungi Kami')]")
    private WebElement verifyContactPage;

    // action

    //About and Contact
    public void setButtonAboutPage(){buttonAboutPage.click();}
    public boolean setVerifyAboutPage(){return verifyAboutPage.isDisplayed();}

    public void setButtonContactPage(){buttonContactPage.click();}
    public boolean setVerifyContactPage(){return verifyContactPage.isDisplayed();}

}
