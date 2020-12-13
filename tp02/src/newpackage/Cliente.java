
package newpackage;

import java.util.ArrayList;
import java.util.List;

public class Cliente  extends Pessoa{
    
    //Atributos
    private List <Venda> materiais = new ArrayList <Venda>();
    
    
    // Get and set
    public List<Venda> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Venda> materiais) {
        this.materiais = materiais;
    }

    public void ImprimirInfoCliente(){
        
        System.out.println("•-----Info do Cliente-----•");
        System.out.println("Nome " + getNome());
        System.out.println("Endereço " + getEndereco());
        System.out.println("E-mail " + getEmail());
        System.out.println("CPF " + getCpf());
        System.out.println("Telefone " + getTelefone());
        for(Venda venda : materiais){
            System.out.println("ID Venda: " +venda.getIdVenda()+ " Valor: "+ venda.getValorTotal());
        }
        System.out.println("•-----Info do Cliente-----•");
        
    };
}
