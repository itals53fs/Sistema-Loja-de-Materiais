/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author gabil
 */
public class Venda {
   private int idVenda;
   private float valorTotal;
   private Material[] materiais;
<<<<<<< HEAD
   private String cpfCliente;
   

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
=======
   private Date data = new Date();
>>>>>>> a45e600e1c992536e4bce4c843ccc241394d9503

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
        return "Venda{" + "idVenda=" + idVenda + ", valorTotal=" + valorTotal + ", materiais=" + materiais +" Data: "+ this.getCreate_at()+'}';
    } 

    public void setData(Date data) {
        this.data = data;
    }
    
   
 
}
