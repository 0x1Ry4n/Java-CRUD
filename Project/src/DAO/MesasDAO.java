/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FuncionariosDTO;
import DTO.MesasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class MesasDAO {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void CadastrarMesa(MesasDTO objMesaDTO) {
        connection = new ConexaoDB().conectaBD();
        String sql = "INSERT INTO tb_mesa(nomeCliente, numMesa) VALUES(?,?)";
        
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, objMesaDTO.getNomeCliente());
            pstm.setInt(2, objMesaDTO.getNumMesa());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException err) {
            System.out.print(err.getMessage());
        }
    }
    
    
     
      public ArrayList<MesasDTO> PesquisarMesas() {
        ArrayList<MesasDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_mesa";
        
        connection = new ConexaoDB().conectaBD();

        try {
            pstm = connection.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                MesasDTO objMesasDTO = new MesasDTO();
                objMesasDTO.setId_Mesa(rs.getInt("id_Mesa"));
                objMesasDTO.setNomeCliente(rs.getString("nomeCliente"));
                objMesasDTO.setNumMesa(rs.getInt("numMesa"));
                
                lista.add(objMesasDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "MesasDAO Pesquisar: " + error);
        }
        return lista;
    }
      
      
      
    public void alterarFuncionario(MesasDTO objMesasDTO) {
        String sql = "UPDATE tb_mesa SET nomeCliente = ?, numMesa = ? WHERE id_Mesa = ?";
        connection = new ConexaoDB().conectaBD(); 

        try {
            pstm = connection.prepareStatement(sql); 
            pstm.setString(1, objMesasDTO.getNomeCliente()); 
            pstm.setInt(2, objMesasDTO.getNumMesa());
            pstm.setInt(3, objMesasDTO.getId_Mesa());
            pstm.execute();
            pstm.close(); 
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); 
        }
    }
    
    
    public void excluirMesa(MesasDTO objMesaDTO) { //método público
        String sql = "DELETE FROM tb_mesa WHERE id_Mesa = ?"; //query sql

        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setInt(1, objMesaDTO.getId_Mesa()); 
            
            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }
    }
    
}
