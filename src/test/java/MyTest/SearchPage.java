package MyTest;

import com.codeborne.selenide.SelenideElement;
import core.BaseSeleniumPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage extends BaseSeleniumPage {

    public List<SelenideElement> vacancyList = $$x("//div[@class='serp-item']");
    protected SelenideElement ExtendedSearch = $x("//a[@data-qa='advanced-search']");
    protected SelenideElement SetSalary = $x("//input[@data-qa='advanced-search-salary']");
    protected SelenideElement OnlyChosenSalarySearch = $x("//input[@data-qa='control-vacancysearch__only-with-compensation']/..");
    protected SelenideElement SearchButton = $x("//button[@data-qa='advanced-search-submit-button']");
    /*protected SelenideElement title = $x(Vacancy+"//h3");
    protected SelenideElement salary = $x(Vacancy+"//span[@data-qa='vacancy-serp__vacancy-compensation']");
    protected SelenideElement employer = $x(Vacancy+"//a[@data-qa='vacancy-serp__vacancy-employer']");*/

    public String getTitle(int index) {
        return vacancyList.get(index).$x(".//h3").getText();
    }

    public String getSalary(int index) {
        return vacancyList.get(index).$x(".//span[@data-qa='vacancy-serp__vacancy-compensation']").getText();
    }

    public String getEmployer(int index) {
        return vacancyList.get(index).$x(".//a[@data-qa='vacancy-serp__vacancy-employer']").getText();
    }

    public void SetSalaryLimit(Integer salary) {
        ExtendedSearch.click();
        SetSalary.sendKeys(salary.toString());
        OnlyChosenSalarySearch.click();
        SearchButton.click();
    }

}
