package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Filmes {
	private StringProperty idFilmes;
	private StringProperty nomeFilmes;
	private StringProperty generoFilmes;
	private DoubleProperty precoFilmes;
	
	public Filmes (String idFilmes, String nomeFilmes, String generoFilmes,Float precoFilmes){
		this.idFilmes = new SimpleStringProperty(idFilmes);
		this.nomeFilmes = new SimpleStringProperty(nomeFilmes);
		this.generoFilmes = new SimpleStringProperty(generoFilmes);
		this.precoFilmes = new SimpleDoubleProperty(precoFilmes);	
	}

	public String getIdFilmes() {
		return idFilmes.get();
	}

	public void setIdFilmes(String idFilmes) {
		this.idFilmes.set(idFilmes);
	}
	 public StringProperty idFilmesProperty() {
	        return idFilmes;
	    }
	public String getNomeFilmes() {
		return nomeFilmes.get();
	}

	public void setNomeFilmes(String nomeFilmes) {
		this.nomeFilmes.set(nomeFilmes);
	}
	 public StringProperty nomeFilmesProperty() {
	        return nomeFilmes;
	    }

	public String getGeneroFilmes() {
		return generoFilmes.get();
	}

	public void setGeneroFilmes(String generoFilmes) {
		this.generoFilmes.set(generoFilmes);
	}
	
	 public StringProperty generoFilmesProperty() {
	        return generoFilmes;
	    }

	public Double getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(Double precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
	 public DoubleProperty precoFilmesProperty() {
	        return precoFilmes;
	    }
	
	

}
