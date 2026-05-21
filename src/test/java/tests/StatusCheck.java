package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebPage;

public class StatusCheck extends BaseTest {

    @Test

    public void checkPlainLassi() {
        WebPage page = new WebPage(driver);
        page.openPage(WebPage.LINK1);
        page.setZipCode("751024");
        String status = page.getStockStatus();
        Assert.assertFalse(
                status.contains("Sold Out"),
                "Plain Lassi is back in stock!"
        );

    }
    @Test
    public void checkRoseLassi() {
        WebPage page = new WebPage(driver);
        page.openPage(WebPage.LINK2);
        String status = page.getStockStatus();
        Assert.assertFalse(
                status.contains("Sold Out"),
                "Plain Lassi is back in stock!");
    }
}