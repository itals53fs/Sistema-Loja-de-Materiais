/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabil
 */
public class Venda {
   private int idVenda;
   private float valorTotal;
   private int quantidade;
   private List <Material> materiais = new ArrayList<Material>();
   private Date data = new Date();
   private String cpfCliente;
   private static int numeroVendas;
   

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }


    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(Material materiais) {
        this.materiais.add(materiais);
    }
    
    public boolean cancelarVenda(){
        return false;
    }

   
   public String GerarExtrato() {
       System.out.println("-----Venda-Realizada-----\n");
        String materialString="";
        for(Material material : materiais){
            materialString += 
            "\nNome: \t" + material.getNome() 
            + "\nPreço: \t" + material.getPreco() 
            + "\nFornecedor: \t" + material.getFornecedor()
            + "\nValor Total: \t" + valorTotal;
        }
       return materialString;
   }
    public String getCreate_at() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(data);
    }

    @Override
    public String toString() {
       String materialString="";
        for(Material material : materiais){
            materialString += "\nNome: \t\t" + material.getNome() 
                               + "\nQuantidade em Estoque:\t\t" + (material.getQuantidade()-1)
                               + "\nPreço: \t\t" + material.getPreco()
                               + "\nEspecificação: \t\t" + material.getEspecificacao()
                               + "\nMargem de Lucro: \t\t" + material.getMargemLucro()
                               + "\nData de Fabricao: \t\t" + material.getDataFabricacao()
                               + "\nFornecedor: " + material.getFornecedor() + "\n";
        }
        
        return "\n•-----Extrato de Venda-----•\n"
                + "\nId da Venda: \t\t" + getIdVenda()
                + "\nValor total: \t\t" + getValorTotal()
                + "\nCPF Cliente: \t\t" + getCpfCliente()
                + "\nData da Venda: \t\t" + getData()
                + "\nMateriais: " +  materialString+"\n\n"
                ;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Venda(int quantidade, String cpfCliente) {
        this.quantidade = quantidade;
        this.cpfCliente = cpfCliente;
        numeroVendas++;
    }




    public Venda() {
    }
    
   
 
}
