package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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
            Employee emp4 = new Employee("Elena", "Petrova"
                    , "Sales", 800);
            Employee emp5 = new Employee("Oleg", "Sidorov"
                    , "HR", 700);
            session.beginTransaction();
            session.save(emp5);
//            session.getTransaction().commit();

            int myId = emp4.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class,myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}



