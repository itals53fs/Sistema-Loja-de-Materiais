
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
                + " \nlogin: \t\t" + login 
                + " \nsenha: \t\t" + senha
                + " \nCPF: \t\t"+ this.getCpf()
                + " \nEmail: \t\t"+ this.getEmail()
                + " \nEndereço: \t\t"+ this.getEndereco()
                + " \nTelefone: \t\t"+ this.getTelefone()
                + " \nnome: \t\t" + this.getNome() + "\n}\n\n";
    }  
    
}
