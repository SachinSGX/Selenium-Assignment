package com.training.template.pageobjects;

import com.training.template.enums.*;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;


public class AddCoursePage extends BasePageObject {

    private final WebObject courseModeDropDown = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[2]/div/div/div/div/div/div[1]/div[2]");
    private final WebObject onDemand = WebObject.setElement(How.XPATH, "//*[text()=\"On Demand\"]");
    private final WebObject liveClasses = WebObject.setElement(How.XPATH, "//*[text()=\"Live Classes\"]");
    private final WebObject courseNameField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[3]/div/div/div/div/div/input");
    private final WebObject courseTypeDropDown = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[4]/div[1]/div/div/div/div/div[1]/div[2]");
    private final WebObject course = WebObject.setElement(How.XPATH, "//*[text()=\"Course\"]");
    private final WebObject difficultyLevelDropDown = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[4]/div[2]/div/div/div/div/div[1]");
    private final WebObject beginner = WebObject.setElement(How.XPATH, "//*[text()=\"Beginner\"]");
    private final WebObject courseDescriptionField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[5]/div/div/div/div/div/textarea");
    private final WebObject specializationDropDown = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[1]/div/div/div/div/div[1]/div[2]");
    private final WebObject estimatedCourseDurationField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[2]/div/div/div/div/input");
    private final WebObject iot = WebObject.setElement(How.XPATH, "//*[text()=\"Internet of Things\"]");
    private final WebObject coverImage = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[7]/div[1]/div[2]/div/div/div/div/div[1]/input");
    private final WebObject classScheduleFrame = WebObject.setElement(How.CSSSELECTOR, "#tiny-react_47305674041706377362588_ifr");
    private final WebObject frameBody = WebObject.setElement(How.TAGNAME, "body");
    private final WebObject addPointBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div/div/button");
    private final WebObject titleField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div[1]/div[1]/div/input");
    private final WebObject descriptionField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div[1]/div[2]/div/input");
    private final WebObject addAnExpertBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div/div/button");
    private final WebObject nameField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div[1]/div[1]/div/input");
    private final WebObject designationField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div[1]/div[2]/div/input");
    private final WebObject addAFaqBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[15]/div/div/div/div/div[2]/div/div/button");
    private final WebObject questionField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[15]/div/div/div/div/div[2]/div[1]/div[1]/div/input");
    private final WebObject answerField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[15]/div/div/div/div/div[2]/div[1]/div[2]/div/input");
    private final WebObject paidRadioBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[16]/div/div/div/div/div[2]/div[1]/div/div/div[1]/input");
    private final WebObject freeRadioBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[16]/div/div/div/div/div[2]/div[1]/div/div/div[2]/input");
    private final WebObject couponToggle = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[16]/div/div/div/div/div[2]/div[2]/div[2]/div/input");
    private final WebObject basePriceField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[16]/div/div/div/div/div[2]/div[3]/div/div/div/div/div/input");
    private final WebObject saveAndPublishBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[17]/div[1]/button/div/div");
    private final WebObject registrationStartDate = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[1]/div[2]/div/div[1]/div");
    private final WebObject registrationEndDate = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[2]/div[2]/div/div[1]/div");
    private final WebObject courseStartDate = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[7]/div[1]/div[2]/div/div[1]/div");
    private final WebObject courseEndDate = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[7]/div[2]/div[2]/div/div[1]/div");

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public AddCoursePage setCourseMode(CourseMode courseMode) {
        courseModeDropDown.click();
        switch (courseMode) {
            case ON_DEMAND:
                onDemand.click();
                return this;
            case LIVE_CLASSES:
                liveClasses.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected value: " + courseMode);
        }
    }

    public AddCoursePage setCourseName(String name) {
        courseNameField.writeText(name);
        return this;
    }

    public AddCoursePage setCourseType(CourseType courseType) {
        courseTypeDropDown.click();
        switch (courseType) {
            case COURSE:
                course.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected value: " + courseType);
        }
    }

    public AddCoursePage setDifficultyLevel(DifficultyLevel difficultyLevel) {
        difficultyLevelDropDown.click();
        switch (difficultyLevel) {
            case BEGINNER:
                beginner.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected value: " + difficultyLevel);
        }
    }

    public AddCoursePage setCourseDescription(String name) {
        courseDescriptionField.writeText(name);
        return this;
    }

    public AddCoursePage setRegistrationStartDate(String date) {
        registrationStartDate.clearAndWriteText(date);
        return this;
    }

    public AddCoursePage setRegistrationEndDate(String date) {
        registrationEndDate.clearAndWriteText(date);
        return this;
    }

    public AddCoursePage setCourseStartDate(String date) {
        courseStartDate.clearAndWriteText(date);
        return this;
    }

    public AddCoursePage setCourseEndDate(String date) {
        courseEndDate.clearAndWriteText(date);
        return this;
    }

    public AddCoursePage setSpecialization(Specialization specialization) {
        specializationDropDown.click();
        switch (specialization) {
            case INTERNETOFTHINGS:
                iot.click();
                return this;
            default:
                throw new IllegalStateException("Unexpected value: " + specialization);
        }
    }

    public AddCoursePage setEstimatedCourseDuration(String text) {
        estimatedCourseDurationField.writeText(text);
        return this;
    }

    public AddCoursePage setCoverImage(String path) {
        coverImage.writeTextWithOutWaiting(path);
        return this;
    }

    public AddCoursePage setClassSchedule(String text, Integer frameIndex) {
        driver.switchTo().frame(frameIndex);
        frameBody.click();
        frameBody.writeTextWithOutWaiting(text);
        driver.switchTo().defaultContent();
        return this;
    }

    public AddCoursePage setCourseOutline(String title, String description) {
        addPointBtn.click();
        titleField.writeText(title);
        descriptionField.writeText(description);
        return this;
    }

    public AddCoursePage setExpertPanel(String name, String designation) {
        addAnExpertBtn.click();
        nameField.writeText(name);
        designationField.writeText(designation);
        return this;
    }

    public AddCoursePage setFaqs(String question, String answer) {
        addAFaqBtn.click();
        questionField.writeText(question);
        answerField.writeText(answer);
        return this;
    }

    public AddCoursePage setPricing(boolean isPaid, boolean isCouponAllowed, String price) {
        if (isPaid) {
            if (isCouponAllowed) {
                couponToggle.click();
            }
            basePriceField.writeText(price);
        } else {
            freeRadioBtn.click();
        }
        return this;
    }

    public BasePage saveAndPublish() {
        saveAndPublishBtn.click();
        return new BasePage(driver);
    }
}
