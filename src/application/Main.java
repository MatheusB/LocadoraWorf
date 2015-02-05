package application;

import java.io.IOException;

import utilitades.ConectaBanco;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	ConectaBanco conecta = new ConectaBanco();
	static Stage palco;
	private Pane base;
	String tela = "/view/TelaInicial.fxml";
	Cliente cliente;

	@Override
	public void start(Stage palco) {
		this.palco = palco;
		conecta.conexao();
		iniciarTela(tela);
	
	}

	// Chamada da funçãoo que inicializa a tela
	public void iniciarTela(String tela){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(tela));
			base = (Pane) loader.load();
			palco.setResizable(false); 
			palco.setTitle("Locadora");
			
			Scene cena = new Scene (base);
			palco.setScene(cena);
			palco.show();	
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		}
}
