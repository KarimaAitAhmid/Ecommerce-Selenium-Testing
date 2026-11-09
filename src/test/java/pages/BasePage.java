package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {

    // WebDriver est utilisé pour contrôler le navigateur.
    // protected permet aux classes filles d'utiliser driver.
    protected WebDriver driver;

    // WebDriverWait permet de réaliser des attentes explicites.
    protected WebDriverWait wait;

    // Constructeur : reçoit le navigateur créé dans BaseTest.
    public BasePage(WebDriver driver) {

        this.driver = driver;

        // Attendre au maximum 10 secondes si un élément
        // n'est pas immédiatement disponible.
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Attendre qu'un élément soit visible sur la page.
    protected WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Attendre qu'un élément soit cliquable.
    protected WebElement waitForClickability(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
}
