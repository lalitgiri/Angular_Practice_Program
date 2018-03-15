package com.example.demo.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;

@Service
public class TopicService {
	
	
	private List <Topic> topics= new ArrayList<> (Arrays.asList(
			new Topic("1","1.6","1.2"),
			new Topic("1","1.7","1.2"),
			new Topic("1","1.1","1.2"),
			new Topic("2","2.1","2.2"),
			new Topic("3","3.1","3.2"),
			new Topic("1","1.1","1.2"),
			new Topic("1","1.1","1.2")
						
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}

	public Topic getTopic(String id)  {
	
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("Book not Found"));
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);
	}
	
	public List<Topic> searchTopicByName(String name) {
		
		List<Topic> a= new ArrayList<Topic>();
		/*topics.forEach(f-> {
			if(f.getName().equals(name)) {
			a.add(f);	
			}
		});*/
		
		  a = topics.stream().
		    filter(p -> p.getName().equals(name)).
		    collect(Collectors.toList());
		   // collect(Collectors.toCollection(() -> new ArrayList<Topic>()));
		return a;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
	/*	for(int i=0;i<topics.size();i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic);
				return;
			}
		}*/
		if(topics.removeIf(e -> e.getId().equals(id))) {
			topics.add(topic);
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}

	
}
