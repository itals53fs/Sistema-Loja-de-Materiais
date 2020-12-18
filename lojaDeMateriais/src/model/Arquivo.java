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
    
    /**
     *
     * @param <T>
     * @param lista
     * @param arquivo
     */
    /*public <T> Object puxarDados(List<T> lista, String arq) {
      String linha = null;
      List<T> obj = new ArrayList<T>();
      Type tipoLista = new TypeToken<ArrayList<Object>>() {private Type getType;
      }.getType;
      
      JsonObject json = new JsonObject();
      
            try {
                scan = new Scanner(new File(arq));
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
            while (scan.hasNextLine()) {
                linha = scan.nextLine();  
            }
            for(T elemento :lista){
                obj.add(elemento);
            }
      Gson gson = new Gson();
       scan.close();
            gson.fromJson(json, tipoLista);
       
    }*/
  public static <T> List<Colaborador> puxarDados(List<T> colecao, String arq) {
      String linha = null;
      List<Colaborador> obj = new ArrayList<Colaborador>();
      Colaborador col = new Colaborador();
        java.lang.reflect.Type t = new TypeToken<ArrayList<T>>() {}.getType();
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
  public static <T> List<Venda> puxarDadosVenda(List<T> colecao, String arq) {
      String linha = null;
      List<Venda> obj = new ArrayList<Venda>();
      Colaborador col = new Colaborador();
        java.lang.reflect.Type t = new TypeToken<ArrayList<T>>() {}.getType();
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
    
}
