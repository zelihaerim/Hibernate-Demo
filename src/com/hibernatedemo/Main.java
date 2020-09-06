package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

// Hibernate ile database ve objler maplenir.
public class Main {
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
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			//HQL-->Hibernate Query Language
			//sorgu yazilmali ex: select * from world.city
			//from City c where c.countryCode='TUR' OR c.district='Ankara'
			// %kar -> onunde ne oldugu onemli degil sonu 'kar' ile biten
			// kar% ->sonrasinde ne oldugu onemli degil basi 'kar' ile baslayan
			//%kar% -> icinde herhangi bir yerinde kar gecen
			// kar -> sadece kar yazili olan
			//from City c where c.name LIKE '%kar%'
			//from City c ORDER BY c.name ASC or from City c ORDER BY c.name DESC
			List<City> cities=session.createQuery("from City c ORDER BY c.name DESC").getResultList();
			for(City city:cities) {
				System.out.println(city.getName());
			}
			
			
			session.getTransaction().commit();//commit etmek  veritabanina query i gonder demektir
			// rollback fonksiyonu ise veritabanina yapilan degisikligi geri almak icin kullanilir.
		}finally {
			factory.close();// fabrikayi kapat
		}

	}

}
