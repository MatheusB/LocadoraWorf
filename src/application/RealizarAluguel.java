package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RealizarAluguel {
	private StringProperty idFilme;
	private StringProperty nomeFilmes;
	private FloatProperty precoFilmes;
	
	public RealizarAluguel(String idFilme, String nomeFilmes, Float precoFilmes){
		this.idFilme = new SimpleStringProperty(idFilme);
		this.nomeFilmes = new SimpleStringProperty(nomeFilmes);
		this.precoFilmes = new SimpleFloatProperty(precoFilmes);
	}
	
	public String getidFilme() {
		return idFilme.get();
	}

	public void setidFilme(String idFilme) {
		this.idFilme.set(idFilme);
	}
    public StringProperty idFilmeProperty() {
        return idFilme;
    }

	public String getNomeFilmes() {
		return nomeFilmes.get();
	}

	public void setNomeFilmes(String nomeFilmes) {
		this.nomeFilmes.set(nomeFilmes);
	}
    public StringProperty nomeFilmeProperty() {
        return nomeFilmes;
    }

	public Float getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(Float precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
    public FloatProperty precoFilmeProperty() {
        return precoFilmes;
    }
}
