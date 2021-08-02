import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Purchase> listok = session.createQuery("FROM Purchase").list();
        listok.forEach(purchase -> {

            Query queryStudent = session.createQuery("FROM Student WHERE name = :name");
            queryStudent.setParameter("name", purchase.getStudentName());
            Student student = (Student) queryStudent.getSingleResult();
            Query queryCourse = session.createQuery("FROM Course WHERE name = :name");
            queryCourse.setParameter("name", purchase.getCourseName());
            Course course = (Course) queryCourse.getSingleResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(student, course);
            session.save(linkedPurchaseList);
        });
        transaction.commit();
        session.close();
    }
}