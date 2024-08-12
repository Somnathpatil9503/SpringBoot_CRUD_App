package com.somnath.cruddemo;

import com.somnath.cruddemo.dao.StudentDAO;
import com.somnath.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("deleting all student");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted row count:"+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("deleting student id:" + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive student based on the id : primary key
		int studentId = 2;
		System.out.println("Getting student witth id : "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//chnage first name to "sakshi"
		System.out.println("updating student ...");
		myStudent.setFirstName("john");


		//update te student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updating student:" + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("patil");
		//display list of student
        for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get list of student
		List<Student> theStudents = studentDAO.findAll();
		//display student list
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//craete the student obj

		System.out.println("creating new student...");
		Student tempStudent = new Student("somnath","patil","somnathpatil502@gmail.com");

		//save the student object
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);

		//display id of save student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id" + theId);

		//retrive student based on id : primary id
		System.out.println("retrive student with id" + theId);
		Student myStudent = studentDAO.findById(theId);

		//display studnet
		System.out.println("found the student : " + myStudent);


	}

	private void createStudent(StudentDAO studentDAO) {
		//craete the student obj

		System.out.println("creating new student...");
		Student tempStudent = new Student("somnath","patil","somnathpatil502@gmail.com");
		Student tempStudent1 = new Student("mahesh","patil","maheshpatil502@gmail.com");
		Student tempStudent2 = new Student("sumedh","patil","sumedhpatil502@gmail.com");

		//save the student object
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		//display id of save student
		System.out.println("saved student. Generated id" + tempStudent.getId());
	}

}
