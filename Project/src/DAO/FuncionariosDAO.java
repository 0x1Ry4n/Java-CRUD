/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FuncionariosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class FuncionariosDAO {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void CadastrarFuncionario(FuncionariosDTO objFuncionario) {
        String sql = "INSERT INTO tb_funcionario(nome, cargo, RG, salario) VALUES(?, ?, ?, ?)";
        connection = new ConexaoDB().conectaBD();
        try {
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            
            pstm.setString(1, objFuncionario.getNome());
            pstm.setString(2, objFuncionario.getCargo());
            pstm.setString(3, objFuncionario.getRG());
            pstm.setFloat(4, objFuncionario.getSalario());
            
            pstm.execute();
            pstm.close();
        } catch(SQLException err) {
            System.out.print(err.getMessage());
        }
        
    } 
    
    
    public ArrayList<FuncionariosDTO> PesquisarFuncionario() {
        ArrayList<FuncionariosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_funcionario";
        
        connection = new ConexaoDB().conectaBD();

        try {
            pstm = connection.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                FuncionariosDTO objFuncionariosDTO = new FuncionariosDTO();
                objFuncionariosDTO.setId_Funcionario(rs.getInt("id_Funcionario"));
                objFuncionariosDTO.setNome(rs.getString("nome"));
                objFuncionariosDTO.setCargo(rs.getString("cargo"));
                objFuncionariosDTO.setRG(rs.getString("RG"));
                objFuncionariosDTO.setSalario(rs.getFloat("salario"));
                
                lista.add(objFuncionariosDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "FuncionariosDAo Pesquisar: " + error);
        }
        return lista;
    }
      
    
    public void alterarFuncionario(FuncionariosDTO objFuncionarioDTO) {
        String sql = "UPDATE tb_funcionario SET nome = ?, cargo = ?, RG = ?, salario = ? WHERE id_Funcionario = ?";
        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setString(1, objFuncionarioDTO.getNome()); //seta o Nome da pessoa no primeiro parâmetro da query
            pstm.setString(2, objFuncionarioDTO.getCargo());
            pstm.setString(3, objFuncionarioDTO.getRG());//seta o Endereço da pessoa no segundo parâmetro da query
            pstm.setFloat(4, objFuncionarioDTO.getSalario());
            pstm.setInt(5, objFuncionarioDTO.getId_Funcionario());

            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }

    }
    
    public void excluirFuncionario(FuncionariosDTO objFuncionarioDTO) { //método público
        String sql = "DELETE FROM tb_funcionario WHERE id_Funcionario = ?"; //query sql

        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setInt(1, objFuncionarioDTO.getId_Funcionario()); 
            
            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }
    }
    
}
