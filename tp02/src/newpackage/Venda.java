/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
/**
 *
 * @author gabil
 */
public class Venda {
   private int idVenda;
   private float valorTotal;
   private Material[] materiais;

   private String cpfCliente;
   

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

   private Date data = new Date();


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

    public Material[] getMateriais() {
        return materiais;
    }

    public void setMateriais(Material[] materiais) {
        this.materiais = materiais;
    }
   
   public boolean GerarExtrato() {
       System.out.println("-----Venda-Realizada-----");
       System.out.println("Data: -----");
       System.out.println("Produto " + materiais.toString());
       System.out.println("Valor total " + valorTotal);
       return false;
   }
       public String getCreate_at() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(data);
    }

    @Override
    public String toString() {
       String materialString="";
        for(Material material : materiais){
            materialString += "Nome: " + material.getNome() 
                               + "Quantidade " + material.getQuantidade()
                               + "Preço: " + material.getPreco()
                               + "Especificação: " + material.getEspecificacao()
                               + "Margem de Lucro: " + material.getMargemLucro()
                               + "DataFabricao: ---" 
                               + "Fornecedor: " + material.getFornecedor() + "\n";
        }
        
        return "•-----Extrato de Venda-----•"
                + "\nId da Venda: " + getIdVenda()
                + "\nValor total: " + getValorTotal()
                + "\nData da Venda: ---"
                + "\nMateriais: " + getMateriais()
                ;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
   
 
}
