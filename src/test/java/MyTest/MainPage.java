package MyTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    protected final SelenideElement textBoxInput = $x("//input[@data-qa='search-input']");
    protected final SelenideElement cityChoiceButton = $x("//button[@data-qa='mainmenu_areaSwitcher']");
    protected final SelenideElement cityChoiceInput = $x("//input[@data-qa='area-search-input']");
    protected final SelenideElement cityChoice = $x("//ul[@data-qa=\"bloko-suggest-list\"]");

        public MainPage(String url){
            Selenide.open(url);
        }

        protected MyTest.SearchPage search(String searchString){
            textBoxInput.setValue(searchString);
            textBoxInput.sendKeys(Keys.ENTER);
            return new MyTest.SearchPage();
        }
        protected void chooseCity(String city){
            cityChoiceButton.click();
            cityChoiceInput.setValue(city);
            cityChoice.click();
        }
    }
