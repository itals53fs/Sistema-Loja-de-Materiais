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
