package com.uexcel;

import com.uexcel.entity.Product;
import com.uexcel.persistence.CustomEntityManager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class App
{
    public static void main( String[] args ) throws Exception {
        try (EntityManager entityManager = CustomEntityManager.getEntityManager()) {

            entityManager.getTransaction().begin();
            String jpql = "SELECT p FROM Product p";

            List<Product> products =  entityManager.createQuery(jpql, Product.class).getResultList();
            for(Product product: products){
                System.out.println(product);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
