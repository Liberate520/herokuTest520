package ru.samsung.springTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.samsung.springTest.entity.Person;
import ru.samsung.springTest.entity.Phone;

import java.util.List;

@Component
public class PhoneRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createPhone(Phone phone){
        return jdbcTemplate.update("insert into \"Phone\" (\"value\") values(?)", phone.getValue());
    }

    public int deletePhone(int id){
        return jdbcTemplate.update("delete from \"Phone\" where \"id\"=?", id);
    }

    public Phone getPhone(int id){
        return jdbcTemplate.queryForObject("select * from \"Phone\" where \"id\"=?",
                new PhoneMapper(), id);
    }

    public List<Phone> getPhones(){
        return jdbcTemplate.query("select * from \"Phone\"",
                new PhoneMapper());
    }

    public int updatePerson(Phone phone){
        return jdbcTemplate.update("update \"Phone\" set \"value\" = ? where \"id\" = ?",
                phone.getValue(), phone.getId());
    }
}
