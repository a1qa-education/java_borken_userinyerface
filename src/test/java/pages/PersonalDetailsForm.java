package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    PersonalDetailsForm() {
        super(By.className("personal-details__form"), "Personal Details form");
    }
}
