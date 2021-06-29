import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLoginComCredenciasValidas(){
       new LoginPage(driver).logar("teste123@teste.com.br","1234");
       new MenuPrincipalPage(driver).validaSeMenuPrincipalFoiApresentado();
    }

    @Test
    public void testLoginComCredciaisInvalidas(){
       new LoginPage(driver).logar("teste123@teste.com.br","12345678900000");
       new LoginPage(driver).verificaMsgErro();
    }

}
