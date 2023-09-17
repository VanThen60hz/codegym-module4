package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @RequestMapping(value = "/student/list" , method = RequestMethod.GET)
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
    @RequestMapping(value = "/student/create" , method = RequestMethod.GET)
    public String showFormCreate(){
        return "create";
    }
    @RequestMapping(value = "/student/create" , method = RequestMethod.POST)
    public String save(@RequestParam int id, @RequestParam String name){
        Student student = new Student(id,name);

        return "create";
    }

}
