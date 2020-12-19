/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Routes;
import java.util.Scanner;
import model.Colaborador;

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
                 + "7=Mostrar Colaborador || 8= Mostrar Cliente || 9=Excuir Colaborador\n"+
                 "10 Alterar Colaborador || 0 = Cancelar");
            System.out.println("");
         opcao = input.nextInt();
         
         switch(opcao){
             case 1:
                 // Cadastrar Colaborador
                 /*System.out.println("Digite o seu Login");
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
                 inputTelefone = input.next();*/
                              
                 sis.IncluirColaborador("inputLogin", "inputSenha", "inputNome", "end", "inputEmail", "17", "inputTelefone");
                 //System.out.println(sis.MostrarColaboradores("123"));
           
                break;
             case 2:
                 // Cadastrar Cliente
                 /*System.out.println("Digite o Nome do Cliente");
                 inputNome = input.next();
                
                 System.out.println("Digite o CPF do Cliente");
                 inputCpf = input.next();
                
                 System.out.println("Digite o Email do Cliente");
                 inputEmail = input.next();
                
                 System.out.println("Digite o Endereço do Cliente");
                 end = input.next();*/
                 
                 
                 sis.IncluirCliente("inputNome", "end", "12", "33","aaa");
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
                 //sis.IncluirCliente("tales", "end", "aa", "143", "ss");
                 sis.salvarMaetrial("tijolo", 12, 10, "ss", 5, "ss");
                 sis.RealizarVenda((float) 2.5, 2, "33", "g");
                 
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
                    //sis.mostrarColaboradores();
                break;
                case 8:
                    System.out.println("");
                    sis.MostrarClientes();
                break;
                    case 9:
                    System.out.println("");
                    sis.ExcluirColaborador("127");
                break;
                    case 10:
                sis.AlterarColaborador("inputLogin", "inputSenha", "inputNome", "end", "inputEmail", "127", "inputTelefone", true);
                break;
                    case 11:
                        sis.AlterarMaterial("nome", 10, 6, "especificacao", 10, "fornecedor", false);
                        sis.ExcluirMaterial("f");
                        //sis.ExcluirMaterial("nome");

         }
            
        }while(opcao > 0);
        System.out.println("Ulisses gay");
        System.out.println(sis.ConsultarVendas());
        //System.out.println(sis.MostrarClientes());
        sis.MostrarListaMaterial();

        
    }
    
}

