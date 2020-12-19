/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.google.gson.Gson;
import java.io.FileWriter;
import jdk.nashorn.internal.parser.JSONParser;
import model.Arquivo;
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
    private final Sistema sistema = new Sistema();
    
    /***********Início Material***********/
    public boolean salvarMaetrial(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor){
        Material material = new Material(nome, quantidade, preco, especificacao, margemLucro, fornecedor);
        return sistema.IncluirMaterial(material);
        
    }
    
    public void MostrarListaMaterial(){
        sistema.MostrarListaMaterial();
    }
    
    public boolean AlterarMaterial(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, boolean veri){
        Material material = new Material(nome, quantidade, preco, especificacao, margemLucro, fornecedor, veri);
        return sistema.AlterarMaterial(material);
    }
    
    public boolean ExcluirMaterial(String nome){
        return sistema.ExcluirMaterial(nome);
    }
    
    
    /***********Início Colaborador**********************************************/
    
    public boolean IncluirColaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone){
        Colaborador colaboradores = new Colaborador(login, senha, nome, endereco, email, cpf, telefone);
        return sistema.IncluirColaborador(colaboradores);
    }
    
    //Alterar Colaborador
    public boolean AlterarColaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone, boolean veri){
        Colaborador colaboradores = new Colaborador(login, senha, nome, endereco, email, cpf, telefone, veri);
        return sistema.AlterarColaborador(colaboradores);
    }
    
    public boolean ExcluirColaborador(String cpf){
        return sistema.ExcluirColaborador(cpf);
    }
    
    public Colaborador MostrarColaboradores(String cpf){
        return sistema.MostraColaboradores(cpf);
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
        
        sistema.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
       
        System.out.println(sistema.getCliente());
        for(int i=0;i<sistema.getEstoque().size(); i++){
            if(Smaterial.equals(sistema.getEstoque().get(i).getNome()) && (quantidade <= sistema.getEstoque().get(i).getQuantidade())){
                material = sistema.getEstoque().get(i);
                indexMaterial = i;
                verificar = true;
            }
        }
        
        if(verificar){
            verificar = false;
            for(int i=0; i<sistema.getCliente().size(); i++){
                
                if(cpfCliente.equals(sistema.getCliente().get(i).getCpf())){
                    verificar = true;
                    if(verificar){
                        
                    venda.setMateriais(material);
                    venda.setValorTotal(valor*quantidade);
                    sistema.getCliente().get(i).setMateriais(venda);
                    Arquivo.liparArquivo("data/clientes.json");
                    Arquivo.enviarParaEscrita(sistema.getCliente(), "data/clientes.json");
                    
                    sistema.getEstoque().get(indexMaterial).menosQuantidade(quantidade);
            
                    return sistema.RealizarVendas(venda);
                    }
                }
            }
            
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