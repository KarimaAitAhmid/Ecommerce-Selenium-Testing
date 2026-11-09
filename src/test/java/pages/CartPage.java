package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // Locator du nom du produit dans le panier.
    private By productName =
            By.className("inventory_item_name");

    // Locator du bouton Remove du sac à dos.
    private By removeBackpack =
            By.id("remove-sauce-labs-backpack");

    // Locator de tous les produits présents dans le panier.
    private By cartProducts =
            By.className("cart_item");

    // Locator du bouton Checkout.
    private By checkoutButton =
            By.id("checkout");

    // Constructeur.
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Récupérer le nom du produit.
    public String getProductName() {

        return waitForVisibility(productName).getText();
    }

    // Supprimer le sac à dos du panier.
    public void removeBackpack() {

        waitForClickability(removeBackpack).click();
    }

    // Compter le nombre de produits dans le panier.
    public int getCartProductsCount() {

        // findElements retourne une liste vide si aucun élément
        // correspondant n'est trouvé.
        // size() retourne donc 0 si le panier est vide.
        return driver.findElements(cartProducts).size();
    }

    // Accéder à la page Checkout.
    public void clickCheckout() {

        waitForClickability(checkoutButton).click();
    }
}
