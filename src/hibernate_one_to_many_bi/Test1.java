package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//            Department dep = new Department("IT",300,1200);
//
//            Employee emp1 = new Employee("Zaur","Tregulov",800);
//            Employee emp2 = new Employee("Elena","Smirnova",1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//        } finally {
//            session.close();
//            factory.close();
//        }

//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 2);
//            System.out.println(department);
//            System.out.println(department.getEmps()); // выводим всех работников
//            System.out.println("###########################################");
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//        } finally {
//            session.close();
//            factory.close();
//        }
//*******************************************************************************************
        Session session = null;
        try {
            session = factory.getCurrentSession();


            session.beginTransaction();
            Employee employee = session.get(Employee.class, 4);

/*cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE}*
*поменяли в классах Employee, Department чтобы не было каскадного удаления/
 */
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}



