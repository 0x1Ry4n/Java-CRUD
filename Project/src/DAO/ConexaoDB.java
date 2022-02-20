package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDB {
    public Connection conectaBD(){ //método público
          Connection conn = null;  //Objeto de conexão
          try{ //tente
            String url = "jdbc:mysql://localhost:3306/database?user=&password="; //url do localhost que se conecta ao banco 
            conn = DriverManager.getConnection(url); //estabelecer a conexão entre o localhost e o java 
          }catch(SQLException erro){ //exceto
            JOptionPane.showMessageDialog(null, erro.getMessage()); //mostra a mensagem de erro se o Exception for chamado
          }
        return conn; //retorno do estabelecimento de conexão
    }
}
