package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainIki {

	public static void main(String[] args) {
		// session icinde sorguyu yazip sessionu db ye gonderiyoruz
				//Session transaction yonetimi icin olusturulur
				// transaction yonetimi: ard arada olan sorgularda birinde sorun olursa onceki de 
				//geri alinsin diye yapilir.
				// session yapmak icin fabrika olustur
				SessionFactory factory= new Configuration()
						.configure("hibernate.cfg.xml") 
						.addAnnotatedClass(City.class)
						.buildSessionFactory();
				//Unit of Work
				Session session = factory.getCurrentSession();
				try {
					
					session.beginTransaction();
					//HQL-->Hibernate Query Language
					//select c.countryCode from City c GROUP BY c.countryCode
					/*
					 * List<String> countryCodes=session.
					 * createQuery("select c.countryCode from City c GROUP BY c.countryCode").
					 * getResultList(); for(String countryCode:countryCodes) {
					 * System.out.println(countryCode); }
					 */
					/*City city=new City();
					city.setName("Duzce 10");
					city.setCountryCode("TUR");
					city.setDistrict("Karadeniz");
					city.setPopulation(100000);
					session.save(city);			
					session.getTransaction().commit();//commit etmek  veritabanina bas demek 
					System.out.println("Þehir eklendi! ");
					*/
					// UPDATE icin ilk once datayi veritabanindan id'si ile al
				/*	City city = session.get(City.class, 12);
					city.setPopulation(110000);	
					session.save(city);			
					session.getTransaction().commit();//commit etmek  veritabanina bas demek 
					System.out.println("Þehir guncellendi! ");
				*/
					//CRUD -> Create Read Update Delete
					//DELETE
					City city=session.get(City.class,12);
					session.delete(city);
					System.out.println("12 id' li þehir silindi! ");
					
				}finally {
					factory.close();// fabrikayi kapat
				}


	}

}
