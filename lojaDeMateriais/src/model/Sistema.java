/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Routes;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tales
 */
public class Sistema {
    private Colaborador[] colaboradors = new Colaborador[50];
    private List<Venda> venda = new ArrayList<Venda>();
    private List<Cliente> cliente = new ArrayList<Cliente>();
    private List<Material> estoque = new ArrayList<Material>();
    private Scanner scan = new Scanner(System.in);
    Scanner in;
    
    //-- Incluir Colaborador****************************************************
    public boolean IncluirColaborador(Colaborador colaborador){
         
             //Sobrescrever o vetor
   
             this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
             for(int i =0; i<colaboradors.length; i++){
                 if(this.colaboradors[i]!=null){
                 if(colaborador.getCpf().equals(this.colaboradors[i].getCpf())){
                    System.out.println("aaaaaaaa");
                     return false;
                 }
                 }
             }
             
               for(int i =0; i<colaboradors.length; i++){
                   
                   if((colaboradors[i]==null)){
                       colaboradors[i] = colaborador;
                    
                                        
                        Arquivo.liparArquivo("data/colaboradores.json");
                        Arquivo.enviarParaEscrita(this.colaboradors, "data/colaboradores.json");
                       break;
                   }
               }
        return true;
    }
    //Alterar colaborador
    public  boolean AlterarColaborador(Colaborador colaborador){
        this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
        
        for(int i =0; i<colaboradors.length; i++){
            if(this.colaboradors[i]!=null){
                if(colaborador.getCpf().equals(this.colaboradors[i].getCpf())){
                    this.colaboradors[i] = colaborador;
                    Arquivo.liparArquivo("data/colaboradores.json");
                    Arquivo.enviarParaEscrita(this.colaboradors, "data/colaboradores.json");
                 return true;
                }
            }
        }
        
        return false;
    }
    public boolean ExcluirColaborador(String cpf){
        this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
        
        for(int i =0; i<colaboradors.length; i++){
            if (this.colaboradors[i]!=null){
            if(cpf.equals(this.colaboradors[i].getCpf())){
                this.colaboradors[i] = null;
                Arquivo.liparArquivo("data/colaboradores.json");
                Arquivo.enviarParaEscrita(this.colaboradors, "data/colaboradores.json");
           
             return true;
            }
            }
        }
        
        return false;
    }
    
    public String ImprimirColaborador(String cpf){
        this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
        
        for(int i =0; i<colaboradors.length; i++){
            if (this.colaboradors[i]!=null){
                if(cpf.equals(this.colaboradors[i].getCpf())){

                    return this.colaboradors[i].toString();
                }  
            }
        }
        return null;
    }
    
    public String ImprimirListaColaboradores(){
        this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
        String colaboradores = "";
        for(int i =0; i<colaboradors.length; i++){
            if(this.colaboradors[i]!=null){
                colaboradores += this.colaboradors[i].toString();
                
            }
        }
        return colaboradores;
    }
    
    //-- Incluir Cliente********************************************************
    public boolean incluirCliente(Cliente clientes){
  
            this.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
            for(Cliente cliente: this.cliente){
                if(cliente.getCpf().equals(clientes.getCpf())){
                    return false;
                }
            }
            this.cliente.add(clientes);
      
            Arquivo.liparArquivo("data/clientes.json");
            Arquivo.enviarParaEscrita(this.cliente, "data/clientes.json");
            this.cliente.clear();
        return true;
    }
    
    public boolean AterarCliente(Cliente clientes){
            this.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
            for(Cliente cliente: this.cliente){
                if(cliente.getCpf().equals(clientes.getCpf())){
                    this.cliente.remove(cliente);
                    this.cliente.add(clientes);
                    
                    Arquivo.liparArquivo("data/clientes.json");
                    Arquivo.enviarParaEscrita(this.cliente, "data/clientes.json");
                    this.cliente.clear();
                    return true;
                }
            }
            this.cliente.clear();
        return false;
    }
    
        public boolean ExcluirCliente(String cpf){
            this.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
            for(Cliente cliente: this.cliente){
                if(cpf.equals(cliente.getCpf())){
                    this.cliente.remove(cliente);
                    Arquivo.liparArquivo("data/clientes.json");
                    Arquivo.enviarParaEscrita(this.cliente, "data/clientes.json");
                    this.cliente.clear();
                    return true;
                }
            }
            this.cliente.clear();
        return false;
    }
        
        public String ImprimirListaCliente(){
            String clientes = "";
            this.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
            for(Cliente cliente: this.cliente){
                clientes += cliente.toString()+"\n";
            }
            this.cliente.clear();
            return clientes;
        }
        public String ImprimirInfoCliente(String cpf){
            this.setCliente(Arquivo.puxarDadosCliente("data/clientes.json"));
            for(Cliente cliente: this.cliente){
                if(cpf.equals(cliente.getCpf())){
                    this.cliente.clear();
                    return cliente.toString();
                }
            }
            this.cliente.clear();
            return null;
        }
    
    
    /******************Incluir marerial*******************************************/
    
