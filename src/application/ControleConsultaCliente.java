package application;


import java.sql.SQLException;

import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsultaCliente {
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
    
	@FXML
    private TableView<ConectaBanco> tabelaConsultaCliente;
	
    @FXML
    private TableColumn<ConectaBanco, String> sobreCliente;

    @FXML
    private TableColumn<ConectaBanco, String> nomeCliente;
    
	@FXML
    private TableColumn<ConectaBanco, String> ruaCliente;

    @FXML
    private TableColumn<ConectaBanco, String> codCliente;
    
    @FXML
    private TextField txtConsultaNome;

    @FXML
    private Button buttonVoltar;

    @FXML
    private Button buttonPesquisarCliente;
    

    @FXML
    void pesquisarCliente(ActionEvent event) {
    		try {
    			conecta.conexao();
				conecta.executaSQL("select * from clientes");
				conecta.rs.first();
				codCliente.setText(String.valueOf(conecta.rs.getInt("id_cliente")));
				nomeCliente.setText(conecta.rs.getString("nome_cliente"));
				sobreCliente.setText(conecta.rs.getString("sobre_cliente"));
				ruaCliente.setText(conecta.rs.getString("rua_cliente"));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
			}
    	}


    @FXML
    void Voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");

    }

}