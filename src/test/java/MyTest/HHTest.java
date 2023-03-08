//package MyTest;
//
//import com.codeborne.selenide.SelenideElement;
//import core.BaseSelenideTest;
//import org.junit.jupiter.api.Test;
//
//import java.sql.*;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//
//public class HHTest extends BaseSelenideTest {
//    private final static String URL = "https://hh.ru/";
//    private final static String SEARCH_STRING = "QA Automation Java";
//
//
//    @Test
//    public void searchStringTest() {
//        MainPage mainPage = new MainPage(URL);
//        mainPage.chooseCity("Москва");
//        SearchPage searchPage = mainPage.search(SEARCH_STRING);
//        searchPage.SetSalaryLimit(150000);
//
//        List<SelenideElement> vacancyList = searchPage.vacancyList;
//        Statement stmt = null;
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("insert into vacancies(title,salary,employer) VALUES (?,?,?)");
//
//            for (int i = 0; i < vacancyList.size() - 1; i++) {
//                preparedStatement.setString(1,searchPage.getTitle(i));
//                preparedStatement.setString(2,searchPage.getSalary(i));
//                preparedStatement.setString(3,searchPage.getEmployer(i));
//                preparedStatement.addBatch();
//            }
//            preparedStatement.executeBatch();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}