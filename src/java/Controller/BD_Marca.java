/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandre-carmo
 */
public class BD_Marca {
    public void salvar(B_Marca mrc) {

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

    public void editar(B_Marca mrc) {

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

    public void excluir(B_Marca mrc) {

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

    public List<B_Marca> listar(B_Marca u){
     
        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_Marca> query = entityManager.createNamedQuery("FROM marcasVeiculos m", B_Marca.class);
            
            List<B_Marca> listaManutencoes = query.getResultList();
                   
            entityManager.close();
            
            return listaManutencoes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public B_Marca pesquizarPorID(Integer id){
    
    EntityManager entityManager = Conexao.getEntityManager();
    
    B_Marca mrcPesq = entityManager.find(B_Marca.class, id);
    
    entityManager.close();
    
    return mrcPesq;
    }
}
