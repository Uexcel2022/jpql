package com.uexcel.persistence;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CustomEntityManager {

    public static EntityManager getEntityManager() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        // properties.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory entityManagerFactory = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), properties);

        return entityManagerFactory.createEntityManager();
    }

}
