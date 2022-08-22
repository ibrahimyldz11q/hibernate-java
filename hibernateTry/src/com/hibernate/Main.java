package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();


            City city = new City();
            city.setName("Heloowo");
            city.setCountryCode("TUR");
            city.setDistrict("Karadeniz");
            city.setPopulation(5423);


            session.save(city);

            session.getTransaction().commit();
            System.out.println("Eklendi");


        } finally {
            sessionFactory.close();
        }
//
//        session.beginTransaction();
//
//        List<City> cities = session.createQuery("from city").getResultList();
//
//
//        for (City city : cities){
//            System.out.println(city.getName());
//        }
//
//        session.beginTransaction().commit();

        //UPDATE
/*        City city = session.get(City.class,1);
        city.setName("ibrahim");
        session.save(city);
        System.out.println(city.getName());

        session.beginTransaction().commit();
        sessionFactory.close();


        DELETE
        session.delete(city);
        session.save(city);*/
    }
}