package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleDevolucao {
	Main main = new Main();

    @FXML
    private Button buttonPesquisar;

    @FXML
    private Button buttonVoltarDevolucao;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");

    }

}