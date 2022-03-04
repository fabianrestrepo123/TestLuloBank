package co.com.test.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Bodyemployee implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        String id = SerenityRest.lastResponse().getBody().jsonPath().getString("data.id");
        String employeeName = SerenityRest.lastResponse().getBody().jsonPath().getString("data.employee_name");
        String employeeSalary = SerenityRest.lastResponse().getBody().jsonPath().getString("data.employee_salary");
        String employee_age = SerenityRest.lastResponse().getBody().jsonPath().getString("data.employee_age");

        if (id.equals("1") && employeeName.equals("Tiger Nixon") && employeeSalary.equals("320800") && employee_age.equals("61")){
            return true;
        }else {
            return false;}
    }

    public static Bodyemployee bodyValidation(){
        return new Bodyemployee();
    }
}
