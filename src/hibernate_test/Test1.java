package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Zaur", "Tregulov"
                    , "IT", 500);
            Employee emp1 = new Employee("Mikhail", "Ivanov"
                    , "HR", 750);
            Employee emp2 = new Employee("Aleksandr", "Smirnov"
                    , "Sales", 700);
            Employee emp3 = new Employee("Aleksandr", "Ivanov"
                    , "IT", 600);
            session.beginTransaction();
            session.save(emp3);
            session.getTransaction().commit();
            System.out.println("Done");
            System.out.println(emp3);
        } finally {
            factory.close();
        }
    }
}



