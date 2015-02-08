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
import application.Cliente;

public class ControleConsultaCliente {
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();

	private ObservableList<Cliente> clientedados = FXCollections.observableArrayList();
    int del;
	   
	@FXML
    private TableView<Cliente> tabelaConsultaCliente;
	
    @FXML
    private TableColumn<Cliente, String> sobreCliente;

    @FXML
    private TableColumn<Cliente, String> nomeCliente;
    
	@FXML
    private TableColumn<Cliente, String> ruaCliente;

    @FXML
    private TableColumn<Cliente, String> codCliente;
    
    @FXML
    private TextField txtConsultaNome;

    @FXML
    private Button buttonVoltar;

    @FXML
    private Button buttonPesquisarCliente;
    
    @FXML
    private Button limparCliente;
    
    @FXML
    private Button buttonDel;
    
    @FXML
    void Deletar(ActionEvent event) {
    	if (tabelaConsultaCliente.getSelectionModel().getSelectedItem() != null ){
	    	Cliente c = tabelaConsultaCliente.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse cliente?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM clientes WHERE id_cliente ='"+c.getId()+"'");
	        	txtConsultaNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Cliente apagado com sucesso");
	        	pesquisarCliente(event);
        	}
    	}
    }
    
    @FXML
    void limparCliente(ActionEvent event) {
    	clientedados.clear();
    	txtConsultaNome.setText("");
    }   
    
    @FXML
    void pesquisarCliente(ActionEvent event) {
    		clientedados.clear();
    		String pesquisa = txtConsultaNome.getText();
    		try {
    			conecta.conexao();
				conecta.executaSQL("select * from clientes");
				int cont = 0 ;
				while(conecta.rs.next()){
					if (conecta.rs.getString("nome_cliente").contains(pesquisa)) {
						clientedados.add(new Cliente(String.valueOf(conecta.rs.getInt("id_cliente")),conecta.rs.getString("nome_cliente"),conecta.rs.getString("sobre_cliente"), conecta.rs.getString("rua_cliente")));
						codCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
						nomeCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
						sobreCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("sobreNome"));
						ruaCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rua"));
						tabelaConsultaCliente.setItems(clientedados);
						cont++;
					}
				}if (cont == 0) {
					JOptionPane.showMessageDialog(null,pesquisa + " não encontrado!");
				}
				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
			}
    	}


    @FXML
    void Voltar(ActionEvent event) {
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");

    }

}