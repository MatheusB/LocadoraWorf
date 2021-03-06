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
	private ObservableList<RealizarAluguel> realizar = FXCollections.observableArrayList();
	String nomeFilme;
	float precoFilme;
	float soma = 0;
	String idfilmeFK;
	int del;
	static String dado;
	static String idCliente;
	int quantidade = 0;


    @FXML
    private TextField txtFilme;
    
    @FXML
    private TableColumn<RealizarAluguel, String> colCodFilme;
    
    @FXML
    private Label lblCodCliente;

    @FXML
    private Button buttonAlugar;

    @FXML
    private Button buttonVerCliente;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonVerFIlme;
    
    @FXML
    private Label lblTotalPreco;
    
    @FXML
    private Label lblquantidade;

    @FXML
    private TableColumn<Alugar, String> colVerFilme;

    @FXML
    private TableView<Alugar> tabelaVerFilme;

    @FXML
    private Button buttonAdicionar;

    @FXML
    private TextField txtCliente;

    @FXML
    private TableView<RealizarAluguel> tabelaAlugarFilme;

    @FXML
    private TableColumn<RealizarAluguel, String> colFilme;

    @FXML
    private Button buttonvoltar;

    @FXML
    private TableColumn<RealizarAluguel, String> colPreco;
    
    //VOLTAR
    @FXML
    void voltar(ActionEvent event) {
    	txtCliente.setText("");
    	main.palco.close();
    	main.iniciarTela("/view/TelaInicial.fxml");    	
    }
    //ADICIONAR FILME A LISTA
    @FXML
    void adicionar(ActionEvent event) {
    	if (tabelaVerFilme.getSelectionModel().getSelectedItem() != null ){
    	    Alugar c = tabelaVerFilme.getSelectionModel().getSelectedItem();
    		nomeFilme = c.getNomeFilmes();
    		precoFilme = c.getPrecoFilmes();
    		soma = soma + precoFilme;
    		quantidade = quantidade + 1;
    	}
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM filmes");
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_filme").contains(nomeFilme)) {
    				realizar.add(new RealizarAluguel(String.valueOf(conecta.rs.getInt("id_filme")), conecta.rs.getString("nome_filme"), conecta.rs.getFloat("preco_filme")));
    				colCodFilme.setCellValueFactory(new PropertyValueFactory<RealizarAluguel, String>("idFilme"));
    				colFilme.setCellValueFactory(new PropertyValueFactory<RealizarAluguel, String>("nomeFilmes"));
    				colPreco.setCellValueFactory(new PropertyValueFactory<RealizarAluguel, String>("precoFilmes"));
    				tabelaAlugarFilme.setItems(realizar); 			
    			}
    		}
//    		conecta.conexao();
//	          PreparedStatement pst = conecta.conn.prepareStatement("insert into filmes_aluguel (id_filme, id_aluguel) values(?,?)");
//	          pst.setInt(1, Integer.parseInt(colCodFilme.getText()));
//	          pst.setInt(2, conecta.rs.last());
//        	
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}
    	String totalfilmes =String.valueOf(quantidade);
    	String totalpagar =String.valueOf(soma);
    	lblTotalPreco.setText(totalpagar);
    	lblquantidade.setText(totalfilmes);
    }
    //REMOVER ALGUM FILME DA LISTA 
    @FXML
    void removerLista(ActionEvent event){
    	if (tabelaAlugarFilme.getSelectionModel().getSelectedItem() != null ){
	    	RealizarAluguel c = tabelaAlugarFilme.getSelectionModel().getSelectedItem();
	    	int remo; 
	    	precoFilme = c.getPrecoFilmes();
	    	remo = JOptionPane.showConfirmDialog(null, "Deseja realmente remover esse filme?");
	    	if (remo == JOptionPane.YES_OPTION){
	        	realizar.remove(c);
	    		soma = soma - precoFilme; 
	    		quantidade = quantidade - 1;
	    	} 
	    	String totalpagar =String.valueOf(soma);
	    	lblTotalPreco.setText(totalpagar);
	    	String totalfilmes =String.valueOf(quantidade);
	    	lblquantidade.setText(totalfilmes);
    	}

    }
    //VERIFICAR OS FILMES
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
    //REALIZAR ALUGUEL
    @FXML
    void alugar(ActionEvent event) {
    	  try {
    	          conecta.conexao();
    	          PreparedStatement pst = conecta.conn.prepareStatement("insert into alu (id_cliente, quantidade, preco) values(?,?,?)");
    	          pst.setInt(1, Integer.parseInt(lblCodCliente.getText()));
    	          pst.setInt(2, Integer.parseInt(lblquantidade.getText()));
    	          pst.setFloat(3, Float.parseFloat(lblTotalPreco.getText()));
    	          pst.executeUpdate();
    	          JOptionPane.showMessageDialog(null, "Aluguel realizado com sucesso");
	    	} catch (SQLException ex){
	    		JOptionPane.showMessageDialog(null,"Erro ao realizar aluguel"+ex);
    		}
    	}
    
    //VER CLIENTE
    @FXML
    void verCliente(ActionEvent event) {
    	new TelaDois().start(new Stage());
    }
    //INICIALIZAR COM O NOME DO CLIENTE
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtCliente.setText(dado);
		lblCodCliente.setText(idCliente);
	}
}