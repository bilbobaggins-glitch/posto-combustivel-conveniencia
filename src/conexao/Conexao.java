package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    public Conexao() {
        
    }
    
    //Atributo conexão da classe Connection: para estabelecer a conexão com o SGBD
    private static Connection con;
    //Atributo declaração da classe Statement: para elaborar as expressões SQL
    private static Statement stm;
    
    private static void conectar() throws ConexaoException {
        //Tentar fazer conexao com banco MySQL
        String driver = "jdbc:mysql:";
        String bancoDados = "//localhost:3306/postodegasolina";
        String user = "root";
        String pass = "ifsc";
        
        try {
            //Acessar a classe Driver mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Estabelecimento da conexao atraves da invocacao do metodo getConnection
            con = DriverManager.getConnection(driver + bancoDados, user, pass);
            //JOptionPane.showMessageDialog(null, "Conexão realizada!");
            //habilitando stm para execucao de expressoes SQL
            stm = con.createStatement();            
        }
        catch (ClassNotFoundException e) {
            throw new ConexaoException("Driver de banco de dados não foi encontrado\n" +
                    "Error: " + e.getMessage());
        }
        catch (SQLException e) {
            throw new ConexaoException("Falha na conexão com o banco de dados\n"
                    + "Nome ou senha de usuário inválidos.\n"
                    + "Error: " + e.getMessage() + "\n"
                            + e.getStackTrace().toString());
        }
    }
    
    public static void encerrar() {
        try {
            con.close();    
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exceção SQL!");
        }
        
    }
    
    public static Statement getStm() {
        return stm;
    }
    
    public static Connection getCon() throws ConexaoException {
        if (con == null) {
            conectar();
        } 
        return con;
    }
    
    public static void setDeclaracao(Statement s) {
        stm = s;
    }
    
    public static void setCon(Connection c) {
        con = c;
    }
}
