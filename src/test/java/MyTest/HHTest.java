package MyTest;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static MyTest.SearchPage.Vacancy;

public class HHTest extends BaseSelenideTest {
    private final static String url = "https://hh.ru/";
    private final static String SEARCH_STRING = "QA Automation Java";


    @Test
    public HashMap<String, Object> searchString() {
        MainPage mainPage = new MainPage(url);
        mainPage.chooseCity("Москва");
        SearchPage searchPage = mainPage.search(SEARCH_STRING);
        searchPage.SetSalaryLimit(150000);
        List<SelenideElement> vacancyList = (List<SelenideElement>) Vacancy;

        HashMap<String, Object> result  = new HashMap<>();
        Iterator<SelenideElement> iterator = vacancyList.iterator();
        while (iterator.hasNext()) {
            result.put("TITLE", searchPage.getTitle());
            result.put("SALARY", searchPage.getSalary());
            result.put("EMPLOYER", searchPage.getEmployer());;
        }
        System.out.println(result);

        return result;
    }
}