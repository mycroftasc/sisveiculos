/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_ModeloVeiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandre-carmo
 */
public class BD_ModeloVeiculo {
    public void salvar(B_ModeloVeiculo mdl) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mdl);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_ModeloVeiculo mdl) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mdl);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_ModeloVeiculo mdl) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM modelosVeiculos mdl WHERE mdl.id = :n");
            int deletedCount = query.setParameter("n", mdl.getId()).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_ModeloVeiculo> listar(){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_ModeloVeiculo> query = entityManager.createQuery("SELECT m FROM modelosVeiculos m", B_ModeloVeiculo.class);
            
            List<B_ModeloVeiculo> listaModelosVeiculos = query.getResultList();
                   
            entityManager.close();
            
            return listaModelosVeiculos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_ModeloVeiculo pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_ModeloVeiculo mdlPesq = entityManager.find(B_ModeloVeiculo.class, id);
    
    entityManager.close();
    
    return mdlPesq;
    }
}
