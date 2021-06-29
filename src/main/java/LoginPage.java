import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    private By txtEmail = By.id("email");
    private By txtPassword = By.name("senha");
    private By btnSubmit = By.xpath("//form[@action='/logar']");
    private By lblMsgError = By.xpath("//div[contains(text(),'Problemas com o login do usuário')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logar(String user, String pass){
        driver.findElement(txtEmail).sendKeys(user);
        driver.findElement(txtPassword).sendKeys(pass);
        driver.findElement(btnSubmit).submit();
    }

    public void verificaMsgErro(){
        new WebDriverWait(driver,2).until(ExpectedConditions.presenceOfElementLocated(lblMsgError));
    }

}
