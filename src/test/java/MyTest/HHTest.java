package MyTest;

import com.codeborne.selenide.SelenideElement;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/vacancies",
                            "postgress", "postgress");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = connection.createStatement();
            for(int i=0;i<vacancyList.size()-1;i++){
                String sql = "INSERT INTO vacancies (Title,Salary,Employer) "
                        + "VALUES (searchPage.getTitle(i),searchPage.getSalary(i),searchPage.getEmployer(i));";
            stmt.executeUpdate(sql);}
            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");

        }
    }