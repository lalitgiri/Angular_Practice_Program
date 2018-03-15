package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	
	public List<Course> getAllCourses(String id)
	{
		//return topics;
		List <Course> courses = new ArrayList<>();
		courseRepository.findAll().
		forEach(courses::add);
		
		return courses;
	}

	public Optional<Course> getCourse(String id)  {
	
		return courseRepository.findById(id);
	}
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String id) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	
}
