package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebPage {
    private WebDriver driver;

    public WebPage(WebDriver driver) {
        this.driver = driver;
    }

    By zipCodeInput = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div/div/form/div/div[3]/input");
    By stockStatus = By.xpath("/html/body/div/div/div/div[5]/div/div/div/div[2]/div[2]/div/div[3]");
    public static final String LINK1 = "https://shop.amul.com/en/product/amul-high-protein-plain-lassi-200-ml-or-pack-of-30";
    public static final String LINK2 = "https://shop.amul.com/en/product/amul-high-protein-rose-lassi-200-ml-or-pack-of-30";

    public void setZipCode(String zipCode) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(zipCodeInput)
        );
        driver.findElement(zipCodeInput).clear();
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        wait.until(
                ExpectedConditions.elementToBeClickable(zipCodeConfirmButton)
        );
        driver.findElement(zipCodeConfirmButton).click();
    }

    public void openPage(String link) {
        driver.get(link);
    }

    public String getStockStatus() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(stockStatus));
        return driver.findElement(stockStatus).getText();
    }

    private final By zipCodeConfirmButton =
            By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[2]/div/div/form/div[2]/div[2]/a/p");
}