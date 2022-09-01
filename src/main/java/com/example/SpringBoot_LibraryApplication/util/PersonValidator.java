package com.example.SpringBoot_LibraryApplication.util;


import com.example.SpringBoot_LibraryApplication.models.Person;
import com.example.SpringBoot_LibraryApplication.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Roman_Andriiv
 */
@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (peopleService.getPersonByFullName(person.getFullName()).isPresent()){
            errors.rejectValue("fullName", "", "Person with this name is already exists");
        }
    }
}
