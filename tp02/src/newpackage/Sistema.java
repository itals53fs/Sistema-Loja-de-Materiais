/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //-- Incluir Colaborador
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
    
    //-- Incluir Cliente
    public Cliente incluirCliente(){
        Cliente cli = new Cliente();
        String value;
         System.out.print("Insira o seu nome:  ");
         value = scan.next();
         cli.setNome(value);
         System.out.print("Insira sua CPF:  ");
         value = scan.next();
         cli.setCpf(value);
         System.out.print("Insira  seu email:  ");
         value = scan.next();
         cli.setEmail(value);
         System.out.print("Insira seu Telefone:  ");
         value = scan.next();
         cli.setTelefone(value);
          System.out.print("Insira seu Endereço:  ");
          value = scan.next();
          cli.setEndereco(value);
        return cli;
    }
    public boolean incluirCliete(Cliente cliente){
    try{
        this.cliente.add(cliente);
    }catch(Exception e){
        return false;
    }
    return true;
}
    
    //-- Realizar Vendas
    public Venda incluirVendas(){
     
        
        String Svalue;
        int Intvalue;
        float FloatValue;
        
        Date data = new Date();
        Venda vendas = new Venda();
       
        //String Svalue;
       //int Intvalue;
       //float FloatValue;

       
        //System.out.println("Digite o id da venda: ");
        //Intvalue = scan.nextInt(); 
        vendas.setIdVenda(this.venda.size()+1);
        
        System.out.println("Digite o CPF do cliente: ");
        Svalue = scan.next();
        
  
          for (Cliente clientes : cliente){
            
              if(Svalue.equals(clientes.getCpf())){
                vendas.setCpfCliente(Svalue);
                System.out.println("Digite o valor total: ");
                FloatValue = scan.nextInt();
                clientes.setMateriais(venda);
              }else{
                  System.out.println("Cliente não existe, registre o mesmo");
              }
          } 

        System.out.println("Digite o valor total: ");
        FloatValue = scan.nextInt();
        vendas.setValorTotal(FloatValue);
        vendas.setData(data);

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
    
    //-- Incluir Materiais
    public Material incluirMaterial(){
        Date data = new Date();
        
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
       material.setQuantidade(IntValue);

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
    
    //-- Outros Metodos
    public void MostrarListaMaterial() throws ParseException{
           for(int i =0;i<this.estoque.size(); i++){
              this.estoque.get(i).printTodos();
           }
       }
    
    //--Mostrar lista de Colaboradores
    public void mostraColaboradores(){
        for (Colaborador colaborador : colaboradors) {
            System.out.println("Colaborador: " + colaborador.getNome());
        }
    }
    
    public void open() {
       
  try {
            scan = new Scanner(new File("../data/mat.txt"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ler o arquivo
public void readFile() {;
    while (scan.hasNextInt()) {
        String linha = scan.next();
        System.out.println(linha);
        }
}
         
    public static void main(String[] args) throws ParseException{
        System.out.println("ola mundo");
        
        //-- Instancias
        Scanner input = new Scanner(System.in);
        Sistema sistema = new Sistema();
        
        boolean validar;
        int opcao = 0;
        
        
        //-- Menu
        do{
           
         System.out.println("Escolha uma opção");
         System.out.println("1=Cadastrar Colaborador || 2=Cadastrar Cliente || || \n"
                 + " 3= Cadastrar material || 4=Realizar Vend 0 = Cancelar");
         opcao = input.nextInt();
         
         switch(opcao){
             case 1:
                validar = sistema.IncluirColaborador(sistema.incluirColaborador());
                if(!validar){
                 System.out.println("Colaborador não inserido");
                }
                
              //  validar = false;
                break;
             case 2:
                validar = sistema.IncluirCliente(sistema.incluirCliente());               
                if(!validar){
                    System.out.println("Usuario não inserido");
                }
               // validar = false;
                break;
             case 3:
                validar = sistema.incluirMaterial(sistema.incluirMaterial());
                if(!validar){
                 System.out.println("Materão não inserido");
                }
               // validar = false;
                break;
             case 4:
                validar = sistema.incluirVendas(sistema.incluirVendas());               
                if(!validar){
                    System.out.println("Venda não Realizada");
                }
                break;
             case 5:
                sistema.cliente.get(0).ImprimirInfoCliente();
                break;
        
         }
            
        }while(opcao > 0);
       

       //validar = sistema.incluirVendas(sistema.incluirVendas());  
       //sistema.IncluirCliente(sistema.incluirCliente());
       //sistema.MostrarListaMaterial();/*
       //sistema.open();
       //sistema.readFile();
       
       // System.out.println(sistema.colaboradors.toString());
        

        //System.out.println(sistema.colaboradors.get(0));
        System.out.println(sistema.cliente.get(0));
        //System.out.println(sistema.cliente.get(0).ImprimirInfoCliente());
        //sistema.MostrarListaMaterial();
        //sistema.mostraColaboradores();

        sistema.MostrarListaMaterial();
        System.out.println(sistema.venda.toString());
     
    }
    
    
}
