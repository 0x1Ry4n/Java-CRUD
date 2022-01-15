/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClientesDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class ClientesDAO {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    
        
    public void CadastrarCliente(ClientesDTO objClientes) {
        String sql = "INSERT INTO tb_cliente(nomeCliente, cpf_Cli, telefone, bairro, complemento, numeroCasa) VALUES(?,?,?,?,?,?)";
        connection = new ConexaoDB().conectaBD();
        try {
            pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, objClientes.getNomeCliente());
            pstm.setString(2, objClientes.getCpfCli());
            pstm.setString(3, objClientes.getTelefone());
            pstm.setString(4, objClientes.getBairro());
            pstm.setString(5, objClientes.getComplemento());
            pstm.setInt(6, objClientes.getNumeroCasa());
        
            pstm.execute();
            pstm.close();
        } catch(SQLException err) {
            System.out.print(err.getMessage());
        }
    }
    
    
    public ArrayList<ClientesDTO> PesquisarCliente() {
        
        ArrayList<ClientesDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_cliente";
        
        connection = new ConexaoDB().conectaBD();

        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientesDTO objClienteDTO = new ClientesDTO();
                objClienteDTO.setId_Cliente(rs.getInt("id_Cliente"));
                objClienteDTO.setNomeCliente(rs.getString("nomeCliente"));
                objClienteDTO.setTelefone(rs.getString("telefone"));
                objClienteDTO.setCpfCli(rs.getString("cpf_Cli"));
                objClienteDTO.setTelefone(rs.getString("telefone"));
                objClienteDTO.setBairro(rs.getString("bairro"));
                objClienteDTO.setComplemento(rs.getString("complemento"));
                objClienteDTO.setNumeroCasa(rs.getInt("numeroCasa"));
                lista.add(objClienteDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar: " + error);
        }
        return lista;
    }
    
    public void alterarCliente(ClientesDTO objClienteDTO) {
        String sql = "UPDATE tb_cliente SET nomeCliente = ?, cpf_Cli = ?, telefone = ?, bairro = ?, complemento = ?, numeroCasa = ? WHERE id_Cliente = ?";
        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setString(1, objClienteDTO.getNomeCliente()); //seta o Nome da pessoa no primeiro parâmetro da query
            pstm.setString(2, objClienteDTO.getCpfCli());
            pstm.setString(3, objClienteDTO.getTelefone());//seta o Endereço da pessoa no segundo parâmetro da query
            pstm.setString(4, objClienteDTO.getBairro());
            pstm.setString(5, objClienteDTO.getComplemento());
            pstm.setInt(6, objClienteDTO.getNumeroCasa());
            pstm.setInt(7, objClienteDTO.getId_Cliente());

            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }

    }

    
    public void excluirCliente(ClientesDTO objClienteDTO) { //método público
        String sql = "DELETE FROM tb_cliente WHERE id_Cliente = ?"; //query sql

        connection = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost

        try {
            pstm = connection.prepareStatement(sql); //prepara a query
            pstm.setInt(1, objClienteDTO.getId_Cliente()); 
            
            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage()); //mostra a mensagem de erro se o Exception for chamado
        }
    }
    
}
