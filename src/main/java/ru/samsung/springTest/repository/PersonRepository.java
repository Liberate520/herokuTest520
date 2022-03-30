package ru.samsung.springTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsung.springTest.entity.Person;

import java.util.List;

@Component
public class PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createPerson(Person person){
        return jdbcTemplate.update("insert into \"Persons\" (\"name\") values(?)", person.getName());
    }

    public int deletePerson(int id){
        return jdbcTemplate.update("delete from \"Persons\" where \"id\"=?", id);
    }

    public Person getPerson(int id){
        return jdbcTemplate.queryForObject("select * from \"Persons\" where \"id\"=?",
                new PersonMapper(), id);
    }

    public List<Person> getPersons(){
        return jdbcTemplate.query("select * from \"Persons\"",
                new PersonMapper());
    }

    public int updatePerson(Person person){
        return jdbcTemplate.update("update \"Persons\" set \"name\" = ? where \"id\" = ?",
                person.getName(), person.getId());
    }
}
