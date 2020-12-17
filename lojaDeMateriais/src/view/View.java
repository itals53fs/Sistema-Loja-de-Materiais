/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Routes;
import java.util.Scanner;

/**
 *
 * @author tales
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        //------------------------------------•
        //-- Instancias
        Scanner input = new Scanner(System.in);
        Routes sis = new Routes();
        
        // Variaveis
        String inputLogin, inputSenha;
        String inputString;
        boolean validar=false, login=false;
        int opcao = 0;
        //------------------------------------•
        
        //-- Menu
        do{
           
         System.out.println("----Escolha uma opção----");
         System.out.println("1=Cadastrar Colaborador || 2=Cadastrar Cliente ||\n"
                 + "3= Cadastrar material    || 4=Realizar Venda\n5=consultar extrato clente || 0 = Cancelar");
            System.out.println("");
         opcao = input.nextInt();
         
         switch(opcao){
             case 1:
              /*  validar = sistema.IncluirColaborador(sistema.incluirColaborador());
                if(!validar){
                 System.out.println("Colaborador não inserido");
                }*/
                
           
                break;
             case 2:
                /* validar = sistema.incluirCliente(sistema.incluirCliente());               
                if(!validar){
                    System.out.println("Usuario não inserido");
                } */
             
                break;
             case 3:
                 
                 String inputNome, espec, fornecedor;
                 int quant, lucro, preco;
                 
                 System.out.println("Digite o nome do Material");
                 inputNome = input.next();
                
                 System.out.println("Digite a quantidade");
                 quant = input.nextInt();
                 
                 System.out.println("Digite a margem de Lucro");
                 lucro = input.nextInt();
                
                 System.out.println("Digite a especificao");
                 espec = input.next();
                 
                 System.out.println("Digite o Preço");
                 preco = input.nextInt();
                 
                 System.out.println("Digite o nome do Fornecedor");
                 fornecedor = input.next();
                 
                 validar = sis.salvarMaetrial(inputNome, quant, lucro, espec, preco, fornecedor);
                 
               /* validar = sistema.incluirMaterial(sistema.incluirMaterial());
                if(!validar){
                 System.out.println("Materão não inserido");
                } */

                break;
             case 4:
                /* validar = sistema.incluirVendas(sistema.incluirVendas());               
                if(!validar){
                    System.out.println("Venda não Realizada");
                } */
                break; 
             case 5:
                    String cpf;
                    System.out.println("Digite o cpf do cliente");
                    cpf = input.next();
                   /* for(Cliente cliente: sistema.cliente){
                        if(cpf.equals(cliente.getCpf())){
                            
                            cliente.ImprimirInfoCliente();
                            
                        }
                    } */
                break;
                case 6:
                   /* System.out.println(sistema.venda.toString()); */
                break;
         }
            
        }while(opcao > 0);
       
        
    }
    
}

