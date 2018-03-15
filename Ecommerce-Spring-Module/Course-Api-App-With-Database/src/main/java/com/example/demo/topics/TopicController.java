package com.example.demo.topics;

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
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
		@RequestMapping("/topics")
		public List<Topic> getAllTopics() {
			
			return topicService.getAllTopics();
		}
	
		@RequestMapping("/topics/{foo}")							//	@RequestMapping("/topics/{id}")
		public Optional<Topic> getTopic(@PathVariable("foo") String id) throws NotFoundException {		//public Topic getTopic(@PathVariable String id)
			Optional<Topic> a= topicService.getTopic(id);
			if(a == null) 
				throw new NotFoundException("book not found");
				else 
			return topicService.getTopic(id);
		}
		
		/*@RequestMapping("/topics/name/{name}")							
		public List<Topic> searchTopicByName(@PathVariable String name) {		
			return topicService.searchTopicByName(name);
		}*/
		@RequestMapping(method=RequestMethod.POST,value="/topics")
		public void addTopic(@RequestBody Topic topic) {
			topicService.addTopic(topic);
			
		}
		

		@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
			topicService.updateTopic(topic,id);
			
		}
		
		@RequestMapping(method= RequestMethod.DELETE,value ="/topics/{id}")
		public void deleteTopic(@PathVariable String id) {
			topicService.deleteTopic(id);
			
		}
}
