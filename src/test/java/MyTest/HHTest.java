package MyTest;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HHTest extends BaseSelenideTest {
    private final static String URL = "https://hh.ru/";
    private final static String SEARCH_STRING = "QA Automation Java";


    @Test
    public void searchStringTest() {
        MainPage mainPage = new MainPage(URL);
        mainPage.chooseCity("Москва");
        SearchPage searchPage = mainPage.search(SEARCH_STRING);
        searchPage.SetSalaryLimit(150000);

        List<SelenideElement> vacancyList = searchPage.vacancyList;

        for(int i=0;i<vacancyList.size()-1;i++){
            System.out.println("TITLE: "+searchPage.getTitle(i));
            System.out.println("SALARY: "+searchPage.getSalary(i));
            System.out.println("EMPLOYER: "+searchPage.getEmployer(i));

        }
//        DataBase db = new DataBase();
//        db.testDatabase();



        /*Iterator<SelenideElement> iterator = vacancyList.iterator();

        while (iterator.hasNext()) {
            result.put("TITLE", searchPage.getTitle());
            result.put("SALARY", searchPage.getSalary());
            result.put("EMPLOYER", searchPage.getEmployer());;
        }*/

//        for(Map.Entry<String,Object> entry:result.entrySet()){
//            System.out.println(entry.getKey()+"  "+entry.getValue());
//        }



    }
}