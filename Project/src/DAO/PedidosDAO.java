/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PedidosDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Ryan
 */
public class PedidosDAO {
    Connection connection; 
    PreparedStatement pstm;
    ResultSet rs;
    
    public void CadastrarPedido(PedidosDTO objPedidoDTO) {
        connection = new ConexaoDB().conectaBD();
        String sql = "INSERT INTO tb_pedido(data_Ped, cod_Cliente, cod_Produto, cod_Funcionario, cod_Mesa) VALUES(?, ?, ?, ?, ?)";
        
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, objPedidoDTO.getData());
            pstm.setInt(2, objPedidoDTO.getCodCliente());
            pstm.setInt(3, objPedidoDTO.getCodPedido());
            pstm.setInt(4, objPedidoDTO.getCodFuncionario());
            pstm.setInt(5, objPedidoDTO.getCodMesa());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException err) {
            System.out.print(err.getMessage());
        }
    }
    
    
    public ResultSet listarCliente() {
        connection = new ConexaoDB().conectaBD();

        String sql = "SELECT * FROM tb_cliente cli ORDER BY cli.id_Cliente";
        try {
            pstm = connection.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listarMesa() {
        connection = new ConexaoDB().conectaBD();

        String sql = "SELECT * FROM tb_mesa mes ORDER BY mes.id_Mesa";
        try {
            pstm = connection.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listarProdutos() {
        connection = new ConexaoDB().conectaBD();

        String sql = "SELECT * FROM tb_produto prod ORDER BY prod.id_Cardapio";
        try {
            pstm = connection.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listarFuncionarios() {
        connection = new ConexaoDB().conectaBD();

        String sql = "SELECT * FROM tb_funcionario func ORDER BY func.id_Funcionario";
        try {
            pstm = connection.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    public ArrayList<PedidosDTO> PesquisarPedido() {
        ArrayList<PedidosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_pedido";
        
        connection = new ConexaoDB().conectaBD();

        try {
            pstm = connection.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                PedidosDTO objPedidosDTO = new PedidosDTO();
                objPedidosDTO.setId_Pedido(rs.getInt("id_Pedido"));
                objPedidosDTO.setData(rs.getString("data_Ped"));
                objPedidosDTO.setCodCliente(rs.getInt("cod_Cliente"));
                objPedidosDTO.setCodPedido(rs.getInt("cod_Produto"));
                objPedidosDTO.setCodFuncionario(rs.getInt("cod_Funcionario"));
                objPedidosDTO.setCodMesa(rs.getInt("cod_Mesa"));
                
                lista.add(objPedidosDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "PedidosDAO Pesquisar: " + error);
        }
        return lista;
    }
    
    public void alterarPedido(PedidosDTO objPedidoDTO) {
        String sql = "UPDATE tb_pedido SET data_Ped = ? WHERE id_Pedido = ?";
        connection = new ConexaoDB().conectaBD(); 

        try {
            pstm = connection.prepareStatement(sql); 
            pstm.setString(1, objPedidoDTO.getData()); 
            pstm.setInt(2, objPedidoDTO.getId_Pedido());
            pstm.execute(); 
            
            pstm.close(); 
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); 
        }
    }
    
    public void excluirPedido(PedidosDTO objPedidoDTO) { //método público
        String sql = "DELETE FROM tb_pedido WHERE id_Pedido = ?"; //query sql

        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
                pstm.setInt(1, objPedidoDTO.getId_Pedido()); 

                pstm.execute(); //executa a query no banco
                pstm.close(); //fecha a conexão do banco
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
            }
    }
}










