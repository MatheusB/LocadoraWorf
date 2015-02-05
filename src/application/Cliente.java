package application;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;


public class Cliente{

	private StringProperty id;
	private StringProperty nome;
	private StringProperty sobreNome;
	private StringProperty email;
	private StringProperty rua;
//	private StringProperty bairro;
//	private StringProperty numcasa;
	
	public Cliente (String id,String nome,String sobrenome,String rua){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.sobreNome = new SimpleStringProperty(sobrenome);
		this.rua = new SimpleStringProperty(rua);
	}
	
	
//	public Cliente (String nome,String sobrenome,String email,String rua,String bairro, String numcasa){
//		this.nome = new SimpleStringProperty(nome);
//		this.sobreNome = new SimpleStringProperty(sobrenome);
//		this.email = new SimpleStringProperty(email);
//		this.rua = new SimpleStringProperty(rua);
//		this.bairro = new SimpleStringProperty(bairro);
//		this.numcasa = new SimpleStringProperty(numcasa);
//	}
	public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }
	
	//
	public String getNome() {
        return nome.get();
    }

    public void setNome(String firstName) {
        this.nome.set(firstName);
    }

    public StringProperty nomeProperty() {
        return nome;
    }
    //
    public String getSobreNome() {
        return sobreNome.get();
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome.set(sobreNome);
    }

    public StringProperty sobreNomeProperty() {
        return sobreNome;
    }
    //
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
    

    //
    public String getRua() {
        return rua.get();
    }

    public void setRua(String rua) {
        this.rua.set(rua);
    }

    public StringProperty ruaProperty() {
        return rua;
    }
    //
//    public String getBairro() {
//        return bairro.get();
//    }
//
//    public void setBairro(String bairro) {
//        this.bairro.set(bairro);
//    }
//
//    public StringProperty bairroProperty() {
//        return bairro;
//    }
//    
//    //
//    
//    public String getNumcasa() {
//        return numcasa.get();
//    }
//
//    public void setNumcasa(String numcasa) {
//        this.numcasa.set(numcasa);
//    }
//
//    public StringProperty numcasaProperty() {
//        return numcasa;
//    }
    
    
}