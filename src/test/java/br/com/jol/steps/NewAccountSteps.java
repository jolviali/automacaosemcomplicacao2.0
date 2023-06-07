package br.com.jol.steps;

import br.com.jol.core.Driver;
import br.com.jol.pages.LoginPage;
import br.com.jol.pages.NewAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class NewAccountSteps {

    NewAccountPage newAccountPage;

    String username;

    @Dado("que a pagina new account esteja sendo exibida")
    public void queAPaginaNewAccountEstejaSendoExibida() {
        newAccountPage = new NewAccountPage();
        Driver.getDriver().get("https://advantageonlineshopping.com/");
        Driver.getDriver().get("https://advantageonlineshopping.com/#/register");
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTxtNewAccount());
    }
    @Quando("os campos de cadastro estiverem preenchidos com")
    public void osCamposDeCadastroEstiveremPreenchidosCom(Map<String, String> map) {
        username = map.get("username");
        newAccountPage.setInpUsername(map.get("username"));
        newAccountPage.setInpEmail(map.get("email"));
        newAccountPage.setInpPassword(map.get("password"));
        newAccountPage.setInpConfirmPassword(map.get("password"));
        newAccountPage.selectCountry(map.get("country"));
        newAccountPage.clickInpAgree();
        newAccountPage.clickBtnRegister();
    }
    @Entao("deve ser possivel criar conta")
    public void deveSerPossivelCriarConta() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
    }
}
