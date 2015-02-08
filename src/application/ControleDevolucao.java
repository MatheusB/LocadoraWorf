package application;
import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControleDevolucao {
	TelaDois tela = new TelaDois();
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	private ObservableList<Filmes> devolver = FXCollections.observableArrayList();


    @FXML
    private Button buttonPesquisar;

    @FXML
    private Button buttonVoltarDevolucao;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    void pesquisar(ActionEvent event) {
    	devolver.clear();
    	String pesquisa = txtNomeCliente.getText();
			try {
			conecta.conexao();
			conecta.executaSQL("select * from alugueis");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_cliente").contains(pesquisa)) {
//					filmedados.add(new Filmes(String.valueOf(conecta.rs.getInt("id_filme")),conecta.rs.getString("nome_filme"),conecta.rs.getString("genero_filme"), conecta.rs.getString("preco_filme")));
//					colunaCodigo.setCellValueFactory(new PropertyValueFactory<Filmes, String>("idFilmes"));
//					colunaNome.setCellValueFactory(new PropertyValueFactory<Filmes, String>("nomeFilmes"));
//					colunaGenero.setCellValueFactory(new PropertyValueFactory<Filmes, String>("generoFilmes"));
//					colunaPreco.setCellValueFactory(new PropertyValueFactory<Filmes, String>("precoFilmes"));
//					tabelaCon.setItems(filmedados);
					cont++;
				}
			}if (cont == 0) {
				JOptionPane.showMessageDialog(null, pesquisa+" nao encontrado!");
			}
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
			}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");

    }

}