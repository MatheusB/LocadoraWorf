package utilitades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectaBanco {
	public Statement stm;	//realizar pesquisas
	public ResultSet rs;	//armazenar pesquisas
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5432/locadora";
	private String usuario = "postgres";
	private String senha = "qwerty";
	public Connection conn;	//conexão com o banco de dados

	public void conexao(){	//método responsável por realizar a conexão com o banco
		try {
			System.setProperty("jdbc.Drivers", driver); //seta a propriedade do driver de conxão
			conn = DriverManager.getConnection(caminho, usuario, senha); //realiza a conexão com o banco de dados
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de conexão!"+ ex.getMessage());
		}
	}
	
	public void executaSQL(String sql){
		try {
			stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			//JOptionPane.showMessageDialog(null, "Erro no executa SQL!"+ ex.getMessage());
		}
	}
	public void desconecta(){	//método para fechar a conexão com bd
		try {
			conn.close();	//fecha a conexão
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao fechar conexão" + ex.getMessage());
		}
	}

}
