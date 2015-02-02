package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleRealizarAluguel {
	Main main = new Main();

    @FXML
    private TextField entradaCliente;

    @FXML
    private TextField entradafilme;

    @FXML
    private Button buttonvoltar;

    @FXML
    void voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");
    	
    }

    }

