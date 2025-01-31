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
    private String dataFabricacao;
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

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }



    public Material(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, String dataFabricacao){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.especificacao = especificacao;
        this.margemLucro = margemLucro;
        this.fornecedor = fornecedor;
        this.dataFabricacao = dataFabricacao;
        numeroEstoque++;
    }
        public Material(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, String dataFabricacao, boolean veri){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.especificacao = especificacao;
        this.margemLucro = margemLucro;
        this.fornecedor = fornecedor;
        this.dataFabricacao = dataFabricacao;
    }

    public Material() {
    }

    @Override
    public String toString() {
        return "Material{"
                + "\nnome:\t\t" + nome 
                + "\nquantidade:\t\t" + quantidade 
                + "\npreco:\t\t" + preco 
                + "\nespecificacao:\t\t" + especificacao 
                + "\nmargemLucro:\t\t" + margemLucro 
                + "\ndata de fabricação:\t\t"+ dataFabricacao
                + "\nfornecedor:\t\t" + fornecedor + 
                "\n}\n";
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
