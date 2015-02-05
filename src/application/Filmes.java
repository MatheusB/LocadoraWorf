package application;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;

public class Filmes {
	private StringProperty idFilmes;
	private StringProperty nomeFilmes;
	private StringProperty generoFilmes;
	private StringProperty precoFilmes;
	
	public Filmes (String idFilmes, String nomeFilmes, String generoFilmes,String precoFilmes){
		this.idFilmes = new SimpleStringProperty(idFilmes);
		this.nomeFilmes = new SimpleStringProperty(nomeFilmes);
		this.generoFilmes = new SimpleStringProperty(generoFilmes);
		this.precoFilmes = new SimpleStringProperty(precoFilmes);	
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

	public String getPrecoFilmes() {
		return precoFilmes.get();
	}

	public void setPrecoFilmes(String precoFilmes) {
		this.precoFilmes.set(precoFilmes);
	}
	 public StringProperty precoFilmesProperty() {
	        return precoFilmes;
	    }
	
	

}
