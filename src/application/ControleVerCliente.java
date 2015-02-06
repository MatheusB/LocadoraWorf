package application;

import utilitades.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControleVerCliente {
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
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

    }

    @FXML
    void adicionar(ActionEvent event) {

    }

}

