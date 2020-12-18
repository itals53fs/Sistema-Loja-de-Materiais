/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
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
    private static FileWriter escrita = null;
    private static JSONParser parser;
    private static Scanner scan = new Scanner(System.in);
    private static final Gson gson = new Gson();
    private final Sistema sistema = new Sistema();
    
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
    
    
    
    /************Arquivo*******************/
    

public static String readFile(String arquivo){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader ler = new BufferedReader(arq);
            String linha = "";
            try {
                linha = ler.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = ler.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conteudo;
    }
    
    /**
     *
     * @param <T>
     * @param lista
     * @param arquivo
     */
    /*public <T> Object puxarDados(List<T> lista, String arq) {
      String linha = null;
      List<T> obj = new ArrayList<T>();
      Type tipoLista = new TypeToken<ArrayList<Object>>() {private Type getType;
      }.getType;
      
      JsonObject json = new JsonObject();
      
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }
            for(T elemento :lista){
                obj.add(elemento);
            }
      Gson gson = new Gson();
       scan.close();
            gson.fromJson(json, tipoLista);
       
    }*/
  public static <T> List<Colaborador> puxarDados(List<T> colecao, String arq) {
      String linha = null;
      List<Colaborador> obj = new ArrayList<Colaborador>();
      Colaborador col = new Colaborador();
        java.lang.reflect.Type t = new TypeToken<ArrayList<T>>() {}.getType();
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            obj = gson.fromJson(linha, t);

            
            scan.close();
       return obj;
    }


     public  static void escrever(String json, String arq) throws IOException{
 
            try {
                Routes.escrita = new FileWriter(arq, true);
                Routes.escrita.write(json+"\n");
                
                 Routes.escrita.close();
            } catch (IOException ex) {
                Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     public static void liparArquivo(String arq){
            try {
           Routes.escrita = new FileWriter(arq);
           Routes.escrita.write("");

            Routes.escrita.close();
       } catch (IOException ex) {
           Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
     public static <T> void enviarParaEscrita(List<T> lista, String arq){
       String json = gson.toJson(lista);
        try {
            Routes.escrever(json, arq);
        } catch (IOException ex) {
            Logger.getLogger(Routes.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}