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
import javafx.stage.Stage;
import application.Cliente;
import application.TelaDois;

public class ControleRealizarAluguel {
	TelaDois tela = new TelaDois();
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
	private ObservableList<Alugar> alugardados = FXCollections.observableArrayList();
	int del;

    @FXML
    private TextField txtFilme;

    @FXML
    private Button buttonVerCliente;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonVerFIlme;

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
    	
    }
    
    @FXML
    void removerLista(ActionEvent event){
//    	if (tabelaAlugar.getSelectionModel().getSelectedItem() != null ){
//	    	Alugar c = tabelaAlugar.getSelectionModel().getSelectedItem();
//	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse cliente?");
//    	
//	    	if (del == JOptionPane.YES_OPTION){
//	        	conecta.executaSQL("DELETE FROM alugueis WHERE id_cliente ='"+c.getNomeFilmes()+"'");
//	        	JOptionPane.showMessageDialog(null,"Cliente apagado com sucesso");
//	        	
//        	}
//    	}
    }
    
    @FXML
    void verFilme(ActionEvent event) {
    	alugardados.clear();
    	String pesquisa = txtFilme.getText();
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM clientes, filmes");
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_filme").contains(pesquisa)) {
    				alugardados.add(new Alugar(conecta.rs.getString("nome_filme"), conecta.rs.getString("preco_filme")));
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
}