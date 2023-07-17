package com.edudev.contentnegotiation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonResource {

    /**
     * Get Multiple responses by using Accept Header with values
     *  application/json
     *  application/xml
     * @return
     */
    @GetMapping
    public Person getPerson() {
        var birthdayDate = LocalDate.of(2000, 11, 4);

        return new Person(
                1L,
                "Eduardo J",
                GENDER.MALE,
                birthdayDate,
                Period.between(birthdayDate, LocalDate.now()).getYears(),
                List.of(new Game("Enter the Gungeon", "Action"), new Game("Dead By Daylight", "Horror"))
        );
    }

}
