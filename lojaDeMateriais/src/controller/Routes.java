/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.Colaborador;
import model.Material;
import model.Sistema;

/**
 *
 * @author tales
 */
public class Routes {
    private Sistema sistema = new Sistema();
    
    /***********Início Material***********/
    public boolean salvarMaetrial(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor){
        Material material = new Material(nome, quantidade, preco, especificacao, margemLucro, fornecedor);
        return sistema.incluirMaterial(material);
        
    }
    
    public void mostrar(){
        sistema.MostrarListaMaterial();
    }
    
    
    
    /***********Início Colaborador***********/
    
    public boolean IncluirColaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone){
        Date dataCadastro = new Date();
        Colaborador colaboradores = new Colaborador(login, senha, nome, endereco, email, cpf, telefone, dataCadastro);
        return sistema.IncluirColaborador(colaboradores);
    }
}