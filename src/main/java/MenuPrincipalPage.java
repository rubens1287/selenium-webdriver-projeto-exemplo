import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipalPage {

    WebDriver driver;
    private By lnkSair = By.linkText("Sair");

    public MenuPrincipalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validaSeMenuPrincipalFoiApresentado(){
        new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(lnkSair));
    }

}
