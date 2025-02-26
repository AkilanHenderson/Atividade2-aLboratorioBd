package project.java;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //Rode essa classe antes de rodar qualquer outra class teste
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("transportadoraPu");
            EntityManager em = emf.createEntityManager();
            System.out.println("Conexão com o banco de dados estabelecida!");
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
