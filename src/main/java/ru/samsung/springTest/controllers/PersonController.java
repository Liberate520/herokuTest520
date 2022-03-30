package ru.samsung.springTest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsung.springTest.entity.Person;
import ru.samsung.springTest.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonRepository repository;

    @RequestMapping(value = "/getperson", method = RequestMethod.GET)
    public Person getPerson(@RequestParam("id") int id){
        return repository.getPerson(id);
    }

    @RequestMapping(value = "/getpersons", method = RequestMethod.GET)
    public List<Person> getPerson(){
        return repository.getPersons();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deletePerson(@RequestParam("id") int id){
        return repository.deletePerson(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT,
            consumes = "text/plain")
    public int createPerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject json = new JSONObject(param);
            person.setName(json.getString("name"));
        } catch (JSONException e){
            System.out.println("не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createPerson(person);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = "text/plain")
    public int updatePerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject json = new JSONObject(param);
            person.setName(json.getString("name"));
            person.setId(json.getInt("id"));
        } catch (JSONException e){
            System.out.println("не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updatePerson(person);
    }
}
