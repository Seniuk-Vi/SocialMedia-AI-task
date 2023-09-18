package com.epam.lab.socialmediaaitask.Config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtil {

    @Bean
    public SessionFactory buildSessionFactory() {
        try {
            // Create a StandardServiceRegistry with the hibernate configuration
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    configure("hibernate.cfg.xml").build();

            // Create Metadata with the service registry and add entity classes
            Metadata metadata = new MetadataSources(serviceRegistry)
                    .addResource("User.hbm.xml")
                    .addResource("Post.hbm.xml")
                    .addResource("Like.hbm.xml")
                    .buildMetadata();

            // Return a SessionFactory created from the Metadata
            return metadata.buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Error creating SessionFactory: " + e.getMessage());
        }
    }

}
