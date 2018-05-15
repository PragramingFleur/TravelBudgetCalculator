/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.fa.mscc.SISDDemo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Fleur Andersen
 */
@Component
@RestController
@RequestMapping("/calculate")
public class Controller {

    @RequestMapping( method = RequestMethod.GET, value = "/foodbudget/{numofdays}/{numofmeals}/{budgetpermeal}", produces = "text/plain")
    public String addMealBudget(@PathVariable("numofdays") Integer num1, @PathVariable("numofmeals") Integer num2, @PathVariable("budgetpermeal") Integer num3) {
        return String.format(
                "Number of Days: %d\n"
                + "Number of Meals per Day: %d\n"
                + "Budget per Meal: %d\n"
                + "Total Meal Budget for %d days: %d", num1, num2, num3, num1, ( (num1 * num2) * num3 )
        );
    }
    
    @RequestMapping( method = RequestMethod.GET, value = "/extrabudget/{transpobudget}/{emergencybudget}", produces = "text/plain")
    public String addExtraBudget(@PathVariable("transpobudget") Integer num1, @PathVariable("emergencybudget") Integer num2) {
        return String.format(
                "Transportation Budget: %d\n"
                + "Emergency Budget: %d\n"
                + "Total Extra Budget: %d", num1, num2, ( num1 + num2 )
        );
    }
    
    @RequestMapping( method = RequestMethod.GET, value = "/hotelplanebudget/{hotelprice}/{ticket}", produces = "text/plain")
    public String addHotelPlane(@PathVariable("hotelprice") Integer num1, @PathVariable("ticket") Integer num2) {
        return String.format(
                "Total Hotel Payment: %d\n"
                + "Plane Ticket Payment: %d\n"
                + "Total Travel & Accomodation Payment: %d", num1, num2, ( num1 + num2 )
        );
    }
    
}