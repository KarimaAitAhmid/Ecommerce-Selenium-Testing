package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    // Locator du titre de la page.
    private By pageTitle = By.className("title");

    // Locator du bouton Add to cart du sac à dos.
    private By addBackpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    // Locator de l'icône du panier.
    private By cartIcon =
            By.className("shopping_cart_link");

    // Locator de la liste de tri des produits.
    private By sortDropdown =
            By.className("product_sort_container");

    // Locator de tous les prix affichés.
    private By productPrices =
            By.className("inventory_item_price");

    // Constructeur.
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Récupérer le titre de la page.
    public String getPageTitle() {

        return waitForVisibility(pageTitle).getText();
    }

    // Ajouter le sac à dos au panier.
    public void addBackpackToCart() {

        waitForClickability(addBackpackButton).click();
    }

    // Ouvrir le panier.
    public void openCart() {

        waitForClickability(cartIcon).click();
    }

    // Trier les produits du prix le plus bas au plus élevé.
    public void sortByPriceLowToHigh() {

        // Récupérer la liste déroulante.
        WebElement dropdown = waitForVisibility(sortDropdown);

        // La classe Select permet de manipuler les listes HTML select.
        Select select = new Select(dropdown);

        // Choisir l'option Price (low to high).
        select.selectByValue("lohi");
    }

    // Récupérer les prix de tous les produits.
    public List<Double> getProductPrices() {

        // Attendre que le premier prix soit visible.
        waitForVisibility(productPrices);

        // Récupérer tous les éléments qui contiennent un prix.
        List<WebElement> elements =
                driver.findElements(productPrices);

        // Liste qui va contenir les prix sous forme de nombres.
        List<Double> prices = new ArrayList<>();

        for (WebElement element : elements) {

            // Récupérer le texte, par exemple "$29.99".
            String priceText = element.getText();

            // Supprimer le symbole $ et convertir en double.
            double price = Double.parseDouble(
                    priceText.replace("$", "")
            );

            prices.add(price);
        }

        return prices;
    }
}
