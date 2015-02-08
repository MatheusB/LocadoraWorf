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
	
	private ObservableList<Filmes> filmedados = FXCollections.observableArrayList();
	
	int del;
	    
    @FXML
    private Button buttonVoltarConsulta;
    
    @FXML
    private Button buttonLimparFilme;
    
    @FXML
    private TableView<Filmes> tabelaCon;
    
    @FXML
    private Button buttonPesquisarFilme;

    @FXML
    private TextField txtConsultaFilme;

    @FXML
    private TableColumn<Filmes, String> colunaCodigo;

    @FXML
    private TableColumn<Filmes, String> colunaNome;

    @FXML
    private TableColumn<Filmes, String> colunaGenero;
    
    @FXML
    private TableColumn<Filmes, String> colunaPreco;
    
    @FXML
    private TextField testeCon;
    
    @FXML
    private Button buttonDeletarFIlme;
    
    @FXML
    void deletarFilme(ActionEvent event) {
    	if (tabelaCon.getSelectionModel().getSelectedItem() != null ){
	    	Filmes f = tabelaCon.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse filme?");
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM filmes WHERE id_filme ='"+f.getIdFilmes()+"'");
	        	txtConsultaFilme.setText("");
	        	JOptionPane.showMessageDialog(null,"Filme apagado com sucesso");
	        	pesquisarFilme(event);
	    	} 
    	}
    }

    @FXML
    void voltarConsulta(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");
    } 
    
    @FXML
    void limparFilme(ActionEvent event) {
    	filmedados.clear();
    	txtConsultaFilme.setText("");
    }
    
    @FXML
    void pesquisarFilme(ActionEvent event) {
    	filmedados.clear();
    	String pesquisa = txtConsultaFilme.getText();
			try {
			conecta.conexao();
			conecta.executaSQL("select * from filmes");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_filme").contains(pesquisa)) {
					filmedados.add(new Filmes(String.valueOf(conecta.rs.getInt("id_filme")),conecta.rs.getString("nome_filme"),conecta.rs.getString("genero_filme"), conecta.rs.getFloat("preco_filme")));
					colunaCodigo.setCellValueFactory(new PropertyValueFactory<Filmes, String>("idFilmes"));
					colunaNome.setCellValueFactory(new PropertyValueFactory<Filmes, String>("nomeFilmes"));
					colunaGenero.setCellValueFactory(new PropertyValueFactory<Filmes, String>("generoFilmes"));
					colunaPreco.setCellValueFactory(new PropertyValueFactory<Filmes, String>("precoFilmes"));
					tabelaCon.setItems(filmedados);
					cont++;
				}
			}if (cont == 0) {
				JOptionPane.showMessageDialog(null, txtConsultaFilme.getText()+" nao encontrado!");
			}
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
			}
    	
    }
}
