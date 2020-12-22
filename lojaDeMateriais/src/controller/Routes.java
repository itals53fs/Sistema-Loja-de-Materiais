/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.text.ParseException;
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
    public boolean IncluirMaetrial(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, String datafabricacao){
        Material material = new Material(nome, quantidade, preco, especificacao, margemLucro, fornecedor, datafabricacao);
        return sistema.IncluirMaterial(material);
        
    }
    
    public String ImprimirEstoque(){
        return sistema.ImprimirEstoque();
    }
    
    public boolean AlterarMaterial(String nome, int quantidade, float preco, String especificacao, float margemLucro, String fornecedor, String datafabricacao){
        Material material = new Material(nome, quantidade, preco, especificacao, margemLucro, fornecedor, datafabricacao, false);
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
    public boolean AlterarColaborador(String login, String senha, String nome, String endereco, String email, String cpf, String telefone){
        Colaborador colaboradores = new Colaborador(login, senha, nome, endereco, email, cpf, telefone, false);
        return sistema.AlterarColaborador(colaboradores);
    }
    
    public boolean ExcluirColaborador(String cpf){
        return sistema.ExcluirColaborador(cpf);
    }
    
    public String ImprimirColaborador(String cpf){
        return sistema.ImprimirColaborador(cpf);
    }
    
        public String ImprimirListaColaboradores(){
        return sistema.ImprimirListaColaboradores();
    }
    
    /******Inicio clienet**********/
    public boolean IncluirCliente(String nome, String endereco, String email, String cpf, String telefone){
        Cliente clientes = new Cliente(nome, endereco, email, cpf, telefone);
        return sistema.incluirCliente(clientes);
    }
    public boolean ExcluirCliente(String cpf){
        return sistema.ExcluirCliente(cpf);
    }
        public boolean AlterarCliente(String nome, String endereco, String email, String cpf, String telefone){
            Cliente cliente = new Cliente(nome, endereco, email, cpf, telefone, true);
        return sistema.AterarCliente(cliente);
    }
    
    public String ImprimirListaClientes(){
        return sistema.ImprimirListaCliente();
    }
    
    public String MostrarColaboradoresClientes(){
        return Sistema.MostrarNumeroClientesColaboradores();
    }
    
    /*********Inicio Venda*******************/
    public boolean RealizarVenda(int quantidade, String cpfCliente, String Smaterial){
        boolean verificar = false;
        Material material = null;
        Venda venda = new Venda(quantidade, cpfCliente);
        int indexMaterial=0;
        
        sistema.getCliente().clear();;
        sistema.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
       
        sistema.getEstoque().clear();
        sistema.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
            System.out.println(sistema.getEstoque());
            
            if(sistema.getEstoque() != null && sistema.getCliente() !=null){
                verificar = true;
            }
           
            if(verificar){
                verificar = false;
                for(int i=0;i<sistema.getEstoque().size(); i++){
                    if(Smaterial.equals(sistema.getEstoque().get(i).getNome()) && (quantidade <= sistema.getEstoque().get(i).getQuantidade()) && quantidade > 0){
                        material = sistema.getEstoque().get(i);
                        indexMaterial = i;
                        verificar = true;
                    }
                }
            }
        
        if(verificar){
            verificar = false;
            for(int i=0; i<sistema.getCliente().size(); i++){
                if(cpfCliente.equals(sistema.getCliente().get(i).getCpf())){
                    verificar = true;
                    if(verificar){
                        
                    venda.setMateriais(material);
                    venda.setValorTotal(quantidade*material.getPreco());
                    sistema.getCliente().get(i).setMateriais(venda);
                    Arquivo.liparArquivo("data/clientes.json");
                    Arquivo.enviarParaEscrita(sistema.getCliente(), "data/clientes.json");
                    
                    sistema.getEstoque().clear();
                    sistema.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
                    sistema.getEstoque().get(indexMaterial).menosQuantidade(quantidade);
                    Arquivo.liparArquivo("data/estoque.json");
                    Arquivo.enviarParaEscrita(sistema.getEstoque(), "data/estoque.json");
                    sistema.setVenda(Arquivo.puxarDadosVenda("data/vendas.json"));
                    venda.setIdVenda(sistema.getVenda().size());
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
    
    public boolean login(String login, String senha){

         return sistema.loginColaborador(login, senha);
      
    }
   
}