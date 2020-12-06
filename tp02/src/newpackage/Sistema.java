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
    private final List<Cliente> vendas = new ArrayList<Cliente>();
    private final List<Cliente> cliente = new ArrayList<Cliente>();
    private final List<Material> lista = new ArrayList<Material>();
   private Scanner scan = new Scanner(System.in);
    Scanner in;
  

    /*public void setEstoque(Material[] estoque){
        this.estoque = estoque;
    }*/
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
         public boolean incluirMaterial(Material material){
            try{
                lista.add(material);
            }catch(Exception e){
                return false;
            }
            return true;
        }
         public void print(){
                for(int i =0;i<this.lista.size(); i++){
                   this.lista.get(i).printTodos();
                }
            }
    public static void main(String[] args){
        System.out.println("ola mundo");
        
       Sistema sistema = new Sistema();
       sistema.incluirMaterial(sistema.incluirMaterial());
       sistema.incluirMaterial(sistema.incluirMaterial());
       
        sistema.print();
    }
}
