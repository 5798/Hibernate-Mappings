package com.teja.hibernate.demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Course;
import com.teja.hibernate.demo.entity.Instructor;
import com.teja.hibernate.demo.entity.InsturctorDetail;
import com.teja.hibernate.demo.entity.Review;


public class DeleteCoursesReviewsDemo {

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

		
			int sid = 11;
			Course tempcourse1 = session.get(Course.class,sid);
			System.out.println("deleting course tempcourse1:"+ tempcourse1);
			System.out.println("deleting course tempcourse1:"+ tempcourse1.getReviews());
			session.delete(tempcourse1);
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
