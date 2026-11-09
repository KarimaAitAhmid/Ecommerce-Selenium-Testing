package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Lancer Chrome
        driver = new ChromeDriver();

        // Maximiser la fenêtre
        driver.manage().window().maximize();

        // Ouvrir l'application
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        // Fermer la session du navigateur
        if (driver != null) {
            driver.quit();
        }
    }
}
