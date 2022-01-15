package DAO;

import DAO.ConexaoDB;
import DTO.CadastrarUsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastrarUsuarioDAO {
    Connection conn; //Objeto de conexão
    PreparedStatement pstm; //Objeto para o preparamento de query's
    public void cadastrarUsuario(CadastrarUsuarioDTO objCadastrarUsuario){ //método público
        String sql = "insert into tb_usuario(nome_usuario, senha_usuario) values(?,?)"; //query sql
    
        conn = new ConexaoDB().conectaBD(); //instância do método conectaBD, que conecta o banco ao localhost
        
        try{
            
            pstm = conn.prepareStatement(sql); //prepara a query
            pstm.setString(1, objCadastrarUsuario.getUsuario()); //seta o Nome da pessoa no primeiro parâmetro da query
            pstm.setString(2, objCadastrarUsuario.getSenha());
            
            pstm.execute(); //executa a query no banco
            pstm.close(); //fecha a conexão do banco
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Erro CadastrarUsuarioDAO: " + err.getMessage());
        }
    }
}
