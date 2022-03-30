package ru.samsung.springTest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.samsung.springTest.entity.Person;
import ru.samsung.springTest.entity.Phone;
import ru.samsung.springTest.repository.PersonRepository;
import ru.samsung.springTest.repository.PhoneRepository;

import java.util.List;

public class PhoneControllers {
    @Autowired
    PhoneRepository repository;

    @RequestMapping(value = "/getphone", method = RequestMethod.GET)
    public Phone getPhone(@RequestParam("id") int id){
        return repository.getPhone(id);
    }

    @RequestMapping(value = "/getphones", method = RequestMethod.GET)
    public List<Phone> getPhone(){
        return repository.getPhones();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deletePhone(@RequestParam("id") int id){
        return repository.deletePhone(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT,
            consumes = "text/plain")
    public int createPhone(@RequestBody String param){
        Phone phone = new Phone();
        try {
            JSONObject json = new JSONObject(param);
            phone.setValue(json.getString("value"));
            phone.setIdPerson(json.getInt("id_person"));
        } catch (JSONException e){
            System.out.println("не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createPhone(phone);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = "text/plain")
    public int updatePhone(@RequestBody String param){
        Phone phone = new Phone();
        try {
            JSONObject json = new JSONObject(param);
            phone.setValue(json.getString("value"));
            phone.setId(json.getInt("id"));
        } catch (JSONException e){
            System.out.println("не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updatePerson(phone);
    }
}
