package com.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.generation.exceptions.CourseNotFoundException;
import com.generation.exceptions.StudentNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();
    private HashMap<String, Student> students = new HashMap<>();
    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }
	
    public void addStudent(String name, String id, int age) {
        Student student = new Student(name, id, age);
        students.put(id, student);
    }//addStudent

	public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
        Course course = courseList.get( courseName );
        if (course == null) {
            throw new CourseNotFoundException(courseName);
        }

        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException(studentID);
        }

        if ( !coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        
     // Agregar el curso a la lista de cursos del estudiante
        student.addCourse(course);
        coursesEnrolledByStudents.get( studentID ).add( course );
    }

    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
        Course course = courseList.get( courseName );
        if (course == null) {
            throw new CourseNotFoundException(courseName);
        }

        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException(studentID);
        }

        if ( coursesEnrolledByStudents.containsKey( studentID ) ){
        	
        	student.removeCourse(course);
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }
    }

    public void showEnrolledStudents(String courseId){
    	System.out.println("Students enrolled in " + courseId + ":");
        for (String studentID : coursesEnrolledByStudents.keySet()) {
            List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentID);
            	for (Course course : enrolledCourses) {
                    if (course.getName().equals(courseId)) {
                        Student student = students.get(studentID);
                        System.out.println(student.toString());
                    }
                } 
        }
    }

    public void showAllCourses(){
    	System.out.println("Cursos disponibles:");
        for (Course course : courseList.values()) {
            System.out.println(course.toString());
        }
    }
}