package com.example.demo.course;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

		@Id
		private String id;
		public String name;
		public String description;
		
		
		public Course() {
			
		}
		public Course(String id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
