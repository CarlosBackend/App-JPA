package Conexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioJPA {
    public static Usuario validarUsuario(Usuario u){
        EntityManager manager = JPAUtil.conectar();
        try{
            Query consulta = manager.createQuery("SELECT u FROM Usuario u WHERE u.login =: login AND u.senha =:senha");
            consulta.setParameter("login", u.getLogin());
            consulta.setParameter("senha", u.getSenha());
            List<Usuario> listaUsuarios = consulta.getResultList();
            if(!listaUsuarios.isEmpty()){
                return listaUsuarios.get(0);
            }
        }catch(Exception ex){
            manager.getTransaction().rollback();
        }finally{
            JPAUtil.desconectar();
        }
        return null;
    }
}
