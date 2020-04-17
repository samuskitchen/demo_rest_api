package com.empresa.demo.service;

import com.empresa.demo.model.Student;
import com.empresa.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteId(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentByName(String name){
        return studentRepository.findAllByNameContains(name);
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAllAge(Integer age){
        return studentRepository.findAge(age);
    }

}