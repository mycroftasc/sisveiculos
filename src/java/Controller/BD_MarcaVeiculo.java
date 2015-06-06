/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_MarcaVeiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandre-carmo
 */
public class BD_MarcaVeiculo {
    public void salvar(B_MarcaVeiculo mrc) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mrc);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_MarcaVeiculo mrc) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(mrc);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_MarcaVeiculo mrc) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM marcasVeiculos mrc WHERE mrc.id = :n");
            int deletedCount = query.setParameter("n", mrc.getId()).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_MarcaVeiculo> listar(){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_MarcaVeiculo> query = entityManager.createQuery("SELECT m FROM marcasVeiculos m", B_MarcaVeiculo.class);
            
            List<B_MarcaVeiculo> listaMarcasVeiculos = query.getResultList();
                   
            entityManager.close();
            
            return listaMarcasVeiculos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_MarcaVeiculo pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_MarcaVeiculo mrcPesq = entityManager.find(B_MarcaVeiculo.class, id);
    
    entityManager.close();
    
    return mrcPesq;
    }
}
