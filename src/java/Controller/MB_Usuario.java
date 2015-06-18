/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 631210040
 */
@ManagedBean(name = "mbUser")
@SessionScoped
public class MB_Usuario {

    private B_Usuario user;
    private List<B_Usuario> users;
    private boolean edit = false;

    public MB_Usuario() {
        this.user = new B_Usuario();
        this.users = new ArrayList<B_Usuario>();
        this.listarUsuario();
    }

    public void cadastraEeditaUsuario() {
        if (edit) {
            B_Usuario u = new B_Usuario(this.user.getId(), this.user.getNome(), this.user.getDataNascimento(), this.user.getSexo(), this.user.getEmail(), this.user.getSenha(), this.user.getCep(), this.user.getEstado(), this.user.getCidade(), this.user.getBairro(), this.user.getEndereco());
            BD_Usuario bduser = new BD_Usuario();
            bduser.editar(u);
            this.listarUsuario();
            this.edit = false;
        } else {
            B_Usuario u = new B_Usuario(this.user.getId(), this.user.getNome(), this.user.getDataNascimento(), this.user.getSexo(), this.user.getEmail(), this.user.getSenha(), this.user.getCep(), this.user.getEstado(), this.user.getCidade(), this.user.getBairro(), this.user.getEndereco());
            BD_Usuario bduser = new BD_Usuario();
            bduser.salvar(u);

            this.listarUsuario();
            this.edit = false;
        }
    }

    public void excluiUsuario(B_Usuario user) {
        BD_Usuario bdu = new BD_Usuario();
        bdu.excluir(user);
        this.listarUsuario();
    }

    public void editaUsuario(B_Usuario u) {
        this.user = u;
        edit = true;
    }

    public void listarUsuario() {
        this.limpar();
        BD_Usuario bdu = new BD_Usuario();
        this.users = bdu.listar();
    }

    public void limpar() {
        this.users.clear();
        this.user.setDataNascimento(null);
        this.user.setEmail(null);
        this.user.setId(null);
        this.user.setNome(null);
        this.user.setSenha(null);
        this.user.setSexo(null);
        this.user.setCep(null);
        this.user.setEstado(null);
        this.user.setCidade(null);
        this.user.setBairro(null);
        this.user.setEndereco(null);
    }

    public void buscaCep() throws ParseException {
        try {

            URL url = new URL("http://api.postmon.com.br/v1/cep/" + this.user.getCep());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = br.readLine();
            
            conn.disconnect();
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(output);
            
            this.user.setEstado((String) jsonObject.get("estado"));
            this.user.setCidade((String) jsonObject.get("cidade"));
            this.user.setBairro((String) jsonObject.get("bairro"));
            this.user.setEndereco((String) jsonObject.get("logradouro"));
            
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        
    }

    public B_Usuario getUser() {
        return user;
    }

    public void setUser(B_Usuario user) {
        this.user = user;
    }

    public List<B_Usuario> getUsers() {
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
