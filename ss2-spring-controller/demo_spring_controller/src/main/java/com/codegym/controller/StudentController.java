package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/student")
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
    @GetMapping("/student/create")
    public String showFormCreate(){
        return "create";
    }
    @PostMapping("/student/create")
    public String save(@RequestParam int id,
                       @RequestParam String name,
                       @RequestParam int gender,
                       Model model){
        Student student = new Student(id,name,gender);
        // gọi service để lưu
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
}
