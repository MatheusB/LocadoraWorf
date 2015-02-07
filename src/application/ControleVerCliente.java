package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.TelaDois;

public class ControleVerCliente implements Initializable{
	TelaDois tela = new TelaDois();
	ControleRealizarAluguel novo = new ControleRealizarAluguel();
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
	static String dado;
	static int idclienteFK;
	private ObservableList<VerCliente> verdados = FXCollections.observableArrayList();
	
    @FXML
    private TableView<VerCliente> tabelaVer;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<VerCliente, String> colNomeCliente;

    @FXML
    private Button buttonAdicionar;

    @FXML
    private TableColumn<VerCliente, String> colSobreCliente;

	
    @FXML
    void voltar(ActionEvent event) {
    	tela.palco2.close();
    }

    @FXML
    void adicionar(ActionEvent event) {
    	if (tabelaVer.getSelectionModel().getSelectedItem() != null ){
    		VerCliente c = tabelaVer.getSelectionModel().getSelectedItem();
    		dado = c.getNomeCliente();
    	ControleRealizarAluguel.dado = dado;
    	main.palco.close();
    	main.iniciarTela("/view/TelaRealizarAluguel.fxml");
    	tela.palco2.close();
    	}
    	

    }
	public void mostrar(){
    	try{
		conecta.conexao();
		conecta.executaSQL("SELECT * FROM clientes");
		while(conecta.rs.next()){
			idclienteFK = conecta.rs.getInt("id_cliente");	
			verdados.add(new VerCliente(conecta.rs.getString("nome_cliente"), conecta.rs.getString("sobre_cliente")));
			colNomeCliente.setCellValueFactory(new PropertyValueFactory<VerCliente, String>("nomeCliente"));
			colSobreCliente.setCellValueFactory(new PropertyValueFactory<VerCliente, String>("sobreCliente"));
			tabelaVer.setItems(verdados);		
		}
	} catch (Exception ex){
		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
	}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mostrar();
		
	}
	
}

