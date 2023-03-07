package MyTest;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HHTest extends BaseSelenideTest {
    private final static String url = "https://hh.ru/";
    private final static String SEARCH_STRING = "QA Automation Java";


    @Test
    public void searchStringTest() {
        MainPage mainPage = new MainPage(url);
        mainPage.chooseCity("Москва");
        SearchPage searchPage = mainPage.search(SEARCH_STRING);
        searchPage.SetSalaryLimit(150000);

        List<SelenideElement> vacancyList = searchPage.vacancyList;

        HashMap<String, Object> result  = new HashMap<>();

        for(int i=0;i<vacancyList.size()-1;i++){
            result.put("TITLE", searchPage.getTitle(i));
            result.put("SALARY", searchPage.getSalary(i));
            result.put("EMPLOYER", searchPage.getEmployer(i));;
        }

        /*Iterator<SelenideElement> iterator = vacancyList.iterator();

        while (iterator.hasNext()) {
            result.put("TITLE", searchPage.getTitle());
            result.put("SALARY", searchPage.getSalary());
            result.put("EMPLOYER", searchPage.getEmployer());;
        }*/

        for(Map.Entry<String,Object> entry:result.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }



    }
}