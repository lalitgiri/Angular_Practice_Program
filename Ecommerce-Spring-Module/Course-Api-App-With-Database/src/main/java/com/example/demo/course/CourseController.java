package com.example.demo.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.NotFoundException;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
		@RequestMapping("topics/{id}/courses")
		public List<Course> getAllCourses(@PathVariable String id) {
			
			return courseService.getAllCourses(id);
		}
	
		@RequestMapping("/topics/{topicId}/courses/{Id}")							//	@RequestMapping("/topics/{id}")
		public Optional<Course> getTopic(@PathVariable("topicId") String id) throws NotFoundException {		//public Topic getTopic(@PathVariable String id)
			Optional<Course> a= courseService.getCourse(id);
			if(a == null) 
				throw new NotFoundException("book not found");
				else 
			return courseService.getCourse(id);
		}
		
		/*@RequestMapping("/topics/name/{name}")							
		public List<Topic> searchTopicByName(@PathVariable String name) {		
			return topicService.searchTopicByName(name);
		}*/
		@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses/{id}")
		public void addCourse(@RequestBody Course course) {
			courseService.addCourse(course);
			
		}
		

		@RequestMapping(method=RequestMethod.PUT,value="/courses/{id}")
		public void updateCourse(@RequestBody Course course,@PathVariable String id) {
			courseService.updateCourse(course,id);
			
		}
		
		@RequestMapping(method= RequestMethod.DELETE,value ="/courses/{id}")
		public void deleteCourse(@PathVariable String id) {
			courseService.deleteCourse(id);
			
		}
}
