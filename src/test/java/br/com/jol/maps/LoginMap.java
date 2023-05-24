package br.com.jol.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin;
    @FindBy(xpath = "//login-modal/div/div/div[2]")
    public WebElement btnFechar;
    @FindBy(xpath = "//login-modal/div/div")
    public WebElement divFechaModal;
    @FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input")
    public WebElement inpUserName;
    @FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/sec-view[2]/div/label")
    public WebElement inpPassword;
    @FindBy(xpath = "//*[@id=\"sign_in_btnundefined\"]")
    public WebElement btnSignIn;
    @FindBy(xpath = "//login-modal/div/div/div[3]/sec-form/div/input")
    public WebElement inpRemember;
    @FindBy(xpath = "//login-modal/div/div/div[3]/a[2]")
    public WebElement linkCreateAccount;
}
