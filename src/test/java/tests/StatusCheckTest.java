package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebPage;

public class StatusCheckTest extends BaseTest {

    @Test
    public void checkPlainLassi() {

        WebPage page = new WebPage(driver);

        page.openPage(WebPage.LINK1);
        page.setZipCode("751024");
        String plainStatus = page.getStockStatus();
        System.out.println("Plain Lassi Status: " + plainStatus);
        if (!plainStatus.contains("Sold Out")) {
            Assert.fail("🚨 Plain Lassi is back in stock!");
        }
        page.openPage(WebPage.LINK2);
        String roseStatus = page.getStockStatus();
        System.out.println("Rose Lassi Status: " + roseStatus);
        if (!roseStatus.contains("Sold Out")) {
            Assert.fail("🚨 Rose Lassi is back in stock!");
        }
    }
}