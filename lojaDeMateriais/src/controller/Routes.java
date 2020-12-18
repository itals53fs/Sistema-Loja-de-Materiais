/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.Adm;
import model.Cliente;
import model.Colaborador;
import model.Material;
import model.Sistema;
import model.Venda;

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
    
    public void MostrarListaMaterial(){
        sistema.MostrarListaMaterial();
    }
    
    
    
    /***********Início Colaborador***********/
    
    public boolean IncluirColaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone){
        Colaborador colaboradores = new Colaborador(login, senha, nome, endereco, email, cpf, telefone);
        return sistema.IncluirColaborador(colaboradores);
    }
    
    public void mostrarColaboradores(){
        sistema.mostraColaboradores();
    }
    
    /******Inicio clienet**********/
    public boolean IncluirCliente(String nome, String endereco, String email, String cpf, String telefone){
        Cliente clientes = new Cliente(nome, endereco, email, cpf, telefone);
        return sistema.incluirCliente(clientes);
    }
    
    public String MostrarClientes(){
        return sistema.MostrarClientes();
    }
    
    /*********Inicio Venda*******************/
    public boolean RealizarVenda(float valor, int quantidade, String cpfCliente, String Smaterial){
        boolean verificar = false;
        Material material = null;
        Venda venda = new Venda(valor, quantidade, cpfCliente);
        int indexMaterial=0;
        for(int i=0;i<sistema.getEstoque().size(); i++){
            if(Smaterial.equals(sistema.getEstoque().get(i).getNome()) && (quantidade <= sistema.getEstoque().get(i).getQuantidade())){
                material = sistema.getEstoque().get(i);
                indexMaterial = i;
                verificar = true;
            }
        }
        
        if(verificar){
            verificar = false;
            for(Cliente clientes: sistema.getCliente()){
                if(cpfCliente.equals(clientes.getCpf())){
                    verificar = true;
                    if(verificar){
                    clientes.setMateriais(venda);
                    }
                }
            }
        }
                
        if(verificar){
            venda.setMateriais(material);
            venda.setValorTotal(valor*quantidade);
            sistema.getEstoque().get(indexMaterial).menosQuantidade(quantidade);
            
            return sistema.RealizarVendas(venda);
        }     
        return CancelarVenda();
    }
    
    public boolean CancelarVenda(){
        return false;
    }
    public String ConsultarVendas(){
        return sistema.ConsultarVendas();
    }
    
}