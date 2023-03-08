package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Базовый класс для инициализации селенида
 */
abstract public class BaseSelenideTest {
    protected Connection connection = null;
    /**
     * Инициализация selenide с настройками
     */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized=false;
        Configuration.headless = false;
    }

    /**
     * Выполнение метода перед каждым запуском тестов
     */
    @BeforeEach
    public void init(){
        setUp();
//        try{
//        Class.forName("org.postgresql.Driver");
//        connection = DriverManager
//                .getConnection("jdbc:postgresql://localhost:5432/vacancies",
//                        "postgres", "postgres");
//        System.out.println("Opened database successfully");
//    }
//    catch(Exception e){e.printStackTrace();}
    }

    /**
     * Выполнение метода после каждого закрытия тестов
     */
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Closed database successfully");
    }
}
