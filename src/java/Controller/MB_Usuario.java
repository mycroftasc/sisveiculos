/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 631210040
 */
@ManagedBean
@SessionScoped
public class MB_Usuario {
    
    private B_Usuario user;
    private ArrayList<B_Usuario> users;
    private boolean edit = false;

    public MB_Usuario() {
    }

    public void cadastraEeditaUsuario() {
        if (edit) {
            int index = this.users.lastIndexOf(this.user);
            this.users.set(index, user);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Usuario u = new B_Usuario(this.user.getId(), this.user.getNome(), this.user.getDataNascimento(), this.user.getSexo(), this.user.getEmail(), this.user.getSenha());
            BD_Usuario bduser = new BD_Usuario();
            bduser.salvar(u);

            //this.limpaCampos();
            this.edit = false;
        }
    }

    public void excluiUsuario(B_Usuario user) {
        this.user = user;
        int index = this.users.lastIndexOf(user);
        this.users.remove(index);
    }

    public void editaUsuario(B_Usuario u) {
        this.user = u;
        edit = true;
    }

    public B_Usuario getUser() {
        return user;
    }

    public void setUser(B_Usuario user) {
        this.user = user;
    }

    public ArrayList<B_Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<B_Usuario> users) {
        this.users = users;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
}
