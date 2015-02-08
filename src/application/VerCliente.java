package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VerCliente {
	private StringProperty id;
	private StringProperty nomeCliente;
	private StringProperty sobreCliente;
	
	public VerCliente(String id, String nomeCliente, String sobreCliente){
		this.id = new SimpleStringProperty(id);
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.sobreCliente = new SimpleStringProperty(sobreCliente);

	}
	
	public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
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
