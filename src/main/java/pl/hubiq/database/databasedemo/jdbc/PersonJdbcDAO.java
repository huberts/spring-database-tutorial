package pl.hubiq.database.databasedemo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.hubiq.database.databasedemo.entity.Person;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findByName(String name) {
        return jdbcTemplate.query("select * from person where name=?", new Object[]{name}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findByLocation(String location) {
        return jdbcTemplate.query("select * from person where location=?", new Object[]{location}, new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "INSERT INTO PERSON (id, name, location, birth_date) VALUES (?, ?, ?, ?)",
                person.getId(),
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime())
        );
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "UPDATE PERSON SET name=?, location=?, birth_date=? where id=?",
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId()
        );
    }


}
