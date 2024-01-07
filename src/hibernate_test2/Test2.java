package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
////            Employee employee = new Employee("Misha", "Sidorov", "HR", 850);
////            Detail detail = new Detail("London", "5623179654", "mishanya@gmail.com");
//
//            Employee employee1 = new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail1 = new Detail("New-York", "654123789", "nikolay@gmail.com");
//
//            employee1.setEmpDetail(detail1);
//            detail1.setEmployee(employee1);
//
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
//            /*Получили Detail для id#4*/
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
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
//            Detail detail = session.get(Detail.class, 4);
//            /*удаляем детали и работника благодаря каскаду*/
//            session.delete(detail);
//            session.getTransaction().commit();
//            System.out.println("Done");
//        } finally {
//            factory.close();
//        }

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            /*получаю работника с id#1
            * так же в классе Detail меняю cascade type c ALL на PERSIST, REFRESH*/
            Detail detail = session.get(Detail.class, 1);

            /*разрываю связь между таблицами employees и details
            * указываю null*/
            detail.getEmployee().setEmpDetail(null);

            /*удаляем детали но работник остается*/
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}



