package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Alugar {
	private StringProperty nomeFilmes;
	private FloatProperty precoFilmes;
	
	public Alugar(String nomeFilmes, Float precoFilmes){
		this.nomeFilmes = new SimpleStringProperty(nomeFilmes);
		this.precoFilmes = new SimpleFloatProperty(precoFilmes);
	}

	public String getNomeFilmes() {
		return nomeFilmes.get();
	}

	public void setNomeFilmes(String nomeFilmes) {
		this.nomeFilmes.set(nomeFilmes);
	}

	public Float getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(Float precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
}
