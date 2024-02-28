package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoskitaLoginPage {

    public static WebDriver webDriver;
//   public WebDriverWait wait;

    public KoskitaLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }


//HOMEPAGE
    @FindBy(xpath = "//p[text()='Cari disini aja dah']")
    private WebElement verifyHomepage;
    @FindBy(css = "[alt='person']")
    private WebElement clickUser;
    @FindBy(xpath = "//img[@alt='Brand-logo']")
    private WebElement homeButton;



    //LOGIN
    @FindBy (xpath = "//h2[text()='Masuk Akun']")
    private WebElement verifyLoginPage;
    @FindBy (xpath = "//li[text()='Login']")
    private WebElement gotoLogin;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement fieldEmail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;
    @FindBy (xpath = "//button[text()='Login']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//div[text()='Log in']")
    private WebElement backToLogin;
    @FindBy(xpath = "//div[contains(text(), 'Logout')]")
    private WebElement buttonLogout;
    @FindBy(xpath = "//div[@class='text-sm opacity-90' and text()='Password incorrect']")
    private WebElement verifyMessagePassword;
    @FindBy(xpath = "//p[@class='text-red-500 text-sm' and text()='Email is required']")
    private WebElement getVerifyEmailRequired;
    @FindBy(xpath = "//div[@class='text-sm opacity-90' and text()='Account is not registered']")
    private WebElement getVerifyNotRegistered;
    @FindBy(xpath = "//p[@class='text-red-500 text-sm' and text()='Not a valid email']")
    private WebElement getNotAValidEmail;






    //REGISTER
    @FindBy(xpath = "//span[contains(@class, 'text-[#4CA02E]') and text()='Sign up']")
    private WebElement buttonSignUp;
    @FindBy(xpath = "//div[@class='flex rounded-md border p-1 bg-slate-50 gap-x-1']/span[text()='Renter']")
    private WebElement buttonRenter;
    @FindBy(xpath = "//div[@class='flex rounded-md border p-1 bg-slate-50 gap-x-1']/span[text()='Owner']")
    private WebElement buttonOwner;
    @FindBy(xpath = "//div[contains(@class, 'self-center') and contains(text(), 'By creating an account you agree to our')]")
    private WebElement verifySignUpPage;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement fieldName;
    @FindBy(xpath = "//input[@name='user_name']")
    private WebElement fieldUsername;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement fieldEmailRegister;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPasswordRegister;
    @FindBy(xpath = "//select[@name='gender']/option[@value='laki-laki']")
    private WebElement dropdownGender;
    @FindBy(xpath = "//input[@id='checkbox-register']")
    private WebElement checklistAgree;
    @FindBy(xpath = "//button[text()='Buat Akun']")
    private WebElement buttonCreateAccount;
    @FindBy(xpath = "//p[text()='Kata sandi harus mengandung setidaknya satu huruf besar, satu huruf kecil, satu angka, satu karakter khusus, dan memiliki panjang minimal 6 karakter']")
    private WebElement getPasswordRequirement;
    @FindBy(xpath = "//div[@class='text-sm opacity-90' and text()='username atau email sudah ada']")
    private WebElement getEmailExisting;
    @FindBy(xpath = "//p[@class='text-red-500 text-sm' and text()='Email tidak valid']")
    private WebElement getEmailNotValid;
    @FindBy(xpath = "//p[@class='text-red-500 text-sm' and text()='Harap pilih jenis kelamin']")
    private WebElement getGenderNotValid;


    //SEARCH
    @FindBy (xpath = "//input[@id='search']")
    private WebElement fieldSearch;
    @FindBy(xpath = "//button[text()='Search']")
    private WebElement buttonSearch;
    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Search')]")
    private WebElement verifySearchPage;
    @FindBy(xpath = "(//h2[@class='cursor-pointer font-bold text-xl hover:text-2xl'])[2]")
    private WebElement fourthKos;

    //DETAIL KOS
    @FindBy(xpath = "//div[@class='bg-[#F2F0F2] rounded-3xl flex flex-col items-center max-w-xl  gap-y-4 p-6']")
    private WebElement verifyKosDetail;
    @FindBy(xpath = "//span[.='Pick a date']")
    private WebElement clickDate;
    @FindBy(xpath = "//button[text()='25']")
    private WebElement getClickDate;
    @FindBy(xpath = "(//button[@type='button'])[1]")
    private WebElement closeDate;
    @FindBy(xpath = "//button[contains(text(), 'Lanjutkan pemesanan')]")
    private WebElement buttonOrder;

    //ORDERING
    @FindBy(xpath = "//div[contains(@class, 'flex flex-col pb-4 font-bold leading-[133%] text-neutral-900 max-md:mt-10 max-md:max-w-full')]")
    private WebElement verifyOrderPage;

    @FindBy(xpath = "//select[@class='grow focus:outline-none w-[45vw] md:w-[22vw] p-4 bg-white rounded border border-solid shadow-sm border-zinc-400 max-md:pr-5']/option[text()='Virtual Account Bca']")
    private WebElement clickPaymentBCA;

    @FindBy(xpath = "//button[contains(@class, 'bg-lime-600') and contains(text(), 'Confirm and pay')]")
    private WebElement buttonConfirm;

    @FindBy(xpath = "//div[@class='bg-white w-[25rem] p-8 rounded shadow-lg']")
    private WebElement containerPayment;

    //EDIT Profile
    @FindBy(xpath = "//button[@class='grow justify-center px-3 py-2 md:px-4 md:py-3 bg-lime-600 rounded shadow-sm']")
    private WebElement buttonEditAkun;
    @FindBy(xpath = "//div[contains(text(), 'Profile')]")
    private WebElement buttonProfile;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputEditName;
    @FindBy(xpath = "//input[@id='user_name']")
    private WebElement inputEditUsername;
    @FindBy(xpath = "//div[form]")
    private WebElement verifyProfile;

    //RATING
    @FindBy(xpath = "(//button[@class='px-3 py-2 bg-lime-600 text-white rounded-md'])[1]")
    private WebElement buttonAddRating;
    @FindBy(xpath = "(//button[@class='w-10 h-10 focus:outline-none text-gray-400' and text()='★'])[5]")
    private WebElement button5Stars;
    @FindBy(xpath = "//button[@class='px-3 py-2 border-2 border-slate-100 bg-lime-600 text-white' and text()='Submit Rating']")
    private WebElement submitRatings;

    //Admin
    @FindBy(xpath = "//div[contains(@class, 'flex z-10 flex-col') and contains(., 'Booking Details')]")
    private WebElement getVerifyAdminPage;




    // action

    //LOGIN

    public boolean verifyAtLoginpage(){
        return verifyLoginPage.isDisplayed();
    }
    public boolean verifyAtHomepage(){
        return verifyHomepage.isDisplayed();
    }
    public void clickGotoLoginPage(){
        gotoLogin.click();
    }
    public void inputFieldEmail(String email){
        fieldEmail.sendKeys(email);
    }
    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }
    public void clickButtonLogin(){
        buttonLogin.click();
    }
    public void setBackToLogin(){backToLogin.click();}
    public boolean verifyPasswordIncorrect(){
        return verifyMessagePassword.isDisplayed();
    }
    public boolean verifyEmailRequired(){
        return getVerifyEmailRequired.isDisplayed();
    }
    public void clickLogOutButton(){buttonLogout.click();}
    public boolean verifyAdminPage(){return getVerifyAdminPage.isDisplayed();}
    public boolean verifyAccountNotRegistered(){return getVerifyNotRegistered.isDisplayed();}
    public boolean verifyNotAValidEmail(){return getNotAValidEmail.isDisplayed();}


    //REGISTER
    public void clickSignUp(){
        buttonSignUp.click();
    }
    public void clickRenter(){
        buttonRenter.click();
    }
    public void clickOwner(){
        buttonOwner.click();
    }
    public boolean verifyAtSignUpPage(){
        return verifySignUpPage.isDisplayed();
    }
    public void inputFieldNameRegister(String name){
        fieldName.sendKeys(name);
    }
    public void inputFieldUsernameRegister(String username){
        fieldUsername.sendKeys(username);
    }
    public void inputFieldEmailRegister(String email){
        fieldEmailRegister.sendKeys(email);
    }
    public void inputFieldPasswordRegister(String password){
        fieldPasswordRegister.sendKeys(password);
    }
    public void clickGender(){
        dropdownGender.click();
    }
    public void clickAgree(){
        checklistAgree.click();
    }
    public void clickBuatAkun(){
        buttonCreateAccount.click();
    }
    public boolean verifyPasswordRequirement(){return getPasswordRequirement.isDisplayed();}
    public boolean verifyEmailExisting(){return getEmailExisting.isDisplayed();}
    public boolean verifyEmailNotValid(){return getEmailNotValid.isDisplayed();}
    public boolean verifyGenderNotValid(){return getGenderNotValid.isDisplayed();}


    //EDIT PROFILE
    public void setInputEditName(String name){
        inputEditName.sendKeys(name);
    }
    public void setInputEditUsername(String username){
        inputEditUsername.sendKeys(username);
    }
    public void setButtonEditAkun(){
        buttonEditAkun.click();
    }
    public void setGotoProfile(){
        buttonProfile.click();
    }
    public boolean setVerifyProfile(){return verifyProfile.isDisplayed();}

    //HOMEPAGE
    public void setButtonHome(){
        homeButton.click();
    }
    public void setClickUser(){
        clickUser.click();
    }





    //SEARCH
    public void inputSearch(String search){
        fieldSearch.sendKeys(search);
    }
    public void clickSearch(){
        buttonSearch.click();
    }
    public boolean verifyPageSearch(){
        return verifySearchPage.isDisplayed();
    }

    //BOOKING
    public void clickFourthKos(){
        fourthKos.click();
    }
    public boolean verifyOnKosDetail(){
        return verifyKosDetail.isDisplayed();
    }
    public void setClickDate(){
        clickDate.click();
    }

    public void setPickDate(){
        getClickDate.click();
    }
    public void setCloseDate(){
        closeDate.click();
    }

    public void setClickOrder(){
        buttonOrder.click();
    }
    public boolean setVerifyOrderPage(){
        return verifyOrderPage.isDisplayed();
    }
    public void setClickPaymentBCA(){
        clickPaymentBCA.click();
    }
    public void setButtonConfirm() {
        buttonConfirm.click();
    }
    public boolean setVerifyPayment(){
        return containerPayment.isDisplayed();
    }


    //RATINGS
    public void setButtonAddRating(){
        buttonAddRating.click();
    }
    public void setButton5Stars(){
        button5Stars.click();
    }
    public void setSubmitRatings(){
        submitRatings.click();
    }






















}
