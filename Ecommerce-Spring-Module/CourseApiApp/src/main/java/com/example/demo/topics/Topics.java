package com.example.demo.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Topics {
	
		@RequestMapping("/topics")
		public List<Topic> getAllTopics() {
			
			return Arrays.asList(
					new Topic("1","1.1","1.2"),
					new Topic("2","2.1","2.2"),
					new Topic("3","3.1","3.2")
					
					
					
					);
		}
}
