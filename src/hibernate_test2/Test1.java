package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

//        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur","Tregulov","IT",500);
//            Detail detail = new Detail("Baku","123456789","zaurtregulov@gmail.com");
//
//            Employee employee1 = new Employee("Oleg","Smirnov","Sales",700);
//            Detail detail1 = new Detail("Moscow","987654321","olejka@gmail.com");
//
//            employee1.setEmpDetail(detail1);
//            session.beginTransaction();
//
//            session.save(employee1);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//        } finally {
//            factory.close();
//        }

//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            /*получаем сотрудника с id 1*/
//            Employee emp = session.get(Employee.class, 1);
//            /*получаем детали сотрудника с id 1 благодаря каскаду*/
//            System.out.println(emp.getEmpDetail());
//
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//        } finally {
//            session.close();
//            factory.close();
//        }

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            /*получаем сотрудника с id 1*/
            Employee emp = session.get(Employee.class, 3);
            /*удаляем сотрудника с id 2 в таблице Employee и Detail*/
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}



