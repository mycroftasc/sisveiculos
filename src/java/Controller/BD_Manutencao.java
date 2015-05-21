/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Manutencao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author 631210040
 */
public class BD_Manutencao {

    public void salvar(B_Manutencao manut) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(manut);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_Manutencao manut) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(manut);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_Manutencao manut) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(manut);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_Manutencao> listar(B_Manutencao manut){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_Manutencao> query = entityManager.createNamedQuery("FROM manutencoes m", B_Manutencao.class);
            
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
