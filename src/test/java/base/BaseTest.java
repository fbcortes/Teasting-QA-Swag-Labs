//La estructura base de los Test
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Constants;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    //Configuración que se realiza antes de cualquier test donde ejecuta el navegador,
    // la URL y gestionar el navegador incognito.
    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    // Ocurre después de cada test. Esta función nos permite cerrar el navegador una vez que termine el test o falle.
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
