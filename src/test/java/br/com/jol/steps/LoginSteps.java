package br.com.jol.steps;

import br.com.jol.core.Driver;
import br.com.jol.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    @Before
    public void iniciaNavegador(){
        new Driver("chrome");
    }

    @After
    public void fechaNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        loginPage = new LoginPage();
        Driver.getDriver().get("https://advantageonlineshopping.com/");
        loginPage.clickBtnLogin();
    }
    @Quando("for clicado fora da modal")
    public void forClicadoForaDaModal() {
        loginPage.clickDivFechaModal();
    }
    @Entao("a janela modal deve fechar")
    public void aJanelaModalDeveFechar() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }
    }


    @Quando("clicado no {string} \\(icone de Fechar)")
    public void clicadoNoXIconeDeFechar() {
        loginPage.clickBtnFechar();
    }

    @Quando("clicado no link {string}")
    public void clicadoNoLinkCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina {string} deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() {
        
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma:")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) {
        String username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);
        if(remember) loginPage.clickRemember();
    }

    @E("seja clicado o botao {string}")
    public void sejaClicadoOBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        
    }

    @Entao("o sistema deve exibir uma mensagem de erro")
    public void oSistemaDeveExibirUmaMensagemDeErro() {
        
    }

    @Entao("o botao Sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        //Assert.assertEquals(false, enabled);
        Assert.assertFalse(enabled);
    }
}
