package br.com.jol.pages;

import br.com.jol.maps.CursoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CursoPage {
    private WebDriver driver;
    private CursoMap cursoMap;
    public CursoPage(WebDriver driver) {
        cursoMap = new CursoMap();
        this.driver = driver;
        PageFactory.initElements(driver, cursoMap);
    }
    /*public String getTitulo2() {
        String xpathTitulo = "//section[4]/div/div/div[1]/div/div";
        WebElement h2titulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = h2titulo.getText();
        return titulo;
    }*/
    public String getTitulo2(){
        return cursoMap.h2titulo.getText();
    }
}
