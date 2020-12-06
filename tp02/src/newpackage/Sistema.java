/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tales
 */
public class Sistema {
    private final List<Colaborador> colaboradors = new ArrayList<Colaborador>();
    private final List<Venda> venda = new ArrayList<Venda>();
    private final List<Cliente> cliente = new ArrayList<Cliente>();
    private final List<Material> estoque = new ArrayList<Material>();
   private Scanner scan = new Scanner(System.in);
    Scanner in;
    
       public Colaborador  incluirColaborador(){
         Colaborador colaborador = new Colaborador();
         String value;
         System.out.print("Insira o seu nome:  ");
         value = scan.next();
         colaborador.setNome(value);
         System.out.print("Insira sua CPF:  ");
         value = scan.next();
         colaborador.setCpf(value);
         System.out.print("Insira  seu email:  ");
         value = scan.next();
         colaborador.setEmail(value);
         System.out.print("Insira seu Telefone:  ");
         value = scan.next();
         colaborador.setTelefone(value);
          System.out.print("Insira seu Endereço:  ");
          value = scan.next();
         colaborador.setEndereco(value);
         System.out.print("Insira seu Login:  ");
         value = scan.next();
         colaborador.setLogin(value);
         System.out.print("Insira sua senha:  ");
         value = scan.next();
         colaborador.setSenha(value);
         return colaborador;
    }
    public boolean IncluirColaborador(Colaborador colaborador){
         try{
                this.colaboradors.add(colaborador);
            }catch(Exception e){
                return false;
            }
            return true;
    }
    
    
    public Venda incluirVendas(){
      Venda vendas = new Venda();
       String Svalue;
       int Intvalue;
       float FloatValue;
       
        System.out.println("Digite o id da venda: ");
        Intvalue = scan.nextInt();
        vendas.setIdVenda(Intvalue);
        
        System.out.println("Digite o valor total: ");
        FloatValue = scan.nextInt();
        vendas.setValorTotal(FloatValue);
        return vendas;
  
  }
    
             public boolean incluirVendas(Venda venda){
            try{
                this.venda.add(venda);
            }catch(Exception e){
                return false;
            }
            return true;
        }
    
    
    public Material incluirMaterial(){
        Material material = new Material();
        String Svalue;
        int IntValue;
        float FloatValue;
       System.out.print("Insira o nome do material:  ");
       Svalue = scan.next();
       material.setNome(Svalue);

       System.out.print("Insira a especificação:  ");
       Svalue = scan.next();
       material.setEspecificacao(Svalue);

       System.out.print("Insira o fornecedor:  ");
       Svalue = scan.next();
       material.setFornecedor(Svalue);

       System.out.print("Insira a quantidade:  ");
       IntValue= scan.nextInt();
       material.setPreco(IntValue);

       System.out.print("Insira o preco do material:  ");
       FloatValue= scan.nextFloat();
       material.setPreco(FloatValue);

       System.out.print("Insira a Margem Lucro:  ");
       FloatValue= scan.nextFloat();
       material.setMargemLucro(FloatValue);
       return material;
    }
    
    public boolean IncluirCliente(Cliente cliente){
         try{
                this.cliente.add(cliente);
            }catch(Exception e){
                return false;
            }
            return true;
    }
    public boolean incluirMaterial(Material material){
       try{
           this.estoque.add(material);
       }catch(Exception e){
           return false;
       }
       return true;
    }
    public void MostrarListaMaterial(){
           for(int i =0;i<this.estoque.size(); i++){
              this.estoque.get(i).printTodos();
           }
       }
         
    public static void main(String[] args){
        System.out.println("ola mundo");
        
       Sistema sistema = new Sistema();
       /*sistema.incluirMaterial(sistema.incluirMaterial());
       sistema.incluirMaterial(sistema.incluirMaterial());*/
       sistema.IncluirColaborador(sistema.incluirColaborador());
        sistema.MostrarListaMaterial();
       sistema.incluirVendas(sistema.incluirVendas());
    }
}
