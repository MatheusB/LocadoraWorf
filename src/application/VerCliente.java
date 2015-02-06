package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VerCliente {
	private StringProperty nomeCliente;
	private StringProperty sobreCliente;
	
	public VerCliente(String nomeCliente, String sobreCliente){
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.sobreCliente = new SimpleStringProperty(sobreCliente);

	}

	public String getNomeCliente() {
		return nomeCliente.get();
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente.set(nomeCliente);
	}

	public String getSobreCliente() {
		return sobreCliente.get();
	}

	public void setSobreCliente(String sobreCliente) {
		this.sobreCliente.set(sobreCliente);
	}
}
