package br.com.jol.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrincipalMap {
    @FindBy(xpath = "//section[2]//h4")
    public WebElement txtTitulo;
    @FindBy(xpath = "//div[3]/div/div/div/div/div[2]//a")
    public WebElement btnTitulo;
}
