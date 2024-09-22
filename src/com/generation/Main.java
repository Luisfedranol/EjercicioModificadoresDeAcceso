package com.generation;

import com.generation.classes.StudentService;
import com.generation.exceptions.CourseNotFoundException;
import com.generation.exceptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
        studentService.addStudent( "Carlos", "1030", 31 );
        studentService.addStudent( "Ian", "1020", 28 );
        studentService.addStudent( "Elise", "1020", 26 );
        studentService.addStudent( "Santiago", "1020", 33);


			try {
				studentService.enrollStudents( "Math", "1030" );
			} catch (CourseNotFoundException | StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
        studentService.showEnrolledStudents("Math");
        System.out.println();
        studentService.showAllCourses();
        System.out.println();
        studentService.showEnrolledStudents("Art");
        System.out.println("-------------------------------------");
        
        try {
			studentService.unEnrollStudents("Math", "1030");
		} catch (CourseNotFoundException | StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
        studentService.showEnrolledStudents("Math");
        System.out.println();
    }//main
}
