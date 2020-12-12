/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author gabil
 */
public class Venda {
   private int idVenda;
   private int data;
   private float valorTotal;
   private Material[] materiais;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", data=" + data + ", valorTotal=" + valorTotal + ", materiais=" + materiais + '}';
    } 
    
   
 
}
