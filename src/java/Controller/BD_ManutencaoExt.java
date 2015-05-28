/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_ManutencaoExt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JeanCarlo
 */
public class BD_ManutencaoExt {
    public void salvar(B_ManutencaoExt u) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(u);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_ManutencaoExt u) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(u);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_ManutencaoExt u) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(u);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_ManutencaoExt> listar(B_ManutencaoExt u){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_ManutencaoExt> query = entityManager.createNamedQuery("FROM manutencoes m", B_ManutencaoExt.class);
            
            List<B_ManutencaoExt> listaManutencoes = query.getResultList();
                   
            entityManager.close();
            
            return listaManutencoes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_ManutencaoExt pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_ManutencaoExt manPesq = entityManager.find(B_ManutencaoExt.class, id);
    
    entityManager.close();
    
    return manPesq;
    }
}
