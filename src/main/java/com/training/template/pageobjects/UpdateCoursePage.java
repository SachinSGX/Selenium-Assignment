package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class UpdateCoursePage extends BasePageObject {

    private WebObject courseNameField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[3]/div/div/div/div/div/input");
    private WebObject updateAndPublishBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[17]/div[1]/button");

    public UpdateCoursePage(WebDriver driver) {
        super(driver);
    }

    public UpdateCoursePage updateCourseName(String newCourseName) {
        courseNameField.clearAndWriteText(newCourseName);
        return this;
    }

    public BasePage updateAndPublish() {
        updateAndPublishBtn.click();
        return new BasePage(driver);
    }
}
