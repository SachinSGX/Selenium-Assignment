package com.training.template.util;

import com.training.template.enums.How;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebObject implements WebElement {

    private How how;
    private String locatorValue;
    private static WebDriver driver;

    private WebObject(How how, String locatorValue) {
        this.how = how;
        this.locatorValue = locatorValue;
    }

    public static WebObject setElement(How how, String locatorValue) {
        return new WebObject(how, locatorValue);
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    private WebElement getElement() {
        switch (how){
            case ID:
                return driver.findElement(By.id(locatorValue));
            case NAME:
                return driver.findElement(By.name(locatorValue));
            case XPATH:
                return driver.findElement(By.xpath(locatorValue));
            case CLASSNAME:
                return driver.findElement(By.className(locatorValue));
            case TAGNAME:
                return driver.findElement(By.tagName(locatorValue));
            case CSSSELECTOR:
                return driver.findElement(By.cssSelector(locatorValue));
            default:
                throw new IllegalStateException("Unexpected value: " + how);
        }
    }

    public void click() {

        try {
            waitVisibility();
            waitToBeClickable();
            getElement().click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }

    public void waitStableAndClick() throws InterruptedException {

        int attempts = 0;
        int MAX_RETRY = 2;

        while (attempts < MAX_RETRY) {
            try {
                waitToBeStable();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                Thread.sleep(1000);
            } catch (ElementClickInterceptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void hoverAndClick(WebObject webObject) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).perform();
        webObject.click();
    }

    public void clickUsingJsExecutor() {

        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",getElement());
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }

    public void selectElementByText(String text) {
        waitVisibility();
        Select dropDownElement = new Select(getElement());
        dropDownElement.selectByVisibleText(text);
    }

    public void writeText(String text) {
        waitVisibility();
        getElement().sendKeys(text);
    }

    public void writeTextWithOutWaiting(String text) {
        getElement().sendKeys(text);
    }

    public void clearAndWriteText(String text) {
        waitVisibility();
        getElement().clear();
        getElement().sendKeys(text);
    }

    public String readText() throws InterruptedException {

        int attempts = 0;
        int MAX_RETRY = 2;
        String text = "";

        while (attempts < MAX_RETRY) {
            try {
                waitVisibility();
                text = getElement().getText();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                Thread.sleep(1000);
            } catch (ElementClickInterceptedException e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public void waitVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getElement()));
    }

    public void waitToBeClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(getElement()));
    }

    public void waitToBeStable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue))).click();
    }

    public boolean isDisplayed() {

        try {
            return getElement().isDisplayed();

        } catch (StaleElementReferenceException e) {
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {
        getElement().clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
