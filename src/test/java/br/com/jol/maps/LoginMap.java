package br.com.jol.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin;
    //@FindBy(xpath = "//login-modal/div/div/div[2]")
    @FindBy(css = ".closeBtn")
    public WebElement btnFechar;
    //@FindBy(xpath = "//login-modal/div/div")
    @FindBy(css = ".PopUp")
    public WebElement divFechaModal;
    //@FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input")
    //@FindBy(xpath = "//*[@name='username']")
    //@FindBy(name = "username")
    @FindBy(css = "*[name='username']")
    public WebElement inpUserName;
    //@FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/sec-view[2]/div/label")
    @FindBy(css = "[type='password']")
    public WebElement inpPassword;
    //@FindBy(xpath = "//*[@id=\"sign_in_btnundefined\"]")
    //*[@id="sign_in_btnundefined"]
    //@FindBy(css = "#sign_in_btnundefined")
    @FindBy(xpath = "//sec-form/sec-sender/button")
    public WebElement btnSignIn;
    //@FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/div/input")
    @FindBy(css = "*[name='remember_me']")
    public WebElement inpRemember;
    //@FindBy(xpath = "//login-modal/div/div/div[3]/a[2]")
    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount;
    @FindBy(css = ".loader")
    public WebElement divLoader;
    @FindBy(css = ".containMiniTitle")
    public WebElement txtLogado;
    @FindBy(xpath = "//label[contains(text(), 'Incorrect')]")
    public WebElement txtErroLogin;
}