       public boolean IncluirMaterial(Material material){
           
          this.estoque.clear();

          this.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
        for(int i =0; i<this.estoque.size(); i++){
            if(material.getNome().equals(this.estoque.get(i).getNome())){
                System.out.println("aaaaaaa");
                this.estoque.clear();
                return false;
            }
        }
                this.estoque.add(material);
                Arquivo.liparArquivo("data/estoque.json");
                Arquivo.enviarParaEscrita(this.estoque, "data/estoque.json");
                this.estoque.clear();
                return true;
    
    }
    
    public boolean AlterarMaterial(Material material){
        this.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
        for(int i =0; i<this.estoque.size(); i++){
            System.out.println(material.getNome());
            if(material.getNome().equals(this.estoque.get(i).getNome())){
                this.estoque.remove(i);
                this.estoque.add(material);
                Arquivo.liparArquivo("data/estoque.json");
                Arquivo.enviarParaEscrita(this.estoque, "data/estoque.json");
                this.estoque.clear();
                return true;
            }
        }
        this.estoque.clear();
        return false;
    }
    public boolean ExcluirMaterial(String nome){
        this.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
        for(int i =0; i<this.estoque.size(); i++){
            if(nome.equals(this.estoque.get(i).getNome())){
                this.estoque.remove(i);
            Arquivo.liparArquivo("data/estoque.json");
            Arquivo.enviarParaEscrita(this.estoque, "data/estoque.json");
            this.estoque.clear();
                return true;
            }
        }
        this.estoque.clear();
        return false;
    }
    
        //-- Outros Metodos
    public String ImprimirEstoque(){
        String materiais = "";
            this.setEstoque(Arquivo.puxarDadosMaterial("data/estoque.json"));
            for(Material material : this.estoque){
                materiais += material.toString()+"\n";
            }
            this.estoque.clear();
            return materiais;
    }
    // Alterar clienete
    
    
    //-- Realizar Vendas*********************************************************
    public boolean RealizarVendas(Venda venda){
        try{
                this.venda.clear();
                this.setVenda(Arquivo.puxarDadosVenda("data/vendas.json"));
                this.venda.add(venda);
                Arquivo.liparArquivo("data/vendas.json");
                Arquivo.enviarParaEscrita(this.venda, "data/vendas.json");
        }catch(Exception e){
            this.venda.clear();
            return false;
        }
        this.venda.clear();
        return true;
    }
    
    /*Consultar vendas*/
    public String ConsultarVendas(){
        String Svendas = "";
        this.setVenda(Arquivo.puxarDadosVenda("data/vendas.json"));
        for(Venda vendas : this.venda){
            Svendas += vendas.toString();
        }
        this.venda.clear();
        return Svendas;
    }
    
   
    public String converterData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
}

    public Date converterDate(String data) throws ParseException{

       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       dateFormat.setLenient(false);
       return dateFormat.parse(data);
    }
    
   public static String MostrarNumeroClientesColaboradores(){
       return "N° de Clientes Execução Sistema: "+Pessoa.getNumeroClientes()+
              "\nN° de Claboradores Execução Sistema: "+Colaborador.getNumeroColaborador();
   }
    

    /**
     *
     * @param <T>
     * @param array
     * @param elemento
     * @return
     */
    
    public static <T> boolean verificarElemento(T[] array, T elemento){
        for(T element : array){
            if(element == elemento){
                return true;
            }
        }
        return false;
    }
    
    //--retornar o indice do elemento que existe
    public static <T> int indexElentoExite(T[] array, T elemento){
        for(int i=0; i<array.length; i++){
            if(array[i] == elemento){
                return i;
            }
        }
        return -1;
    }
    
    //**********************************Alterar elemento
    


    public List<Venda> getVenda() {
        return venda;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public List<Material> getEstoque() {
        return estoque;
    }

    public Colaborador[] getColaboradors() {
        return colaboradors;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public void setEstoque(List<Material> estoque) {
        this.estoque = estoque;
    }

    public void setColaboradors(Colaborador[] colaboradors) {
        this.colaboradors = colaboradors;
    }
     
    
    //++++++++++++++++++ Login
    
    public boolean loginColaborador( String nome, String senha){
        
        this.setColaboradors(Arquivo.puxarDadosColaborador("data/colaboradores.json"));
        
        for(int i =0; i<colaboradors.length; i++){
          
            if (this.colaboradors[i]!=null){
                if(nome.equals(this.colaboradors[i].getLogin()) &&  senha.equals(this.colaboradors[i].getSenha())){
                    System.out.println("Login concedido!");
                    
                    return true;
                }  
            }
        }
        return false;
    }
        
}
