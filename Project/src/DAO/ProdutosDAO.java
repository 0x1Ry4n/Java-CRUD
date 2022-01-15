/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PedidosDTO;
import DTO.ProdutosDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Ryan
 */
public class ProdutosDAO {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void CadastrarProdutos(ProdutosDTO objProduto) {
        String sql = "INSERT INTO tb_produto(nomePizza, descricao, tam_Pizza, bebida, preco, adicional) VALUES(?, ?, ?, ?, ?, ?)";
           
        connection = new ConexaoDB().conectaBD();
        
        try {    
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            
            pstm.setString(1, objProduto.getNomePizza());
            pstm.setString(2, objProduto.getDescricao());
            pstm.setString(3, objProduto.getTamPizza());
            pstm.setString(4, objProduto.getBebida());
            pstm.setFloat(5, objProduto.getPreco());
            pstm.setString(6, objProduto.getAdicional());
        
            pstm.execute();
            pstm.close();
        } catch(SQLException err) {
            System.out.print(err.getMessage());
        }   
    }
    
    
    public ArrayList<ProdutosDTO> PesquisarProduto() {
        
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_produto";
        
        connection = new ConexaoDB().conectaBD();

        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ProdutosDTO objProdutosDTO = new ProdutosDTO();
                objProdutosDTO.setId_Cardapio(rs.getInt("id_Cardapio"));
                objProdutosDTO.setNomePizza(rs.getString("nomePizza"));
                objProdutosDTO.setDescricao(rs.getString("descricao"));
                objProdutosDTO.setTamPizza(rs.getString("tam_Pizza"));
                objProdutosDTO.setBebida(rs.getString("bebida"));
                objProdutosDTO.setPreco(rs.getFloat("preco"));
                objProdutosDTO.setAdicional(rs.getString("adicional"));
                lista.add(objProdutosDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ProdutosDAO Pesquisar: " + error);
        }
        return lista;
    }
    
     public void alterarProduto(ProdutosDTO objProdutoDTO) {
        String sql = "UPDATE tb_produto SET nomePizza = ?, descricao = ?, tam_Pizza = ?, bebida = ?, preco = ?, adicional = ? WHERE id_Cardapio = ?";
        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setString(1, objProdutoDTO.getNomePizza()); //seta o Nome da pessoa no primeiro parâmetro da query
            pstm.setString(2, objProdutoDTO.getDescricao());
            pstm.setString(3, objProdutoDTO.getTamPizza());//seta o Endereço da pessoa no segundo parâmetro da query
            pstm.setString(4, objProdutoDTO.getBebida());
            pstm.setFloat(5, objProdutoDTO.getPreco());
            pstm.setString(6, objProdutoDTO.getAdicional());
            pstm.setInt(7, objProdutoDTO.getId_Cardapio());

            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }
    }
     
    public void excluirProduto(ProdutosDTO objProdutoDTO) { //método público
        String sql = "DELETE FROM tb_produto WHERE id_Cardapio = ?"; //query sql

        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
                pstm.setInt(1, objProdutoDTO.getId_Cardapio()); 

                pstm.execute(); //executa a query no banco
                pstm.close(); //fecha a conexão do banco
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
            }
    }
}
