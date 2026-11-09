package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    // Champs du formulaire client.
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");

    // Bouton pour continuer vers le récapitulatif.
    private By continueButton = By.id("continue");

    // Bouton pour confirmer la commande.
    private By finishButton = By.id("finish");

    // Titre de la page.
    private By pageTitle = By.className("title");

    // Message affiché après la confirmation de la commande.
    private By confirmationMessage =
            By.className("complete-header");

    // Constructeur.
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Récupérer le titre de la page.
    public String getPageTitle() {

        return waitForVisibility(pageTitle).getText();
    }

    // Remplir les informations du client.
    public void fillCustomerInformation(
            String first,
            String last,
            String postal
    ) {

        waitForVisibility(firstName).sendKeys(first);
        waitForVisibility(lastName).sendKeys(last);
        waitForVisibility(postalCode).sendKeys(postal);
    }

    // Continuer vers le récapitulatif de la commande.
    public void clickContinue() {

        waitForClickability(continueButton).click();
    }

    // Confirmer la commande.
    public void clickFinish() {

        waitForClickability(finishButton).click();
    }

    // Récupérer le message de confirmation.
    public String getConfirmationMessage() {

        return waitForVisibility(confirmationMessage).getText();
    }
}
