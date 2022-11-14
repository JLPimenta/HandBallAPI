package crp.handball.API.model.person.DTO;

import crp.handball.API.model.person.Gender;
import crp.handball.API.model.person.Person;

public record DataListPerson(Integer id, String name, String birthDate, Gender gender, Double height, Double weight) {

    public DataListPerson(Person person) {
        this(person.getId(), person.getName(), person.getBirthDate(), person.getGender(), person.getHeight(),
                person.getWeight());
    }
}
