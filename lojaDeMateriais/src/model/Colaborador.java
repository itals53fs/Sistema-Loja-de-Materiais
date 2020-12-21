
package model;

import java.util.Date;

public class Colaborador extends Pessoa {
    
    private String login;
    private String senha;
    private static int numeroColaborador;
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
    }
        public Colaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
        numeroColaborador++;
    }


    public Colaborador(){
 
    }

    public static int getNumeroColaborador() {
        return numeroColaborador;
    }

    public static void setNumeroColaborador(int numeroColaborador) {
        Colaborador.numeroColaborador = numeroColaborador;
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
                + " CPF"+ this.getCpf()
                + " Email"+ this.getEmail()
                + " Endereço"+ this.getEndereco()
                + " Telefone"+ this.getTelefone()
                + " nome= " + this.getNome() + "}\n";
    }  
    
}
