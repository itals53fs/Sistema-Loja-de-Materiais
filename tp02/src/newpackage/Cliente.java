
package newpackage;

public class Cliente  extends Pessoa{
    
    private Venda[] regCompras;

    public Venda[] getRegCompras() {
        return regCompras;
    }

    public void setRegCompras(Venda[] regCompras) {
        this.regCompras = regCompras;
    }
 
    public boolean ImprimirInfoCliente(){
        
        System.out.println("•-----Info do Cliente-----•");
        System.out.println("Nome " + getNome());
        System.out.println("Endereço " + getEndereco());
        System.out.println("E-mail " + getEmail());
        System.out.println("CPF " + getCpf());
        System.out.println("Telefone " + getTelefone());
        System.out.println("•-----Info do Cliente-----•");

        return false;
        
    };
}
