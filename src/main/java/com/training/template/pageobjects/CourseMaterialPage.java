package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class CourseMaterialPage extends BasePageObject {

    private WebObject addLessonBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[2]/div[2]/button");
    private WebObject lessonNameField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[4]/div/div/div/div/form/div[1]/div/div/div/div/div/input");
    private WebObject descriptionField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[4]/div/div/div/div/form/div[2]/div/div/div/div/div/textarea");
    private WebObject includeUnitsBtn = WebObject.setElement(How.XPATH, "//div[@id=\"root\"]/div/div[3]/div/section/div/section/div/div/div[2]/section/div/div/div/div[4]/div/div/div/div/form/div[3]/div/div/input");
    private WebObject lessonSaveBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[4]/div/div/div/div/form/div[5]/div[1]/button");
    private WebObject lessonOptionBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[3]/div/div/div/div/div/div/div/h2/button/div/div/div[3]/div/div[1]/div/div");
    private WebObject addUnitBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[3]/div/div/div/div/div/div/div/h2/button/div/div/div[3]/div/div[2]/div/div/div[3]/div/div");
    private WebObject unitNameField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[6]/div/div/div/div/form/div[1]/div/div/div/div/div/input");
    private WebObject unitSaveBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[6]/div/div/div/div/form/div[2]/div[1]/button");
    private WebObject viewUnitBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div[3]/button");
    private WebObject userRoasterTab = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/nav/div/div/div[2]/div/div[5]/div");
    private WebObject coursesBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/nav/div/div[1]/div[2]/div[2]");

    public CourseMaterialPage(WebDriver driver) {
        super(driver);
    }

    public CourseMaterialPage clickAddLesson() {
        addLessonBtn.clickUsingJsExecutor();
        return this;
    }

    public CourseMaterialPage setLessonName(String lessonName) {
        lessonNameField.writeText(lessonName);
        return this;
    }

    public CourseMaterialPage setDescription(String description) {
        descriptionField.writeText(description);
        return this;
    }

    public CourseMaterialPage setIncludeUnits(boolean isUnitsAllowed) {
        if (isUnitsAllowed == false) {
            includeUnitsBtn.click();
        }
        return this;
    }

    public CourseMaterialPage saveLesson() {
        lessonSaveBtn.click();
        return this;
    }

    public CourseMaterialPage clickAddUnit() {
        lessonOptionBtn.hoverAndClick(addUnitBtn);
        return this;
    }

    public CourseMaterialPage setUnitName(String unitName) {
        unitNameField.writeText(unitName);
        return this;
    }

    public CourseMaterialPage saveUnit() {
        unitSaveBtn.click();
        return this;
    }

    public CourseChaptersPage navigateToCourseChaptersPage() {
        viewUnitBtn.click();
        return new CourseChaptersPage(driver);
    }

    public UserRoasterPage navigateToUserRoasterPage() {
        userRoasterTab.click();
        return new UserRoasterPage(driver);
    }

    public BasePage navigateToBasePage() {
        coursesBtn.click();
        return new BasePage(driver);
    }

}
