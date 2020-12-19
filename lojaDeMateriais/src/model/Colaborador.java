
package model;

import java.util.Date;

public class Colaborador extends Pessoa {
    
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Colaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone, boolean veri) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
        Arquivo.enviarParaEscrita(numeroPesssoa, "data/numeroPessoas.json");
    }
        public Colaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
       
        numeroPesssoa[0]++;
   
        Arquivo.enviarParaEscrita(numeroPesssoa, "data/numeroPessoas.json");
    }


    public Colaborador(){
 
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Colaborador{" 
                + " login= " + login 
                + " senha= " + senha
                + " nome= " + this.getNome() + '}';
    }  
    
}
