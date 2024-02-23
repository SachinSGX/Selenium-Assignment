package com.training.template.tests;

import com.training.template.constants.Constants;
import com.training.template.enums.CourseMode;
import com.training.template.enums.CourseType;
import com.training.template.enums.DifficultyLevel;
import com.training.template.enums.Specialization;
import com.training.template.pageobjects.*;
import com.training.template.reporting.ExtentTestManager;
import com.training.template.util.BaseTestObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class TestScenarioOne extends BaseTestObject {

    private HomePage homePage;
    private LoginPage loginPage;
    private BasePage basePage;
    private AddCoursePage addCoursePage;
    private CourseMaterialPage courseMaterialPage;
    private CourseChaptersPage courseChaptersPage;
    private AddChapterPage addChapterPage;
    private UserRoasterPage userRoasterPage;
    private EnrollUserPage enrollUserPage;
    private UpdateCoursePage updateCoursePage;

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
    public void testCreateCourse(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create New Course Scenario");

            addCoursePage = basePage.navigateToAddCoursePage();
            addCoursePage
                    .setCourseMode(CourseMode.valueOf(testData.get("courseMode").toUpperCase()))
                    .setCourseName(testData.get("courseName"))
                    .setCourseType(CourseType.valueOf(testData.get("courseType").toUpperCase()))
                    .setDifficultyLevel(DifficultyLevel.valueOf(testData.get("difficultyLevel").toUpperCase()))
                    .setCourseDescription(testData.get("courseDescription"))
                    .setSpecialization(Specialization.valueOf(testData.get("specialization").replaceAll("\\s","").toUpperCase()))
                    .setEstimatedCourseDuration(testData.get("estimatedCourseDuration"))
                    .setCoverImage(testData.get("coverImagePath"))
                    .setClassSchedule(testData.get("classSchedule"), 3)
                    .setCourseOutline(testData.get("title"),testData.get("description"))
                    .setExpertPanel(testData.get("name"),testData.get("designation"))
                    .setFaqs(testData.get("question"),testData.get("answer"))
                    .setPricing(Boolean.parseBoolean(testData.get("isPaid")),Boolean.parseBoolean(testData.get("isCouponAllowed")),testData.get("price"))
                    .saveAndPublish();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_COURSE_SUCCESS_TOAST);
            basePage.closeToastMessage();

            refreshPage(); //for skipping the bug
            Assert.assertEquals(basePage.validateCourseType(),testData.get("courseType"));
            Assert.assertEquals(basePage.validateSpecialization(),testData.get("specialization"));
            Assert.assertEquals(basePage.validateCourseName(),testData.get("courseName"));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testCreateCourse")
    public void testCreateLesson(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create Lesson Scenario");

            courseMaterialPage = basePage.navigateToCourseMaterialPage();
            courseMaterialPage
                    .clickAddLesson()
                    .setLessonName(testData.get("lessonName"))
                    .setDescription(testData.get("lessonDescription"))
                    .setIncludeUnits(Boolean.parseBoolean(testData.get("includeUnits")))
                    .saveLesson();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_LESSON_SUCCESS_TOAST);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testCreateLesson")
    public void testCreateUnit(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create Unit Scenario");

            basePage.closeToastMessage();
            courseMaterialPage
                    .clickAddUnit()
                    .setUnitName(testData.get("unitName"))
                    .saveUnit();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_UNIT_SUCCESS_TOAST);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testCreateUnit")
    public void testCreateChapter(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Create Chapter Scenario");

            basePage.closeToastMessage();
            courseChaptersPage = courseMaterialPage.navigateToCourseChaptersPage();
            addChapterPage = courseChaptersPage.navigateToAddChapterPage();

            addChapterPage
                    .setChapterTitle(testData.get("chapterTitle"))
                    .setTextContent(testData.get("textContent"),1)
                    .setVideoContent(testData.get("videoContent"))
                    .saveAndPublish();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.CREATE_CHAPTER_SUCCESS_TOAST);
            Assert.assertEquals(courseChaptersPage.validateChapterTitle(), testData.get("chapterTitle"));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testCreateChapter")
    public void testEnrollUsers(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Enroll Users Scenario");

            basePage.closeToastMessage();
            userRoasterPage = courseMaterialPage.navigateToUserRoasterPage();
            enrollUserPage = userRoasterPage.navigateToEnrollUserPage();

            String[] emails = testData.get("user_emails").split(",");
            for (String email : emails) {
                enrollUserPage.enrollUser(email);
            }
            enrollUserPage.confirmEnrollment();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.ENROLL_SUCCESS_TOAST);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testEnrollUsers")
    public void testUpdateCourse(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Update Course Scenario");

            basePage.closeToastMessage();
            courseMaterialPage.navigateToBasePage();
            updateCoursePage = basePage.navigateToCourseUpdatePage();
            updateCoursePage
                    .updateCourseName(testData.get("newCourseName"))
                    .updateAndPublish();

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.COURSE_UPDATE_SUCCESS_TOAST);
            Assert.assertEquals(basePage.validateCourseName(),testData.get("newCourseName"));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testUpdateCourse")
    public void testDeleteCourse(Method method) throws InterruptedException {

        try {
            ExtentTestManager.startTest(method.getName(), "Delete Course Scenario");

            basePage.closeToastMessage();
            basePage.deleteCourse(testData.get("newCourseName"));

            Assert.assertEquals(basePage.validateToastMessageAppearance(), Constants.COURSE_DELETE_FAILED_TOAST);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Test(dependsOnMethods = "testDeleteCourse")
    public void testLogOut(Method method) {

        try {
            ExtentTestManager.startTest(method.getName(), "User Logout Scenario");

            homePage = basePage.clickLogoutBtn();

            Assert.assertTrue(homePage.isLoginBtnDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
