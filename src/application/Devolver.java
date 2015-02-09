package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Devolver {
	private StringProperty idAluguel;
	private StringProperty idCliente;
	private FloatProperty precoFilmes;
	
	public Devolver(String idAluguel, String idCliente, Float precoFilmes){
		this.idAluguel = new SimpleStringProperty(idAluguel);
		this.idCliente = new SimpleStringProperty(idCliente);
		this.precoFilmes = new SimpleFloatProperty(precoFilmes);
	}
	public String getIdAluguel() {
		return idAluguel.get();
	}

	public void setIdAluguel(String idAluguel) {
		this.idAluguel.set(idAluguel);
	}

	public String getIdCliente() {
		return idCliente.get();
	}

	public void setIdCliente(String idCliente) {
		this.idCliente.set(idCliente);
	}

	public Float getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(Float precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
}
