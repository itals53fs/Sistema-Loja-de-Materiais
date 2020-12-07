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
    public void MostrarListaMaterial(){
           for(int i =0;i<this.estoque.size(); i++){
              this.estoque.get(i).printTodos();
           }
       }
    
    public void open() {
       
        try {
            in = new Scanner(new File("materiais.txt"));

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("erro");
        }
    }

    // ler o arquivo
    public void readFile() {
        String linha = in.next();
        System.out.println("aqui");
    }
         
    public static void main(String[] args){
        System.out.println("ola mundo");
        
        Scanner input = new Scanner(System.in);
        Sistema sistema = new Sistema();
        boolean validar;
        int opcao = 0;
        

        
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
                //validar = false;
                break;
        
         }
            
        }while(opcao > 0);
       

       //validar = sistema.incluirVendas(sistema.incluirVendas());  
       //sistema.IncluirCliente(sistema.incluirCliente());
       //sistema.MostrarListaMaterial();/*
       //sistema.open();
       //sistema.readFile();*/
       
       // System.out.println(sistema.colaboradors.toString());
        
        System.out.println(sistema.colaboradors);
        System.out.println(sistema.colaboradors.size());
       
    }
    
    
}
