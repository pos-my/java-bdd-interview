package posmy.interview.qa.util.typifiedelement;

import org.coronium.page.AutoPage;

public class PageFactory extends org.coronium.page.core.ui.pages.PageFactory{
    public static <T extends AutoPage> T newInstance(Class<T> clazz) {
        return newInstance(clazz, 20);
    }
}
