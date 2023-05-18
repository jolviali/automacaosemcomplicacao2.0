package br.com.jol.automacaoWeb;

import br.com.jol.core.Driver;
import br.com.jol.pages.CursoPage;
import br.com.jol.pages.PrincipalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TesteWeb {
    Driver driverWeb;
    WebDriver driver;
    PrincipalPage principalPage;
    CursoPage cursoPage;
    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("edge");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }
    @Test
    public void primeiroTeste() {
        String titulo = principalPage.getTitulo();
        assertEquals("Porque Tempo É Conhecimento.", titulo);
    }
    @Test
    public void segundoTeste(){
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        String titulo = cursoPage.getTitulo2();
        assertEquals("Conheça todos os nossos cursos.", titulo);
    }
    @After
    public void finalizaTeste() {
        driver.quit();
    }
}
