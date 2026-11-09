package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CartTest extends BaseTest {

    // TEST 1 : Ajouter un produit au panier.
    @Test
    public void addProductToCartTest() {

        // 1. Se connecter.
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Accéder à la page des produits.
        InventoryPage inventory = new InventoryPage(driver);

        // 3. Ajouter le sac à dos au panier.
        inventory.addBackpackToCart();

        // 4. Ouvrir le panier.
        inventory.openCart();

        // 5. Récupérer le nom du produit.
        CartPage cart = new CartPage(driver);
        String actualProductName = cart.getProductName();

        // 6. Vérifier que le bon produit est présent.
        Assert.assertEquals(
                actualProductName,
                "Sauce Labs Backpack",
                "Le produit n'est pas présent dans le panier"
        );
    }

    // TEST 2 : Trier les produits par prix croissant.
    @Test
    public void sortProductsByPriceTest() {

        // 1. Se connecter.
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Accéder à la page des produits.
        InventoryPage inventory = new InventoryPage(driver);

        // 3. Trier du prix le plus bas au plus élevé.
        inventory.sortByPriceLowToHigh();

        // 4. Récupérer les prix après le tri.
        List<Double> actualPrices = inventory.getProductPrices();

        // 5. Créer une copie de la liste des prix.
        List<Double> expectedPrices =
                new ArrayList<>(actualPrices);

        // 6. Trier la copie en ordre croissant.
        Collections.sort(expectedPrices);

        // 7. Comparer les deux listes.
        Assert.assertEquals(
                actualPrices,
                expectedPrices,
                "Les produits ne sont pas triés par prix croissant"
        );
    }

    // TEST 3 : Supprimer un produit du panier.
    @Test
    public void removeProductFromCartTest() {

        // 1. Se connecter.
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Ajouter le produit.
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        // 3. Ouvrir le panier.
        inventory.openCart();

        // 4. Créer l'objet CartPage.
        CartPage cart = new CartPage(driver);

        // 5. Supprimer le produit.
        cart.removeBackpack();

        // 6. Vérifier que le panier est vide.
        Assert.assertEquals(
                cart.getCartProductsCount(),
                0,
                "Le produit n'a pas été supprimé"
        );
    }

    // TEST 4 : Accéder à la page Checkout.
    @Test
    public void accessCheckoutTest() {

        // 1. Se connecter.
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Ajouter un produit.
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        // 3. Ouvrir le panier.
        inventory.openCart();

        // 4. Accéder au Checkout.
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // 5. Vérifier l'affichage du formulaire.
        CheckoutPage checkout = new CheckoutPage(driver);

        Assert.assertEquals(
                checkout.getPageTitle(),
                "Checkout: Your Information",
                "Le formulaire Checkout ne s'affiche pas"
        );
    }

    // TEST 5 : Effectuer une commande complète.
    @Test
    public void completeOrderTest() {

        // 1. Se connecter.
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Ajouter un produit au panier.
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        // 3. Ouvrir le panier.
        inventory.openCart();

        // 4. Accéder au Checkout.
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // 5. Remplir les informations du client.
        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.fillCustomerInformation(
                "Karima",
                "Ait Ahmid",
                "25000"
        );

        // 6. Continuer vers le récapitulatif.
        checkout.clickContinue();

        // 7. Vérifier la page récapitulative.
        Assert.assertEquals(
                checkout.getPageTitle(),
                "Checkout: Overview",
                "Le récapitulatif de commande ne s'affiche pas"
        );

        // 8. Confirmer la commande.
        checkout.clickFinish();

        // 9. Vérifier le message de confirmation.
        Assert.assertEquals(
                checkout.getConfirmationMessage(),
                "Thank you for your order!",
                "La commande n'a pas été confirmée"
        );
    }
}
