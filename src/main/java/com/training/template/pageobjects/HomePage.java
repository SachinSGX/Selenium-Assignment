package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    private WebObject loginBtn = WebObject.setElement(How.XPATH, "/html/body/div/div/div[3]/div/div/div[1]/div/nav/div/div[2]/div[4]/button/div/div[text()=\"LOGIN\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginBtnDisplayed() {
        return loginBtn.isDisplayed();
    }
}
