package com.training.template.pageobjects;

import com.training.template.enums.How;
import com.training.template.util.BasePageObject;
import com.training.template.util.WebObject;
import org.openqa.selenium.WebDriver;

public class CourseChaptersPage extends BasePageObject {

    private WebObject addChapterBtn = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[1]/div/div[2]/div[2]/div/div[2]/button");
    private WebObject chapterTitle = WebObject.setElement(How.XPATH, "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]");

    public CourseChaptersPage(WebDriver driver) {
        super(driver);
    }

    public AddChapterPage navigateToAddChapterPage() {
        addChapterBtn.clickUsingJsExecutor();
        return new AddChapterPage(driver);
    }

    public String validateChapterTitle() throws InterruptedException {
        return chapterTitle.readText();
    }
}
