package com.teja.hibernate.demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Course;
import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;
import com.teja.hibernate.demo.entity.Review;
import com.teja.hibernate.demo.entity.Student;


public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InsturctorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Creating new object: ");
			session.beginTransaction();

		
			Course tempcourse1 = new Course("Math");
			//Course tempcourse2 = new Course("Phy");
			Student student1 = new Student("Teja","Anagani","anst@gmail.com");
			Student student2 =new Student("Josu","Anagani","josu@gmail.com");
			tempcourse1.addStudent(student1);
			tempcourse1.addStudent(student2);
			
			System.out.println("saving course tempcourse1:"+ tempcourse1);
			//System.out.println("saving course tempcourse2:"+ tempcourse2);
			System.out.println("Students of tempcourse1:"+ tempcourse1.getStudents());
			//System.out.println("Students of tempcourse2:"+ tempcourse2.getStudents());
			
			session.save(tempcourse1);
			session.save(student1);
			session.save(student2);
			
			//session.save(tempcourse2);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}

	

}
