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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.Cliente;
import application.TelaDois;

public class ControleRealizarAluguel implements Initializable{
	TelaDois tela = new TelaDois();
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
	private ObservableList<Alugar> alugardados = FXCollections.observableArrayList();
	private ObservableList<Alugar> realizar = FXCollections.observableArrayList();
	String nomeFilme;
	float precoFilme;
	float soma = 0;
	int idfilmeFK;
	int del;
	static String dado;

    @FXML
    private TextField txtFilme;

    @FXML
    private Button buttonVerCliente;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonVerFIlme;
    
    @FXML
    private Label lblTotalPreco;

    @FXML
    private TableColumn<Alugar, String> colVerFilme;

    @FXML
    private TableView<Alugar> tabelaVerFilme;

    @FXML
    private Button buttonAdicionar;

    @FXML
    private TextField txtCliente;

    @FXML
    private TableView<Alugar> tabelaAlugarFilme;

    @FXML
    private TableColumn<Alugar, String> colFilme;

    @FXML
    private Button buttonvoltar;

    @FXML
    private TableColumn<Alugar, String> colPreco;

    @FXML
    void voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");    	
    }
    
    @FXML
    void adicionar(ActionEvent event) {
    	if (tabelaVerFilme.getSelectionModel().getSelectedItem() != null ){
    		Alugar c = tabelaVerFilme.getSelectionModel().getSelectedItem();
    		nomeFilme = c.getNomeFilmes();
    		precoFilme = c.getPrecoFilmes();
    		soma = soma + precoFilme;
    	}
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM filmes");
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_filme").contains(nomeFilme)) {
    				realizar.add(new Alugar(conecta.rs.getString("nome_filme"), conecta.rs.getFloat("preco_filme")));
    				colFilme.setCellValueFactory(new PropertyValueFactory<Alugar, String>("nomeFilmes"));
    				colPreco.setCellValueFactory(new PropertyValueFactory<Alugar, String>("precoFilmes"));
    				tabelaAlugarFilme.setItems(realizar);
    				
    	    		
    			}
    		}
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}
    	String totalpagar =String.valueOf(soma);
    	lblTotalPreco.setText(totalpagar);
    }
    
    @FXML
    void removerLista(ActionEvent event){
    	if (tabelaAlugarFilme.getSelectionModel().getSelectedItem() != null ){
	    	Alugar c = tabelaAlugarFilme.getSelectionModel().getSelectedItem();
    		nomeFilme = c.getNomeFilmes();
	    	precoFilme = c.getPrecoFilmes();


    	}

    }
    
    @FXML
    void verFilme(ActionEvent event) {
    	alugardados.clear();
    	String pesquisa = txtFilme.getText();
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM filmes");
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_filme").contains(pesquisa)) {
    				alugardados.add(new Alugar(conecta.rs.getString("nome_filme"), conecta.rs.getFloat("preco_filme")));
    				colVerFilme.setCellValueFactory(new PropertyValueFactory<Alugar, String>("nomeFilmes"));
    				tabelaVerFilme.setItems(alugardados);
    			}
    		}
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}
    }
    
    @FXML
    void verCliente(ActionEvent event) {
    	new TelaDois().start(new Stage());
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtCliente.setText(dado);
	}
}