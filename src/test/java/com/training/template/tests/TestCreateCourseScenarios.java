package com.training.template.tests;

import com.training.template.constants.Constants;
import com.training.template.enums.CourseMode;
import com.training.template.enums.CourseType;
import com.training.template.enums.DifficultyLevel;
import com.training.template.enums.Specialization;
import com.training.template.pageobjects.AddCoursePage;
import com.training.template.pageobjects.BasePage;
import com.training.template.pageobjects.LoginPage;
import com.training.template.reporting.ExtentTestManager;
import com.training.template.util.BaseTestObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestCreateCourseScenarios extends BaseTestObject {

    private LoginPage loginPage;
    private BasePage basePage;
    private AddCoursePage addCoursePage;


    @BeforeClass
    public void testSetUp() {

        try {
            driver.get(testData.get("baseUrl"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testLogin(Method method) {

        try {
            ExtentTestManager.startTest(method.getName(), "Valid Login Scenario with invalid username and password.");

            loginPage = new LoginPage(driver);
            loginPage.enterEmail(testData.get("email"));
            loginPage.enterPassword(testData.get("password"));
            basePage = loginPage.clickLoginBtn();

            Assert.assertTrue(basePage.isCoursesLblDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testLogin")
    public void testCreateOnDemandCourseMandatoryFieldsPaid(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create New Course Scenario");

            addCoursePage = basePage.navigateToAddCoursePage();
            addCoursePage
                    .setCourseMode(CourseMode.valueOf(testData.get("tcod002_courseMode").toUpperCase()))
                    .setCourseName(testData.get("tcod002_courseName"))
                    .setCourseType(CourseType.valueOf(testData.get("tcod002_courseType").toUpperCase()))
                    .setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod002_difficultyLevel").toUpperCase()))
                    .setCourseDescription(testData.get("tcod002_courseDescription"))
                    .setSpecialization(Specialization.valueOf(testData.get("tcod002_specialization").replaceAll("\\s","").toUpperCase()))
                    .setEstimatedCourseDuration(testData.get("tcod002_estimatedCourseDuration"))
                    .setCoverImage(testData.get("tcod002_coverImagePath"))
                    .setClassSchedule(testData.get("tcod002_classSchedule"), 3)
                    .setCourseOutline(testData.get("tcod002_title"),testData.get("tcod002_description"))
                    .setExpertPanel(testData.get("tcod002_name"),testData.get("tcod002_designation"))
                    .setPricing(Boolean.parseBoolean(testData.get("tcod002_isPaid")),Boolean.parseBoolean(testData.get("tcod002_isCouponAllowed")),testData.get("tcod002_price"))
                    .saveAndPublish();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_COURSE_SUCCESS_TOAST);
            basePage.closeToastMessage();

            refreshPage(); //for skipping the bug
            Assert.assertEquals(basePage.validateCourseType(),testData.get("tcod002_courseType"));
            Assert.assertEquals(basePage.validateSpecialization(),testData.get("tcod002_specialization"));
            Assert.assertEquals(basePage.validateCourseName(),testData.get("tcod002_courseName"));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testCreateOnDemandCourseMandatoryFieldsPaid")
    public void testCreateLiveClassMandatoryFieldsPaid(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create New Course Scenario");

            addCoursePage = basePage.navigateToAddCoursePage();
            addCoursePage
                    .setCourseMode(CourseMode.valueOf(testData.get("tcod004_courseMode").toUpperCase()))
                    .setCourseName(testData.get("tcod004_courseName"))
                    .setCourseType(CourseType.valueOf(testData.get("tcod004_courseType").toUpperCase()))
                    .setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod004_difficultyLevel").toUpperCase()))
                    .setCourseDescription(testData.get("tcod004_courseDescription"))
                    .setRegistrationStartDate(testData.get("tcod004_registrationStartDate"))
                    .setRegistrationEndDate(testData.get("tcod004_registrationEndDate"))
                    .setCourseStartDate(testData.get("tcod004_courseStartDate"))
                    .setCourseEndDate(testData.get("tcod004_courseEndDate"))
                    .setSpecialization(Specialization.valueOf(testData.get("tcod004_specialization").replaceAll("\\s","").toUpperCase()))
                    .setCoverImage(testData.get("tcod004_coverImagePath"))
                    .setClassSchedule(testData.get("tcod004_classSchedule"), 3)
                    .setCourseOutline(testData.get("tcod004_title"),testData.get("tcod004_description"))
                    .setExpertPanel(testData.get("tcod004_name"),testData.get("tcod004_designation"))
                    .setPricing(Boolean.parseBoolean(testData.get("tcod004_isPaid")),Boolean.parseBoolean(testData.get("tcod004_isCouponAllowed")),testData.get("tcod004_price"))
                    .saveAndPublish();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_COURSE_SUCCESS_TOAST);
            basePage.closeToastMessage();

            Assert.assertEquals(basePage.validateCourseType(),testData.get("tcod004_courseType"));
            Assert.assertEquals(basePage.validateSpecialization(),testData.get("tcod004_specialization"));
            Assert.assertEquals(basePage.validateCourseName(),testData.get("tcod004_courseName"));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
