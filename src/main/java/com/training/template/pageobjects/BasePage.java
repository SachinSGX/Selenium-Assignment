package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class BasePage extends BasePageObject {

    private WebObject coursesLbl = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[1]/div[1]/div/p[text()=\"Courses\"]");
    private WebObject addCourseBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[1]/div[2]/button/div/div[text()=\"Add Course\"]");
    private WebObject logOutBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/nav/div/div[2]/div[3]/span/p[text()=\"Log Out\"]");
    private WebObject toastMessage = WebObject.setElement(How.XPATH, "//div[@id=\"root\"]/div/div/div/div/div/div[2]");
    private WebObject closeToastMessageBtn = WebObject.setElement(How.XPATH, "//div[@id=\"root\"]/div/div/div/div/button");
    private WebObject createdCourseName = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]");
    private WebObject createdCourseType = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div");
    private WebObject createdCourseSpecialization = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div");
    private WebObject viewBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/div[1]/button");
    private WebObject courseOptionsBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/div[2]");
    private WebObject editCourseOption = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/div[2]/div/div/div/div/div[1]/div/div");
    private WebObject deleteCourseOption = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/div/div[2]/div/div/div/div/div[2]/div/div");
    private WebObject deleteBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1]/button");
    private WebObject deleteCancelBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div[2]/button");
    private WebObject deleteModelHeader = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[2]/div[3]/div[1]/div/div[2]/div/header/div[1]");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCoursesLblDisplayed() {
        return coursesLbl.isDisplayed();
    }

    public AddCoursePage navigateToAddCoursePage() {
        addCourseBtn.click();
        return new AddCoursePage(driver);
    }

    public String validateToastMessageAppearance() throws InterruptedException {
        return toastMessage.readText();
    }

    public void closeToastMessage() throws InterruptedException {
        closeToastMessageBtn.waitStableAndClick();
    }

    public String validateCourseName() throws InterruptedException {
        return createdCourseName.readText();
    }

    public String validateCourseType() throws InterruptedException {
        return createdCourseType.readText();
    }

    public String validateSpecialization() throws InterruptedException {
        return createdCourseSpecialization.readText();
    }

    public CourseMaterialPage navigateToCourseMaterialPage() {
        viewBtn.click();
        return new CourseMaterialPage(driver);
    }

    public UpdateCoursePage navigateToCourseUpdatePage() {
        courseOptionsBtn.hoverAndClick(editCourseOption);
        return new UpdateCoursePage(driver);
    }

    public BasePage deleteCourse(String courseName) throws InterruptedException {
        courseOptionsBtn.hoverAndClick(deleteCourseOption);
        if (deleteModelHeader.readText().equals("Delete {courseName}?".replace("{courseName}", courseName))) {
            deleteBtn.click();
        } else {
            deleteCancelBtn.click();
            System.out.println("You're trying to delete wrong course!");
        }
        return this;
    }

    public HomePage clickLogoutBtn() {
        logOutBtn.click();
        return new HomePage(driver);
    }

}
