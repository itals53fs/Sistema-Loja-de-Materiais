/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author tales
 */
public class Material implements Comparable<Material>{
    private String nome;
    private int quantidade;
    private float preco;
    private String especificacao;
    private float margemLucro;
    private Date create_at = new Date();
    private String fornecedor;
    private static int numeroEstoque;

    public String getNome() {
        return nome;
    }

    public String getCreate_at() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(create_at);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void maisQuantidade(int quantidade){
        this.quantidade += quantidade;
    }
    public void menosQuantidade(int quantidade){
        this.quantidade -= quantidade;
    }
    
    public void printTodos() throws ParseException{
        System.out.println("nome: " + this.getNome() +
         " \nPreco: " + this.getPreco() +
        "\nQuantidade: "+ 
        this.getQuantidade()+
        "\nEspercificação: "+ 
        this.getEspecificacao() +
        "\nMargem Lucro: "
        + this.getMargemLucro() +
        "\nData de cadastro: "+ this.getCreate_at() + "\ndata de fabricação: ");
    }

    public Material(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.especificacao = especificacao;
        this.margemLucro = margemLucro;
        this.fornecedor = fornecedor;
        numeroEstoque++;
    }
        public Material(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, boolean veri) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.especificacao = especificacao;
        this.margemLucro = margemLucro;
        this.fornecedor = fornecedor;
    }

    public Material() {
    }

    @Override
    public String toString() {
        return "Material{" + "nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + ", especificacao=" + especificacao + ", margemLucro=" + margemLucro + ", create_at=" + create_at + ", fornecedor=" + fornecedor + '}';
    }

    @Override
    public int compareTo(Material material) {
        if(this.getQuantidade() < material.getQuantidade()){
            return -1;
        }else if(this.getQuantidade() > material.getQuantidade()){
            return 1;
        }
        
         return 0;
    }
    
   
    
        
}
