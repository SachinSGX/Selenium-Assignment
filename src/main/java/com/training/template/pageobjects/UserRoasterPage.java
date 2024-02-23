package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class UserRoasterPage extends BasePageObject {

    private WebObject enrollUserBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[1]/div[2]/button");

    public UserRoasterPage(WebDriver driver) {
        super(driver);
    }

    public EnrollUserPage navigateToEnrollUserPage() {
        enrollUserBtn.click();
        return new EnrollUserPage(driver);
    }
}
