package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class AddChapterPage extends BasePageObject {

    private WebObject chapterTitleField = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/form/div/div/div/div/div/div/input");
    private WebObject frameBody = WebObject.setElement(How.TAGNAME, "body");
    private WebObject uploadVideoBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/form/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/input");
    private WebObject saveAndPublishBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div/form/div[3]/div[1]/button");

    public AddChapterPage(WebDriver driver) {
        super(driver);
    }

    public AddChapterPage setChapterTitle(String title) {
        chapterTitleField.writeText(title);
        return this;
    }

    public AddChapterPage setTextContent(String text, Integer frameIndex) {
        driver.switchTo().frame(frameIndex);
        frameBody.click();
        frameBody.writeTextWithOutWaiting(text);
        driver.switchTo().defaultContent();
        return this;
    }

    public AddChapterPage setVideoContent(String path) {
        uploadVideoBtn.writeTextWithOutWaiting(path);
        return this;
    }

    public CourseChaptersPage saveAndPublish() {
        saveAndPublishBtn.click();
        return new CourseChaptersPage(driver);
    }

}
