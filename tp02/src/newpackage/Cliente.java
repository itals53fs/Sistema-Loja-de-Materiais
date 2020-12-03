
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
        return false;
        
    };
}
