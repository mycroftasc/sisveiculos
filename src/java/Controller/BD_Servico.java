/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Servico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author 631210040
 */
public class BD_Servico {

    public void salvar(B_Servico manut) {

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

    public void editar(B_Servico manut) {

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

    public void excluir(B_Servico manut) {

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

    public List<B_Servico> listar(B_Servico manut){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_Servico> query = entityManager.createNamedQuery("FROM manutencoes m", B_Servico.class);
            
            List<B_Servico> listaManutencoes = query.getResultList();
                   
            entityManager.close();
            
            return listaManutencoes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_Servico pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_Servico manPesq = entityManager.find(B_Servico.class, id);
    
    entityManager.close();
    
    return manPesq;
    }
}
