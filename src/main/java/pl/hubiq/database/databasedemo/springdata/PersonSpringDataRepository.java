package pl.hubiq.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubiq.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
