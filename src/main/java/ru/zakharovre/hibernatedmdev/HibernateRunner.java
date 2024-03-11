package ru.zakharovre.hibernatedmdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.zakharovre.hibernatedmdev.entity.User;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan_ivanov")
                    .firstname("ivan")
                    .lastname("ivanov")
                    .age(31)
                    .birthDate(LocalDate.of(2000,1,2))
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }
    }

}
