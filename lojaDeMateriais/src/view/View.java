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
        
        String inputNome, inputLogin, inputSenha, end, inputEmail, inputCpf, inputTelefone, espec, fornecedor;
        int quant, lucro, preco;
        
        String inputString;
        boolean validar=false, login=false;
        int opcao = 0;
        //------------------------------------•
        
        //-- Menu
        do{
           
         System.out.println("----Escolha uma opção----");
         System.out.println("1=Cadastrar Colaborador || 2=Cadastrar Cliente ||\n"
                 + "3= Cadastrar material    || 4=Realizar Venda\n"
                 + "5=consultar extrato clente || " + "6= Mostrar Material ||\n"
                 + "7=Mostrar Colaborador || 8= Mostrar Cliente  0 = Cancelar");
            System.out.println("");
         opcao = input.nextInt();
         
         switch(opcao){
             case 1:
                 // Cadastrar Colaborador
                 System.out.println("Digite o seu Login");
                 inputLogin = input.next();
                
                 System.out.println("Digite a sua Senha");
                 inputSenha = input.next();
                 
                 System.out.println("Digite o Nome");
                 inputNome = input.next();
                
                 System.out.println("Digite o Endereço");
                 end = input.next();
                 
                 System.out.println("Digite o seu email");
                 inputEmail = input.next();
                 
                 System.out.println("Digite o CPF");
                 inputCpf = input.next();
                 
                 System.out.println("Digite o seu Telefone");
                 inputTelefone = input.next();
                              
                 sis.IncluirColaborador(inputLogin, inputSenha, inputNome, end, inputEmail, inputCpf, inputTelefone);
           
                break;
             case 2:
                 // Cadastrar Cliente
                 System.out.println("Digite o Nome do Cliente");
                 inputNome = input.next();
                
                 System.out.println("Digite o CPF do Cliente");
                 inputCpf = input.next();
                
                 System.out.println("Digite o Email do Cliente");
                 inputEmail = input.next();
                
                 System.out.println("Digite o Endereço do Cliente");
                 end = input.next();
                 
                 
                 sis.IncluirCliente(inputNome, end, inputEmail, inputCpf, "16/16/16");
                break;
             case 3:
                 // Cadastrar Material

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
                 
                 sis.salvarMaetrial(inputNome, quant, lucro, espec, preco, fornecedor);
                 

                break;
             case 4:
                 
                 System.out.println("Realizar Venda");
                 sis.IncluirCliente("tales", "end", "aa", "123", "ss");
                 sis.salvarMaetrial("tijolo", 12, 4, "ss", 5, "ss");
                 sis.RealizarVenda((float) 2.5, 2, "123", "tijolo");
                 
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
                    System.out.println("");
                    sis.MostrarListaMaterial();
                break;
                case 7:
                    System.out.println("");
                    sis.mostrarColaboradores();
                break;
                case 8:
                    System.out.println("");
                    sis.MostrarClientes();
                break;
         }
            
        }while(opcao > 0);

        System.out.println(sis.ConsultarVendas());
        System.out.println(sis.MostrarClientes());
        sis.MostrarListaMaterial();

        
    }
    
}

