import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.AppointRecord;
import entity.AppointRecordFee;
import entity.Phone;
import entity.PhoneDetails;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by cq on 2017/8/3.
 */
public class Main {
    private static SessionFactory sessionFactory;

    static  {
        // A SessionFactory is set up once for an application!

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("C:\\learn\\gits\\testJava\\hhhbierbante\\src\\main\\java\\hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static void main(final String[] args) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        //saveAppointRecord(session);
        //saveAppointRecordFee(session);
        //findAppointRecordFeeById(session, 1);
       //savePhone(session);
        //getPhoneById(session,7L);
        //updatePhoneDetail(session, 7L);

    }

    private static void saveAppointRecord(Session session) {
        AppointRecord appointRecord = new AppointRecord();
        appointRecord.setPatientName("黄飞鸿2");

        try {
            session.save(appointRecord);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    private static void saveAppointRecordFee(Session session) {
        AppointRecordFee appointRecordFee = new AppointRecordFee();
        appointRecordFee.setAppointId(8);
        appointRecordFee.setAppointTotalFee(new BigDecimal(100));
        appointRecordFee.setAppointDiscountFee(new BigDecimal(1));
        appointRecordFee.setAppointCouponFee(new BigDecimal(2));

        try {
            session.save(appointRecordFee);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static Object findAppointRecordById(Session session, Integer appointId) {
        Query namedQuery = session.createQuery("from AppointRecordFee where appointId=" + appointId);
        Object singleResult = namedQuery.getSingleResult();
        return singleResult;
    }
    public static Object findAppointRecordFeeById(Session session, Integer appointId) {
        Query namedQuery = session.createQuery("from AppointRecordFee where appointId=" + appointId);
        Object singleResult = namedQuery.getSingleResult();
        return singleResult;
    }

    public static void savePhone(Session session) {
        Phone phone = new Phone( "123-456-7890" );
        PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );
        session.save(details);
        //session.flush();
        phone.setDetails(details);

        session.save(phone);
        session.getTransaction().commit();
        session.close();
    }
    public static void updatePhoneDetail(Session session,Long phoneId) {
        getPhoneById(session, phoneId);
    }


    public static Phone getPhoneById(Session session,Long phoneId){

        Query query = session.createQuery("from Phone where id=:id");
        query.setParameter("id", phoneId);
        Phone singleResult = (Phone)query.getSingleResult();

        try {
            System.out.println(new ObjectMapper().writeValueAsString(singleResult));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        session.close();
        return singleResult;
    }
}