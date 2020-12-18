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
    private List<Colaborador> colaboradors = new ArrayList<Colaborador>();
    private List<Venda> venda = new ArrayList<Venda>();
    private List<Cliente> cliente = new ArrayList<Cliente>();
    private List<Material> estoque = new ArrayList<Material>();
   private Scanner scan = new Scanner(System.in);
    Scanner in;
    
    //-- Incluir Colaborador
    public boolean IncluirColaborador(Colaborador colaborador){
         try{
                this.colaboradors.add(colaborador);
                
                Routes.enviarParaEscrita(this.colaboradors, "data/colaboradores.json");
                this.setColaboradors(Routes.puxarDados(cliente, "data/colaboradores.json"));
                System.out.println("aa"+this.getColaboradors().toString());
                
            }catch(Exception e){
                return false;
            }
        return true;
    }
    
    //-- Incluir Cliente
    public boolean incluirCliente(Cliente cliente){
        try{
            this.cliente.add(cliente);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    //-- Realizar Vendas
    public boolean RealizarVendas(Venda venda){
        try{
            this.venda.add(venda);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    /*Consultar vendas*/
    public String ConsultarVendas(){
        String Svendas = null;
        for(Venda vendas : this.venda){
            Svendas = vendas.GerarExtrato();
        }
        return Svendas;
    }
    
    //ConsultarEstoque
    int consultarEstoque(String material){
        for(int i= 0; i<this.estoque.size(); i++){
            if(material.equals(estoque.get(i).getNome())){
                return i;
            }    
        }
        return -1;
    }
    
    
    //-- Incluir Materiais
    public boolean incluirMaterial(Material material){
       if(material.getNome()!=null){
            try{
                this.estoque.add(material);
            }catch(Exception e){
                return false;
            }
            return true;
        }
       return false;
    }
    
    //-- Outros Metodos
    public void MostrarListaMaterial(){
        for(int i =0;i<this.estoque.size(); i++){
            try {
                this.estoque.get(i).printTodos();
            } catch (ParseException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //--Mostrar lista de Colaboradores
    public void mostraColaboradores(){
        for (Colaborador colaborador : colaboradors) {
            System.out.println("Colaborador: " + colaborador.getNome());
        }
    }
    //---Mostrar lista de clientes
        public String MostrarClientes(){
            String Sclientes= null;
        for (Cliente clientes : cliente) {
            Sclientes += clientes.toString();
        }
        return Sclientes;
    }
    //--Converter datas
    public String converterData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
}

    public Date converterDate(String data) throws ParseException{

       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       dateFormat.setLenient(false);
       return dateFormat.parse(data);
    }
    
    //--verificar se existe elemento

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
    public void incluirColaboradorLista(Colaborador e){
        this.colaboradors.add(e);
    }

    public List<Colaborador> getColaboradors() {
        return colaboradors;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public List<Material> getEstoque() {
        return estoque;
    }

    public void setColaboradors(List<Colaborador> colaboradors) {
        this.colaboradors = colaboradors;
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
        
        
}
