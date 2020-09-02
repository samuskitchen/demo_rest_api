package com.empresa.demo.controller;

import com.empresa.demo.exception.StudentRequestException;
import com.empresa.demo.model.Student;
import com.empresa.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api("Students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/save")
    @ApiOperation(value = "Insert Student", response = Student.class)
    @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Something went wrong"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping(path = "/update")
    @ApiOperation(value = "Update Student", response = Student.class)
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/delete")
    @ApiOperation(value = "Delete Student By Id", response = Student.class)
    public void deleteId(@RequestParam(name = "id") Long idStudent) {
        studentService.deleteId(idStudent);
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "Find All Students", response = Student.class)
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping(path = "/all/name")
    @ApiOperation(value = "Find All Students By Name", response = Student.class)
    public List<Student> findAllStudent(@RequestParam(name = "name") String name) {
        return studentService.findAllStudentByName(name);
    }

    @GetMapping(path = "/all/age")
    @ApiOperation(value = "Find All Students By Age", response = Student.class)
    public List<Student> findAllByAge(@RequestParam(name = "age") Integer ageStudent) {
        return studentService.findAllAge(ageStudent);
    }

    @GetMapping(path = "/id")
    @ApiOperation(value = "Find Student By Id", response = Student.class)
    @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Something went wrong"),
      @ApiResponse(code = 404, message = "No encontro Estudiante"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Student> findById(@RequestParam(name = "id") Long idStudent) {
        return ResponseEntity.ok(studentService.findById(idStudent)
          .orElseThrow(() -> new StudentRequestException("No se encontro el estudiante")));
    }

}
