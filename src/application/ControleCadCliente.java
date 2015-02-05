package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import javafx.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import javax.swing.plaf.RootPaneUI;

import org.postgresql.core.Logger;

import utilitades.ConectaBanco;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utilitades.ConectaBanco;

public class ControleCadCliente {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	Cliente cliente;
	
	@FXML
	private TextField txtNumCasa;

	@FXML
    private Button buttonVoltar;

    @FXML
    private Button buttonCadastrar;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSobrenome;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtBairro;

    @FXML
    private Button buttonCadastrarCliente;
    
    
    @FXML
    void voltarMenu(ActionEvent event){
    	main.iniciarTela("/view/TelaInicial.fxml");
    	
    }
 
    @FXML
    void cadastrarCliente(ActionEvent event){
    	if (txtNome.getText().length()==0){
    		JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    	}else if (txtSobrenome.getText().length()==0){
    		JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    } else if(txtRua.getText().length()==0){
    	JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    }else if (txtBairro.getText().length()==0){
    	JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    } else if (txtNumCasa.getText().length()==0){
    	JOptionPane.showMessageDialog(null,"É preciso preencher todos os campos obrigatórios");
    }else
    	try {
    	conecta.conexao();
    	PreparedStatement pst = conecta.conn.prepareStatement("insert into clientes (nome_cliente, sobre_cliente, email_cliente, rua_cliente, bairro_cliente, casa_cliente) values(?,?,?,?,?,?)");
    	pst.setString(1, txtNome.getText());
    	pst.setString(2, txtSobrenome.getText());
    	pst.setString(3, txtEmail.getText());
    	pst.setString(4, txtRua.getText());
    	pst.setString(5, txtBairro.getText());
    	pst.setString(6, txtNumCasa.getText());
    	pst.executeUpdate();
    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    	} catch (SQLException ex){
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+ex);
    	}
    	txtNome.setText("");
    	txtSobrenome.setText("");
    	txtEmail.setText("");
    	txtRua.setText("");
    	txtBairro.setText("");
    	txtNumCasa.setText("");
    }

} 
    




