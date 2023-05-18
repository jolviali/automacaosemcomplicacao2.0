package br.com.jol.pages;

import br.com.jol.maps.PrincipalMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrincipalPage {
    private WebDriver driver;
    private PrincipalMap principalMap;

    public PrincipalPage(WebDriver driver) {
        this.driver = driver;
        principalMap = new PrincipalMap();
        PageFactory.initElements(driver, principalMap);
    }
    /*public String getTitulo() {
        String xpathTitulo = "//section[2]//h4";
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        return titulo;
    }*/
    public String getTitulo(){
        return principalMap.txtTitulo.getText();
    }
    /*public void clickBotao() {
        String xpathBotao = "//div[3]/div/div/div/div/div[2]//a";
        WebElement btnTitulo = driver.findElement(By.xpath((xpathBotao)));
        btnTitulo.click();
    }*/
    public void clickBotao(){
        principalMap.btnTitulo.click();
    }
}
