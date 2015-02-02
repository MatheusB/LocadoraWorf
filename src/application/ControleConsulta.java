package application;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsulta {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
    @FXML
    private Button buttonVoltarConsulta;
   
    @FXML
    private TableView<ConectaBanco> tabelaCon;
    
    @FXML
    private Button buttonPesquisarFilme;

    @FXML
    private TextField txtConsultaFilme;

    @FXML
    private TableColumn<ConectaBanco, String> colunaCodigo;

    @FXML
    private TableColumn<ConectaBanco, String> colunaNome;

    @FXML
    private TableColumn<ConectaBanco, String> colunaGenero;
    
    @FXML
    private TableColumn<ConectaBanco, String> colunaPreco;
    
    @FXML
    private TextField testeCon;

    @FXML
    void voltarConsulta(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");
    } 
    
    @FXML
    void pesquisarFilme(ActionEvent event) {
     	
    	try {
    		conecta.conexao();
    		conecta.executaSQL("select * from filmes");
			conecta.rs.last();
    		colunaCodigo.setText(String.valueOf(conecta.rs.getInt("id_filme")));
    		colunaNome.setText(conecta.rs.getString("nome_filme"));
    		colunaGenero.setText(conecta.rs.getString("genero_filme"));
    		colunaPreco.setCellValueFactory(new PropertyValueFactory<ConectaBanco, String>(conecta.rs.getString("preco_filme")));
//			colunaPreco.setText(conecta.rs.getString("preco_filme"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
		
    }
    }
}
