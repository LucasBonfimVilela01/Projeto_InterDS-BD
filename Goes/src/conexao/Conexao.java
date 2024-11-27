package conexao;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 * Classe para a  conexão SQL
 * 
 */
public class Conexao {
    
    final private String driver = "com.mysql.jdbc.Driver"; //Define o driver
    final private String url = "jdbc:mysql://localhost/academiagoes"; // Define o acesso ao banco no servidor
    final private String usuario = "root"; // Usuário padrão do MySql
    final private String senha = ""; //senha do MySql
    private Connection conexao; //variável da conexão aberta
    public Statement statement; //variável para executar queries do SQL
    public ResultSet resultset; //variável armazeda o resultado da conexão
    
    public boolean conecta(){
        boolean result = true;
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
        }
        catch (ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null,"Driver não localizado"+Driver,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
            }
        catch (SQLException Fonte){
            JOptionPane.showMessageDialog(null,"Fonte de dados não localizada"+Fonte,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
            }
        return result;
    }
    
    public void desconecta() {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null,"Conexão com o banco fechada","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException fecha){
            
        }
    }
    
    public void executaSQL(String sql){
        try{
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}