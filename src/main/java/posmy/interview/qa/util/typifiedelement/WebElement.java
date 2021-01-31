package posmy.interview.qa.util.typifiedelement;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;


public class WebElement extends TypifiedElement{
    //extends TypifiedElement from ru.yandex as selenium's webelement .isDisplayed() isnt working
    public WebElement(org.openqa.selenium.WebElement wrappedElement) {
        super(wrappedElement);
    }

}
