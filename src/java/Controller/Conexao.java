/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 
/**
 *
 * @author 631210040
 */
public class Conexao {
   
    /* criação de uma conexão para persistência utilizando factory do 
       EntityManager e associando a unidade de persistência criada. 
       ATENÇÃO: usar o nome completo da Unidade de Persistência */
    private static final EntityManagerFactory factory = 
                  Persistence.createEntityManagerFactory("sisveiculosPU");
    
    // método que será chamado para abertura de conexão com a base de dados
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}


