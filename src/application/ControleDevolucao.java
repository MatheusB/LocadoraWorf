package application;
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

public class ControleDevolucao {
	TelaDois tela = new TelaDois();
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	private ObservableList<Devolver> devolver = FXCollections.observableArrayList();


	 @FXML
	    private TableView<Devolver> tabelaDevolucao;

	    @FXML
	    private TableColumn<Devolver, String> colNome;

	    @FXML
	    private Button buttomRealizarDevolucao;

	    @FXML
	    private TableColumn<Devolver, String> ColPreco;
	    
	    @FXML
	    private TableColumn<Devolver, String> colCodAlugar;

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
			conecta.executaSQL("select * from alu, clientes where alu.id_cliente = clientes.id_cliente");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("id_cliente").contains(pesquisa)) {
					devolver.add(new Devolver(String.valueOf(conecta.rs.getInt("id_aluguel")),conecta.rs.getString("nome_cliente"),conecta.rs.getFloat("preco")));
					colCodAlugar.setCellValueFactory(new PropertyValueFactory<Devolver, String>("idAluguel"));
					colNome.setCellValueFactory(new PropertyValueFactory<Devolver, String>("idCliente"));
					ColPreco.setCellValueFactory(new PropertyValueFactory<Devolver, String>("precoFilmes"));
					tabelaDevolucao.setItems(devolver);
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
    void realizarDevolucao(ActionEvent event) {
    	if (tabelaDevolucao.getSelectionModel().getSelectedItem() != null ){
	    	Devolver c = tabelaDevolucao.getSelectionModel().getSelectedItem();
	    	int del = JOptionPane.showConfirmDialog(null, "Deseja realmente realizar essa devolução?");
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM alu WHERE id_aluguel ='"+c.getIdAluguel()+"'");
	        	txtNomeCliente.setText("");
	        	JOptionPane.showMessageDialog(null,"Devolução realizada com sucesso");
	        	pesquisar(event);
	        	devolver.clear();
        	}
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");

    }

}