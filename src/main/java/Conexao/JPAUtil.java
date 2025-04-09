package Conexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static String PERSISTENCE_UNIT = "cenaflixx";
    private static EntityManager gerente; 
    private static EntityManagerFactory fabrica; 
    
    public static EntityManager conectar() {
        if(fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if(gerente == null || !gerente.isOpen()) {
            gerente = fabrica.createEntityManager();
        }
        return gerente;
    }
    public static void desconectar() {
        if(gerente.isOpen() && gerente != null) {
            gerente.close();
            fabrica.close();
        }
    }
}
