
package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente  extends Pessoa{
    
    //Atributos
    private List <Venda> regCompras = new ArrayList <Venda>();
    
   

    public void setMateriais(Venda materiais) {
        this.regCompras.add(materiais);
    }

    public void ImprimirInfoCliente(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String vendas="";
        for(Venda venda : this.regCompras){
            vendas += venda.GerarExtrato()+"\n";
            
        }
        return "•-----Info do Cliente-----•"+
                "\nNome " + getNome()+
                "\nEndereço "+getEndereco()+
                "\nE-mail " + getEmail()+
                "\nCPF " + getCpf()+
                "\nTelefone " + getTelefone()+
                "\n------Vendas---- \n" + vendas + "------Vendas---- \n"+
                
                "\n•-----Info do Cliente-----•";
                
    }
}
