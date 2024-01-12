package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

//        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//
//
//
//            session.beginTransaction();
//
//            session.save(section1);
///*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})*/
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
///*сохраняем каждого ребенка отдельно, потому что поменяли Cascade Type*/
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
//*****************************************************************************
//
//        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Olya", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavlik", 9);
//            /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})*/
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            /*меняем save на persist сохраняя секцию дети подтягиваются тоже*/
//            session.persist(section1);
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

//*****************************************************************************
//        try {
//            session = factory.getCurrentSession();
//
//
//            session.beginTransaction();
//            Section section = session.get(Section.class, 7);
//            /*каскадного удаления нет, дети не удаляются*/
//            /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})*/
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
//*****************************************************************************
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Child child = session.get(Child.class, 5);
            /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
            * удалили ребенка и секцию в которую ходит, child_section связь осталась на месте*/
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!!!");
//*****************************************************************************
//        Session session = null;
//
//        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("VolleyBall");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//            /*добавляем несколько секций одномму ребенку*/
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//
//            session.beginTransaction();
//            /*сохраняем секции ребенку*/
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
//*****************************************************************************
//        Session session = null;
//
//        try {
//            session = factory.getCurrentSession();
//
//
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
//*****************************************************************************
//        Session session = null;
//
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");
            //*****************************************************************************

//        Session session = null;
//
//        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
//
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

        } finally {
            session.close();
            factory.close();
        }
    }
}