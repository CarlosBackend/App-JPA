package Conexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JPAPodcast {
     public static void cadastrar(Podcast p){
      EntityManager em = JPAUtil.conectar();
      try{
          em.getTransaction().begin();
          em.persist(p);
          em.getTransaction().commit();
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }finally{
          em.close();
      }
  }
  public static List<Podcast> listar(){
      EntityManager em = JPAUtil.conectar();
      try{
      Query consulta =  em.createQuery("SELECT p FROM podcast p", Podcast.class);
       consulta.getResultList();
       List<Podcast> lista = consulta.getResultList();
      return lista;
  }catch(Exception e){
      e.printStackTrace();
      return new ArrayList<>();
  }finally{
          em.close();
      }
  }
  public static List<Podcast> buscarPorProdutor(String produtor){
      EntityManager em = JPAUtil.conectar();
      try{
          TypedQuery<Podcast> query = em.createQuery("SELECT p FROM podcast p WHERE LOWER(p.produtor) LIKE :nome", Podcast.class);
          return query.getResultList();
      }catch(Exception e){
          e.printStackTrace();
          return new ArrayList<>();
      }finally{
          em.close();
      }
  }
  public static void excluir(int id){
      EntityManager em = JPAUtil.conectar();
      try{
          Podcast p = em.find(Podcast.class,id);
          if(p !=null){
              em.getTransaction().begin();
              em.remove(p);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
      }finally{
          em.close();
      }
  }
}
