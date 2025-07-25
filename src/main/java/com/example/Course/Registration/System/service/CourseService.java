package com.example.Course.Registration.System.service;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.repository.CourseRegistoryRepo;
import com.example.Course.Registration.System.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CourseRegistoryRepo registerRepo;

    public List<Course> availableCourse() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> enrolledCourses() {
        return registerRepo.findAll();
    }

    public String registerCourse(String name,String emailId,String courseName)
    {
        CourseRegistry register = new CourseRegistry(name,emailId,courseName);
        registerRepo.save(register);
        return "Registered for this" + courseName +" course Successfully Congratulations "+ name;
    }
}
