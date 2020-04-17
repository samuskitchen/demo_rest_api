package com.empresa.demo.repository;

import com.empresa.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByNameContains(String name);

    Student getById(Long id);

    @Query(nativeQuery = true, value ="SELECT " +
      "st_id, " +
      "st_name, " +
      "st_last_name, " +
      "st_age, " +
      "st_state " +
      "FROM student " +
      "WHERE st_age =:age")
    List<Student> findAge(@Param(value = "age") Integer age);
}
