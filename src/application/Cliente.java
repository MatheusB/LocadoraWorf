package application;


public class Cliente{


	private String nome;
	private String sobrenome;
	private String email;
	private String rua;
	private String bairro;
	private String numcasa;
	
	public Cliente (String nome,String sobrenome,String email,String rua,String bairro, String numcasa){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.rua = rua;
		this.bairro = bairro;
		this.numcasa = numcasa;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumcasa() {
		return numcasa;
	}

	public void setNumcasa(String numcasa) {
		this.numcasa = numcasa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}