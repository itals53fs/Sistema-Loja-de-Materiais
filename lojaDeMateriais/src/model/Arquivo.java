package model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tales
 */
public class Arquivo {
    private static FileWriter escrita = null;
    private static JSONParser parser;
    private static Scanner scan = new Scanner(System.in);
    private static final Gson gson = new Gson();
    public static String readFile(String arquivo){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader ler = new BufferedReader(arq);
            String linha = "";
            try {
                linha = ler.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = ler.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conteudo;
    }

     public  static void escrever(String json, String arq) throws IOException{
 
            try {
                escrita = new FileWriter(arq, true);
                escrita.write(json);
                
                 escrita.close();
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     public static void liparArquivo(String arq){
            try {
           escrita = new FileWriter(arq);
           escrita.write("");

            escrita.close();
       } catch (IOException ex) {
           Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
     public static <T> void enviarParaEscrita(List<T> lista, String arq){
       String json = gson.toJson(lista);
        try {
            Arquivo.escrever(json, arq);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        public static <T> void enviarParaEscrita(T[] lista, String arq){
        String json = gson.toJson(lista);
        try {
            Arquivo.escrever(json, arq);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public static <T> void enviarParaEscrita(T num, String arq){
        String json = gson.toJson(num);
        try {
            Arquivo.escrever(json, arq);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Colaborador[] puxarDadosColaborador(String arq){
      String linha = null;
      Colaborador[] colaborador = new Colaborador[50];
        //java.lang.reflect.Type t = new TypeToken<ArrayList<T>>() {}.getType();
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            colaborador = gson.fromJson(linha, Colaborador[].class);
            scan.close();
       return colaborador;
    }
  
  public static List<Venda> puxarDadosVenda(String arq) {
      String linha = null;
      List<Venda> obj = new ArrayList<Venda>();
   
        java.lang.reflect.Type t = new TypeToken<ArrayList<Venda>>() {}.getType();
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            obj = gson.fromJson(linha, t);
            scan.close();
       return obj;
    }
  
  public static List<Cliente> puxarDadosCliente(String arq) {
      String linha = null;
      List<Cliente> cliente = new ArrayList<Cliente>();
      java.lang.reflect.Type t = new TypeToken<ArrayList<Cliente>>() {}.getType();
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            cliente = gson.fromJson(linha, t);

            
            scan.close();
       return cliente;
    }
    public static int[] puxarDadosPessoas(String arq) {
      String linha = null;
      int[] array = new int[2];
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            array = gson.fromJson(linha, int[].class);

            scan.close();
       return array;
    }
      public static List<Material> puxarDadosMaterial(String arq) {
      String linha = null;
      List<Material> cliente = new ArrayList<Material>();
      java.lang.reflect.Type t = new TypeToken<ArrayList<Material>>() {}.getType();
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }

            cliente = gson.fromJson(linha, t);

            
            scan.close();
       return cliente;
    }
}
