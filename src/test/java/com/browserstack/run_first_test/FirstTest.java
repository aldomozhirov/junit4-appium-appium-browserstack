package com.browserstack.run_first_test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstTest extends BrowserStackJUnitTest {

  @Test
  public void test() throws Exception {
    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
    searchElement.click();
    AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
    insertTextElement.sendKeys("BrowserStack");
    Thread.sleep(5000);

    List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
    assertTrue(false);

    JavascriptExecutor jse = driver;
    // set test status as pass
    // jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
    // set test status as fail
    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Title not matched\"}}");
  }
}
