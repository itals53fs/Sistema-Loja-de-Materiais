/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author tales
 */
public class Sistema {
    private Colaborador[] colaboradores;
    private Venda[] vendas;
    private Cliente[] clientes;
    private Material[] estoque;

    public Colaborador[] getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Colaborador[] colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Venda[] getVendas() {
        return vendas;
    }

    public void setVendas(Venda[] vendas) {
        this.vendas = vendas;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Material[] getEstoque() {
        return estoque;
    }

    public void setEstoque(Material[] estoque) {
        this.estoque = estoque;
    }
}
