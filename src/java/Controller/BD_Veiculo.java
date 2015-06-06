/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author JeanCarlo
 */
public class BD_Veiculo {

    public void salvar(B_Veiculo v) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(v);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(B_Veiculo v) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(v);

            entityManager.getTransaction().commit();

            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(B_Veiculo v) {

        try {
            EntityManager entityManager = Conexao.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM veiculos v WHERE v.id = :n");
            int deletedCount = query.setParameter("n", v.getId()).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<B_Veiculo> listar() {

        try {
            EntityManager entityManager = Conexao.getEntityManager();

            TypedQuery<B_Veiculo> query = entityManager.createQuery("SELECT v FROM veiculos v", B_Veiculo.class);

            List<B_Veiculo> listaVeiculos = query.getResultList();

            entityManager.close();

            return listaVeiculos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public B_Veiculo pesquizarPorID(Integer id) {

        EntityManager entityManager = Conexao.getEntityManager();

        B_Veiculo manPesq = entityManager.find(B_Veiculo.class, id);

        entityManager.close();

        return manPesq;
    }
}
