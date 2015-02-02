package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControleTelaInicial {
	Main main = new Main();
	
	@FXML
    private Button buttonCadFilme;
	
    @FXML
    private Button buttonCadastrarCliente;
    
    @FXML
    private Button buttonRealizarAluguel;
    
    @FXML
    private Button buttonConsultar;
    
    @FXML
    private Button buttonDevolucao;
    
    @FXML
    private Button buttonConsultarCliente;
    
    @FXML
    void cadastrarcliente(ActionEvent event){
    	main.iniciarTela("/view/TelaCadCliente.fxml"); 	
    }
    @FXML
    void cadastrarFilme(ActionEvent event) {
    	main.iniciarTela("/view/TelaCadFilmes.fxml"); 
    }
    @FXML
    void realizarAluguel(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaRealizarAluguel.fxml");
    }
    @FXML
    void consultar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaRealizarConsulta.fxml");
   
    }
    @FXML
    void consultarCliente(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaConsultaCliente.fxml");
    }

    @FXML
    void devolver(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaDevolucao.fxml");

    }
 
}
