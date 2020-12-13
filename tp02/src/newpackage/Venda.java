/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
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
   private List <Material> materiais = new ArrayList<Material>();
   private Date data = new Date();
   private String cpfCliente;
   

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

    public void setMateriais(List<Material> materiais) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
   
 
}
