package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private WebObject emailField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/div/div/div/input[@name=\"email\"]");
    private WebObject passwordField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/div/div/div/div/input[@name=\"password\"]");
    private WebObject loginBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[5]/div/button/div/div[text()=\"Log In\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.writeText(email);
    }

    public void enterPassword(String password) {
        passwordField.writeText(password);
    }

    public BasePage clickLoginBtn() {
        loginBtn.click();
        return new BasePage(driver);
    }

}
