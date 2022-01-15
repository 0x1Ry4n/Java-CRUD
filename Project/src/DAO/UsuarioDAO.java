package DAO;

import DAO.ConexaoDB;
import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn; //Objeto de conexão
    PreparedStatement pstm;
    public ResultSet Autenticacao(UsuarioDTO objUsuario) { //método público 
        conn = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost
        try {
            String sql = "SELECT * FROM tb_usuario WHERE nome_usuario = ? AND senha_usuario = ?"; //query sql
            pstm = conn.prepareStatement(sql); //Objeto para o preparamento de query's

            pstm.setString(1, objUsuario.getUsuario());
            pstm.setString(2, objUsuario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
        
            return rs;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro, digite a senha correta!");  //mostra a mensagem de erro se o Exception for chamado
            return null;
        }
    }
}



  