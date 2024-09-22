package com.generation.classes;

import java.util.ArrayList;
import java.util.List;

public class Student
{
    private String name;
    private String id;
    private int age;
    private final List<Course> courseList;

    public Student( String name, String id, int age)
    {
        this.setName(name);
        this.setId(id);
        this.setAge(age);
        this.courseList = new ArrayList<>();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Course> getCourseList() {
		return courseList;
	}
	
	public void addCourse(Course course) {
        courseList.add(course);
    }
	
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + ", courseList=" + courseList + "]";
	}
}