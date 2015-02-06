package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Alugar {
	private StringProperty nomeFilmes;
	private StringProperty precoFilmes;
	
	public Alugar(String nomeFilmes, String precoFilmes){
		this.nomeFilmes = new SimpleStringProperty(nomeFilmes);
		this.precoFilmes = new SimpleStringProperty(precoFilmes);
	}

	public String getNomeFilmes() {
		return nomeFilmes.get();
	}

	public void setNomeFilmes(String nomeFilmes) {
		this.nomeFilmes.set(nomeFilmes);
	}

	public String getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(String precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
}
