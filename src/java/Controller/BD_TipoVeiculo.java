/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_TipoVeiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandre-carmo
 */
public class BD_TipoVeiculo {
   public void salvar(B_TipoVeiculo tp) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(tp);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_TipoVeiculo tp) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(tp);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_TipoVeiculo tp) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(tp);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_TipoVeiculo> listar(B_TipoVeiculo tp){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_TipoVeiculo> query = entityManager.createNamedQuery("FROM tiposVeiculos tp", B_TipoVeiculo.class);
            
            List<B_TipoVeiculo> listaTiposVeiculos = query.getResultList();
                   
            entityManager.close();
            
            return listaTiposVeiculos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_TipoVeiculo pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_TipoVeiculo tpPesq = entityManager.find(B_TipoVeiculo.class, id);
    
    entityManager.close();
    
    return tpPesq;
    } 
}
