package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utilitades.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControleCadFilmes {

	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	
	@FXML
    private TextField txtfilmeNome;

    @FXML
    private TextField txtgeneroNome;
    
    @FXML
    private TextField txtClassificacao;

    @FXML
    private TextField txtduracao;

    @FXML
    private TextArea txtSinopse;

    @FXML
    private TextField txtPreco;

    @FXML
    private Button buttonvoltar;
    
    @FXML
    private Button cadastrarFilme;

    @FXML
    void vontarMenu(ActionEvent event) {
    	main.iniciarTela("/view/TelaInicial.fxml");

    }
    @FXML
    void cadastrarFilme(ActionEvent event) {
    	if (txtfilmeNome.getText().length()==0){
    		JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    	}else if (txtgeneroNome.getText().length()==0){
    		JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    } else if(txtClassificacao.getText().length()==0){
    	JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    }else if (txtduracao.getText().length()==0){
    	JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    }else
    	try {
        	conecta.conexao();
        	PreparedStatement pst = conecta.conn.prepareStatement("insert into filmes (nome_filme, genero_filme, duracao_filme, classificacao_filme, preco_filme, sinopse_filme) values(?,?,?,?,?,?)");
        	pst.setString(1, txtfilmeNome.getText());
        	pst.setString(2, txtgeneroNome.getText());
        	pst.setString(3, txtduracao.getText());
        	pst.setString(4, txtClassificacao.getText());
        	pst.setString(5, txtPreco.getText());
        	pst.setString(6, txtSinopse.getText());
        	pst.executeUpdate();
        	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
        	} catch (SQLException ex){
        		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+ex);
        	}
    	txtfilmeNome.setText("");
    	txtgeneroNome.setText("");
    	txtClassificacao.setText("");
    	txtduracao.setText("");
    	txtSinopse.setText("");
    	txtPreco.setText("");
   }    	
}
