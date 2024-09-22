package com.generation.exceptions;

public class StudentNotFoundException extends Exception{

	public StudentNotFoundException( String message){
		super( "Student not found! [" + message + "]");
	}
}