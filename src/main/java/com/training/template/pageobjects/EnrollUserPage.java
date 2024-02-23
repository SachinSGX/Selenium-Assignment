package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class EnrollUserPage extends BasePageObject {

    private WebObject emailField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[1]/div/form/div/div[1]/div/div/div/div/div/input");
    private WebObject addToListBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[1]/div/form/div/div[2]/button");
    private WebObject confirmEnrollmentBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[2]/div/div[2]/div[1]/button");

    public EnrollUserPage(WebDriver driver) {
        super(driver);
    }

    public void enrollUser(String email) throws InterruptedException {
        emailField.writeText(email);;
        addToListBtn.click();
        Thread.sleep(500);
    }

    public UserRoasterPage confirmEnrollment() {
        confirmEnrollmentBtn.click();
        return new UserRoasterPage(driver);
    }
}
