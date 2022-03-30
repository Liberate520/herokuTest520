package ru.samsung.springTest.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.samsung.springTest.entity.Person;
import ru.samsung.springTest.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneMapper implements RowMapper<Phone> {
    @Override
    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Phone phone = new Phone();
        phone.setId(rs.getInt("id"));
        phone.setValue(rs.getString("value"));
        phone.setIdPerson(rs.getInt("id_person"));
        return phone;
    }
}
