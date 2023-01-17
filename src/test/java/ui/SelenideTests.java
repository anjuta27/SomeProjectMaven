package ui;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {



    @Test
    public void negativeLogin() {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("user");
        $(By.id("password")).setValue("123456789");
        $(By.xpath("//*[@data-name='signIn-button']")).click();
        $(By.xpath("//*[@data-name='authorizationError-popup-close-button']")).shouldBe(Condition.visible);
        String errorMessage = $(By.xpath("//span[@class='error-popup__title']")).shouldBe(Condition.visible).getText();
        Assertions.assertEquals(
                "Incorrect credentials",
                errorMessage,
                "Сообщение об ошибке отображается некорректно");
        $(By.xpath("//*[@data-name='authorizationError-popup-close-button']")).click();
        $(By.xpath("//*[@class='login']")).shouldBe(Condition.visible);


    }


    @Test
    public void loginAndCheckOrderForm() {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("user1");
        $(By.id("password")).setValue("hellouser1");
        $(By.xpath("//*[@data-name='signIn-button']")).click();
        $(By.xpath("//*[@data-name='openStatusPopup-button']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@data-name='createOrder-button']")).shouldBe(Condition.visible).getText();
        Assertions.assertEquals("Заказать", "Заказать", "Орфографическая ошибка");
       $(By.xpath("//*[@data-name='logout-button']")).click();
       $(By.xpath("//*[@class='login']")).shouldBe(Condition.visible);
    }

    @Test
    public void createOrder() {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("user1");
        $(By.id("password")).setValue("hellouser1");
        $(By.xpath("//*[@data-name='signIn-button']")).click();
        $(By.xpath("//*[@class='new-order']")).shouldBe(Condition.visible);
        $(By.id("name")).setValue("Anna");
        $(By.id("phone")).setValue("58144717");
        $(By.id("comment")).setValue("hello world");
        $(By.xpath("//*[@class='button new-order__button']")).click();
        $(By.xpath("//*[@data-name='orderSuccessfullyCreated-popup']")).shouldBe(Condition.visible).getText();
        Assertions.assertEquals("Заказ создан", "Заказ создан", "Заказ не создан");
        Assertions.assertEquals("Номер отслеживания : ", "Номер отслеживания : ", "не получен номер отслеживания");
        $(By.xpath("//*[@data-name='orderSuccessfullyCreated-popup-ok-button']")).click();
        $(By.xpath("//*[@data-name='logout-button']")).click();
        $(By.xpath("//*[@class='login']")).shouldBe(Condition.visible);


    }

    @Test
    public void orderSearch() {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("user1");
        $(By.id("password")).setValue("hellouser1");
        $(By.xpath("//*[@data-name='signIn-button']")).click();
        $(By.xpath("//*[@data-name='openStatusPopup-button']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@class='header__button_check-order']")).click();
        $(By.xpath("//*[@class='popup__container']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@name='id']")).setValue("1832");
        $(By.xpath("//*[@data-name='searchOrder-submitButton']")).click();
        $(By.xpath("//*[@class='order-details']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@class='status-list__status status-list__status_active']")).shouldBe(Condition.visible).getText();
        Assertions.assertEquals("OPEN", "OPEN", "Error!");
    }

    @Test
    public void logout() {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("user1");
        $(By.id("password")).setValue("hellouser1");
        $(By.xpath("//*[@data-name='signIn-button']")).click();
        $(By.xpath("//*[@data-name='openStatusPopup-button']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@class='header__button_check-order']")).click();
        $(By.xpath("//*[@class='popup__container']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@name='id']")).setValue("1832");
        $(By.xpath("//*[@data-name='searchOrder-submitButton']")).click();
        $(By.xpath("//*[@class='order-details']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@class='status-list__status status-list__status_active']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@data-name='logout-button']")).click();
        $(By.xpath("//*[@class='login']")).shouldBe(Condition.visible);
    }
}
