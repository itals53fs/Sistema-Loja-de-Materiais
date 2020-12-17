/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Routes;

/**
 *
 * @author tales
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Routes sis = new Routes();
        boolean ok = sis.salvarMaetrial("tales", 0, 0, "especificacao", 0, "fornecedor");
        
        if(ok){
            sis.mostrar();
        }
    }
    
}

