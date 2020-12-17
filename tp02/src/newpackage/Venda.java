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
            "\nNome: " + material.getNome() 
            + "\nPreço: " + material.getPreco() 
            + "\nFornecedor: " + material.getFornecedor() + "\n";
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
            materialString += "\nNome: " + material.getNome() 
                               + "\nQuantidade " + material.getQuantidade()
                               + "\nPreço: " + material.getPreco()
                               + "\nEspecificação: " + material.getEspecificacao()
                               + "\nMargem de Lucro: " + material.getMargemLucro()
                               + "\nDataFabricao: ---" 
                               + "\nFornecedor: " + material.getFornecedor() + "\n";
        }
        
        return "\n•-----Extrato de Venda-----•\n"
                + "\nId da Venda: " + getIdVenda()
                + "\nValor total: " + getValorTotal()
                + "\nData da Venda: ---"
                + "\nMateriais: " +  materialString+"\n\n"
                ;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
   
 
}
