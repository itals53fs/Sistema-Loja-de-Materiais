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
                 // Incluir Colaborador Login / Senha / Nome / Ende / email / CPF / telefone
                 sis.IncluirColaborador("tales", "123", "tales", "serro", "tales", "22", "99748");

           
                break;
             case 2:

                 // Incluir Cliente
                 sis.IncluirCliente("RafaMoreira", "end", "12", "777","aaa");
                break;
             case 3:
                 
                 //sis.salvarMaetrial("cimento", 20, 25, "5Kg", 20, "zeze");
                 
                break;
             case 4:
                 sis.RealizarVenda(15, "777", "cimento");

                 sis.IncluirCliente("gabriel", "end", "12", "222","aaa");
                break;
 
             case 5:
                 System.out.println(sis.ImprimirListaClientes());
                case 6:
                    System.out.println("");
                    System.out.println(sis.ImprimirEstoque());
                break;
                case 7:
                    System.out.println(sis.ImprimirListaColaboradores());
                    //sis.mostrarColaboradores();
                break;
                case 8:
                    System.out.println("");
                    sis.ImprimirListaClientes();
                break;
                    case 9:
                    System.out.println("");
                    sis.ExcluirColaborador("123");
                break;
                    case 10:
                //sis.AlterarColaborador("inputLogin", "inputSenha", "inputNome", "end", "inputEmail", "123", "inputTelefone", true);
                break;
                    case 11:
                        //sis.AlterarMaterial("tijolo", 10, 6, "especificacao", 10, "fornecedor", false);
                break;
                    case 12:
                        sis.ExcluirMaterial("tijolo");
                        break;
 
         }
            
        }while(opcao > 0);
       // System.out.println("Ulisses gay");
        //System.out.println(sis.ConsultarVendas());
        //System.out.println(sis.MostrarClientes());
        
        sis.Comparar();
        System.out.println(sis.ImprimirEstoque());
        
        
    }
    
}

