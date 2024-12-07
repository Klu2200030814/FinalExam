package com.klu.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDom {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create and persist Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Generic Vehicle");
        vehicle.setType("Generic");
        vehicle.setMaxSpeed(80);
        vehicle.setColor("Blue");

        // Create and persist Car
        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(150);
        car.setColor("Red");
        car.setNumberOfDoors(4);

        // Create and persist Truck
        Truck truck = new Truck();
        truck.setName("Hauler");
        truck.setType("Truck");
        truck.setMaxSpeed(100);
        truck.setColor("Green");
        truck.setLoadCapacity(15);

        // Persist all objects
        session.persist(vehicle);
        session.persist(car);
        session.persist(truck);

        tx.commit();

        System.out.println("Data inserted successfully!");
        session.close();
        factory.close();
    }
}
