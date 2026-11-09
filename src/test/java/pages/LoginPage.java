
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators : identifier les éléments HTML de la page.
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    // Locator du message d'erreur.
    private By errorMessage =
            By.cssSelector("[data-test='error']");

    // Constructeur.
    // super(driver) appelle le constructeur de BasePage.
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Saisir le nom d'utilisateur.
    public void enterUsername(String user) {

        waitForVisibility(username).sendKeys(user);
    }

    // Saisir le mot de passe.
    public void enterPassword(String pass) {

        waitForVisibility(password).sendKeys(pass);
    }

    // Cliquer sur le bouton Login.
    public void clickLogin() {

        waitForClickability(loginButton).click();
    }

    // Méthode qui regroupe toutes les étapes de connexion.
    public void login(String user, String pass) {

        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // Récupérer le message d'erreur.
    public String getErrorMessage() {

        return waitForVisibility(errorMessage).getText();
    }
}
