package com.teja.hibernate.demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Course;
import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;
import com.teja.hibernate.demo.entity.Review;


public class CreateCoursesReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InsturctorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Creating new object: ");
			session.beginTransaction();

		
			Course tempcourse1 = new Course("Math");
			//Course tempcourse2 = new Course("Math");
			//tempcourse1.add(new Review("Fine course!"));
			//tempcourse1.add(new Review("Not bad course!"));
			
			System.out.println("saving course tempcourse1:"+ tempcourse1);
			System.out.println("Reviews of tempcourse1:"+ tempcourse1.getReviews());
			
			//session.save(tempcourse2);
			session.save(tempcourse1);
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
