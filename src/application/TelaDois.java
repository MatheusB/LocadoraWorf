package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaDois extends Application {
	
	ConectaBanco conecta = new ConectaBanco();
	static Stage palco2;
	private Pane base2;
	String tela2 = "/view/TelaVerClientes.fxml";
	private ObservableList<VerCliente> verdados = FXCollections.observableArrayList();

	public void start(Stage palco2){
		this.palco2 = palco2;
		conecta.conexao();
		iniciarTelaDois(tela2);
				
	}
	public void iniciarTelaDois(String tela){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(tela));
			base2 = (Pane) loader.load();
			palco2.setResizable(false); 
			palco2.setTitle("Clientes");
			
			Scene cena = new Scene (base2);
			palco2.setScene(cena);
			palco2.show();	
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		}

}
