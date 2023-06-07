package br.com.jol.steps;

import br.com.jol.core.Driver;
import br.com.jol.enums.Browser;
import br.com.jol.pages.LoginPage;
import br.com.jol.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    String username;
    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
        if (cenario.isFailed()){
            Driver.printScreen("erro no cenário");
        }
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        loginPage = new LoginPage();
        Driver.getDriver().get("https://advantageonlineshopping.com/");
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }
    @Quando("for clicado fora da modal")
    public void forClicadoForaDaModal() {
        loginPage.clickDivFechaModal();
    }
    @Entao("a janela modal deve fechar")
    public void aJanelaModalDeveFechar() throws Exception {
        try {
            loginPage.visibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }
    }


    @Quando("clicado no icone de Fechar")
    public void clicadoNoXIconeDeFechar() {
        loginPage.clickBtnFechar();
    }

    @Quando("clicado no link Create new account")
    public void clicadoNoLinkCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina Create new account deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTxtNewAccount());
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma:")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) throws IOException {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);
        loginPage.aguardaLoader();
        if(remember) loginPage.clickRemember();
        Driver.printScreen("preenchimento dos campos de login");
    }

    @E("seja clicado o botao Sign in")
    public void sejaClicadoOBotaoSignIn() {
        loginPage.aguardaLoader();
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
        Driver.printScreen("logado no sistema");
    }

    @Entao("o sistema deve exibir uma mensagem de erro")
    public void oSistemaDeveExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());
    }

    @Entao("o botao Sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        //Assert.assertEquals(false, enabled);
        Assert.assertFalse(enabled);
    }

    @Dado("que esteja logado no sistema com:")
    public void queEstejaLogadoNoSistemaCom(Map<String, String> map) throws IOException {
        queAModalEstejaSendoExibida();
        osCamposDeLoginSejamPreenchidosDaSeguinteForma(map);
        sejaClicadoOBotaoSignIn();
        deveSerPossivelLogarNoSistema();
    }
}
