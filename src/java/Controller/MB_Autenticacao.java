/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Autenticacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexandre-carmo
 */
@ManagedBean (name = "mbAut")
@SessionScoped
public class MB_Autenticacao {

    private B_Autenticacao autBean;       
    /**
     * Creates a new instance of MB_Autenticacao
     */
    public MB_Autenticacao() {
        autBean = new B_Autenticacao();
    }
    
    public String autenticacao(){
        if ("admin".equals(autBean.getUser()) && "admin".equals(autBean.getPass())) {
            return "Pages/home";
        } else {
            return "../index";
        }
    }
    
    public void logoff(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public B_Autenticacao getB_Autenticacao(){
        return autBean;
    }
    
    public void setB_Autenticacao(B_Autenticacao autBean){
        this.autBean = autBean;
    }
}
