
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente  extends Pessoa {
    
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
        return
                " Nome " + getNome()+
                " Endereço "+getEndereco()+
                " E-mail " + getEmail()+
                " CPF " + getCpf()+
                " Telefone " + getTelefone()+
                "\n------Compras---- \n"+ vendas+"\n\n";
                
    }

    public Cliente(String nome, String endereco, String email, String cpf, String telefone) {
        super(nome, endereco, email, cpf, telefone);
        numeroClientes++;
    }
    public Cliente(String nome, String endereco, String email, String cpf, String telefone, boolean veri) {
        super(nome, endereco, email, cpf, telefone);
    }

    public Cliente() {
    }
    
}
