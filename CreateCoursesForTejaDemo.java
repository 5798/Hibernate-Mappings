package com.teja.hibernate.demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Course;
import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;
import com.teja.hibernate.demo.entity.Review;
import com.teja.hibernate.demo.entity.Student;


public class CreateCoursesForTejaDemo {

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

		
			int sid = 1;
			Student student1 = session.get(Student.class,sid);
			
			System.out.println("student1:"+ student1);
			System.out.println("course of student1:"+ student1.getCourses());
			Course tempcourse1 = new Course("Phy");
			Course tempcourse2 = new Course("Chem");
			System.out.println("Saving additional courses");
			session.save(tempcourse1);
			session.save(tempcourse2);
			student1.addCourse(tempcourse1);
			student1.addCourse(tempcourse2);
			
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
