/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ryan
 */
public class ProdutosDTO {
    private int id_Cardapio, Mesa;
    private float Preco;
    private String NomePizza, Descricao, tamPizza, bebida, adicional;

    public int getId_Cardapio() {
        return id_Cardapio;
    }

    public void setId_Cardapio(int id_Cardapio) {
        this.id_Cardapio = id_Cardapio;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public String getNomePizza() {
        return NomePizza;
    }

    public void setNomePizza(String NomePizza) {
        this.NomePizza = NomePizza;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getTamPizza() {
        return tamPizza;
    }

    public void setTamPizza(String tamPizza) {
        this.tamPizza = tamPizza;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }
}
