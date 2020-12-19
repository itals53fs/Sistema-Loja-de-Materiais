/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tales
 */
public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String email;
    private String cpf;
    private String telefone;
    private Date dataCadastro = new Date();
    protected static int[] numeroPesssoa = new int[2];
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Pessoa(String nome, String endereco, String email, String cpf, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        Pessoa.setNumeroPesssoa(Arquivo.puxarDadosPessoas("data/numeroPessoas.json"));
        Arquivo.liparArquivo("data/numeroPessoas.json");
        
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public static int[] getNumeroPesssoa() {
        return numeroPesssoa;
    }

    public static void setNumeroPesssoa(int[] numeroPesssoa) {
        Pessoa.numeroPesssoa = numeroPesssoa;
    }
    public static void mudarIndex(int i, int num){
        Pessoa.getNumeroPesssoa()[i] = num;
    }



    public Pessoa() {
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public abstract String toString();
}
