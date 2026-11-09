package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pages.LoginPage;
import pages.InventoryPage;

public class LoginTest extends BaseTest {

    // DataProvider fournit plusieurs jeux de données
    // à une même méthode de test.
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][] {

                // Cas 1 : Mot de passe incorrect.
                {
                        "standard_user",
                        "wrong_password",
                        "Username and password do not match"
                },

                // Cas 2 : Username vide.
                {
                        "",
                        "secret_sauce",
                        "Username is required"
                },

                // Cas 3 : Password vide.
                {
                        "standard_user",
                        "",
                        "Password is required"
                }
        };
    }

    // TEST 1 : Connexion réussie.
    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);

        // Saisir les identifiants valides.
        login.login("standard_user", "secret_sauce");

        // Créer l'objet représentant la page des produits.
        InventoryPage inventory = new InventoryPage(driver);

        // Vérifier que la page des produits est affichée.
        Assert.assertEquals(
                inventory.getPageTitle(),
                "Products",
                "La connexion a échoué"
        );
    }

    // TEST 2 : Tester les différentes connexions incorrectes.
    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(
            String username,
            String password,
            String expectedMessage
    ) {

        LoginPage login = new LoginPage(driver);

        // Utiliser les données fournies par le DataProvider.
        login.login(username, password);

        // Récupérer le message réellement affiché.
        String actualMessage = login.getErrorMessage();

        // Vérifier que le message attendu est présent.
        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "Le message d'erreur est incorrect"
        );
    }
}
