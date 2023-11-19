package com.example.homework_10_6.repository;

import com.example.homework_10_6.entity.Person;
import com.example.homework_10_6.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<Person, PersonData> {

    @Query("select p from Person p where p.city = :city")
    List<Person> findByCity(@Param("city") String city);

    @Query("select p from Person p where p.personData.age < :age order by p.personData.age")
    public List<Person> findByPersonData_AgeLessThan(@Param("age") int age);

    @Query("select p from Person p where p.personData.name = :name and p.personData.surname = :surname")
    public Optional<Person> findByPersonData_NameAndPersonData_Surname(@Param("name") String name, @Param("surname") String surname);
}
