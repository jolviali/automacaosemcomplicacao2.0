package br.com.jol.pages;

import br.com.jol.core.Driver;
import br.com.jol.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }
    public void clickBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }
    public void clickBtnFechar(){
        loginMap.btnFechar.click();
    }
    public void clickDivFechaModal(){
        loginMap.divFechaModal.click();
    }
    public void setInpUserName(String userName){
        if (userName != null){
            loginMap.inpUserName.sendKeys(userName);
        }
    }
    public void setInpPassword(String password){
        if (password != null){
            loginMap.inpPassword.sendKeys((password));
        }
    }
    public void clickRemember(){
        loginMap.inpRemember.click();
    }
    public void clickLinkCreateAccount(){
        loginMap.linkCreateAccount.click();
    }
    public void clickBtnSignIn(){
        loginMap.btnSignIn.click();
    }
    public boolean isBtnSignIn(){
        return loginMap.btnSignIn.isEnabled();
    }

    public void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
    }

    public void invisibilityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.btnFechar);
    }

    public void aguardaLoader(){
        Driver.attributeChange(loginMap.divLoader, "display", "none");
    }
}
