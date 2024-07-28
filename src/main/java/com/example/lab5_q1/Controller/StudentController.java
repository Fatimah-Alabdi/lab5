package com.example.lab5_q1.Controller;

import com.example.lab5_q1.Api.ApiResponse;
import com.example.lab5_q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added successfully");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Student updated successfully");
    }
    @DeleteMapping("/delet/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Student deleted successfully");
    }
    @GetMapping("/getname/{index}")
    public String getStudentName(@PathVariable int index){
      return students.get(index).getName();

    }
    @GetMapping("/getage/{index}")
    public int getStudentAge(@PathVariable int index){
        return students.get(index).getAge();
    }
    @GetMapping("/getdgree/{index}")
    public String getCollegeDegree(@PathVariable int index){
        return students.get(index).getDegree();
    }
    @GetMapping("/getstatus/{index}")
    public ApiResponse getStudentStatus(@PathVariable int index){
        if(students.get(index).getStatus().equalsIgnoreCase("ungraduated")){
            return new ApiResponse("false");

        }
        else
        return new ApiResponse("true");
    }
}
