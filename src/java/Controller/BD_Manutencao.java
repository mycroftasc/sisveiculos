/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Manutencao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author JeanCarlo
 */
public class BD_Manutencao {
    public void salvar(B_Manutencao mnt) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mnt);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_Manutencao mnt) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mnt);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_Manutencao mnt) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM manutencoes mnt WHERE mnt.id = :n");
            int deletedCount = query.setParameter("n", mnt.getId()).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_Manutencao> listar(){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_Manutencao> query = entityManager.createQuery("SELECT m FROM manutencoes m", B_Manutencao.class);
            
            List<B_Manutencao> listaManutencoes = query.getResultList();
                   
            entityManager.close();
            
            return listaManutencoes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_Manutencao pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_Manutencao manPesq = entityManager.find(B_Manutencao.class, id);
    
    entityManager.close();
    
    return manPesq;
    }
}
