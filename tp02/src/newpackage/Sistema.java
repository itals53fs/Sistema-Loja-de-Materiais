/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
    public boolean incluirCliente(Cliente cliente){
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
        int quantidade;
        boolean verificar = true;
        Venda vendas = new Venda();
        do{
            System.out.println("Digite o CPF do cliente: ");
            Svalue = scan.next();
            for(int i = 0; i<this.cliente.size(); i++){
                if(Svalue.equals(cliente.get(i).getCpf())){
                    
                    System.out.println("Digite o nome do marerial: ");
                    Svalue = scan.next();
                   
                    System.out.println("Digite a quantidade ");
                    quantidade = scan.nextInt();
                    
   
                    for(int j = 0; j<this.estoque.size(); j++){
                        
                            if(Svalue.equals(this.estoque.get(j).getNome())){
                                
                                if(quantidade > (this.estoque.get(j).getQuantidade())){
                                    System.out.println("Não há quantidade suficiente no estoque");
                                    verificar = false;
                                }else{
                                    vendas.setIdVenda(this.venda.size()+1);
                                    vendas.setCpfCliente(Svalue);

                                    vendas.setValorTotal(this.estoque.get(j).getPreco());


                                    vendas.setMateriais(this.estoque.get(j));
                                    this.cliente.get(i).setMateriais(vendas);

                                    //this.estoque.get(j).setQuantidade(this.estoque.get(j).getQuantidade()-1);
                                    this.estoque.get(j).setQuantidade(this.estoque.get(j).getQuantidade() - quantidade);
                                    
                                    System.out.println("Venda realizada!");
                                    return vendas;
                                }
                                

                            }
                    }
                }
            }
        }while(verificar);
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
    
    //ConsultarEstoque
    int consultarEstoque(String material){
        
 
        for(int i= 0; i<this.estoque.size(); i++){
            if(material.equals(estoque.get(i).getNome())){
                //System.out.println("Posicao: " + material.toString());

                return i;
            }
            
        }
        return -1;
    }
    
    
    //-- Incluir Materiais
    public Material incluirMaterial(){
      
        //boolean validar;
        
        Material material = new Material();
        String Svalue;
        int IntValue;
        float FloatValue;
        
       System.out.print("Insira o nome do material:  ");
       Svalue = scan.next();

       if(consultarEstoque(Svalue)!=-1){
           
           System.out.println("Já existe esse produto no estoque");
           System.out.println("Insira a quantidade do amreoal que quer cadastrar");
           IntValue = scan.nextInt();
           this.estoque.get(consultarEstoque(Svalue)).maisQuantidade(IntValue);
          
           
       }else{
        
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
       
       }
       
       return material;
    }
    
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
public void readFile() {
    while (scan.hasNextInt()) {
        String linha = scan.next();
        System.out.println(linha);
        }
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
         
    public static void main(String[] args) throws ParseException{
        System.out.println("ola mundo");
        
        //-- Instancias
        Scanner input = new Scanner(System.in);
        Sistema sistema = new Sistema();
        
        String inputLogin, inputSenha;
        boolean validar, login=false;
        int opcao = 0;
        
        // Validar login
        do{
            System.out.println("Insira seu Login e Senha");
            System.out.println("Login: ");
            inputLogin = input.nextLine();
            System.out.println("Senha: ");
            inputSenha = input.nextLine();
            
            //System.out.println(inputLogin + inputSenha);
            if("admin".equals(inputLogin) && "123".equals(inputSenha)){
                login = true;
            }else{
                System.out.println("Algo deu errado, tente novamente");
            }
            
        }while(login == false);
        
        
        // Login
        if(login){
                
            System.out.println("•========Seja bem vindo========•");    
  
        //-- Menu
        do{
           
         System.out.println("----Escolha uma opção----");
         System.out.println("1=Cadastrar Colaborador || 2=Cadastrar Cliente ||\n"
                 + "3= Cadastrar material    || 4=Realizar Venda\n5=consultar extrato clente || 0 = Cancelar");
            System.out.println("");
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
                validar = sistema.incluirCliente(sistema.incluirCliente());               
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
                    String cpf;
                    System.out.println("Digite o cpf do cliente");
                    cpf = input.next();
                    for(Cliente cliente: sistema.cliente){
                        if(cpf.equals(cliente.getCpf())){
                            
                            cliente.ImprimirInfoCliente();
                            
                        }
                    }
                break;
                case 6:
                    System.out.println(sistema.venda.toString());
                break;
         }
            
        }while(opcao > 0);
       
        //Aqui termina o if do Login
        }

       //validar = sistema.incluirVendas(sistema.incluirVendas());  
       //sistema.IncluirCliente(sistema.incluirCliente());
       //sistema.MostrarListaMaterial();/*
       //sistema.open();
       //sistema.readFile();
       
       // System.out.println(sistema.colaboradors.toString());
        

        //System.out.println(sistema.colaboradors.get(0));
        
        //System.out.println(sistema.cliente.get(0).ImprimirInfoCliente());
        //sistema.MostrarListaMaterial();
        //sistema.mostraColaboradores();

        sistema.MostrarListaMaterial();
        //System.out.println(sistema.venda.toString());
     
    }
    
    
}
