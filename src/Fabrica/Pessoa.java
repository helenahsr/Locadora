package Fabrica;

public class Pessoa {
	String nome;
	String rg;
	String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Pessoa(String nome, String rg, String cpf) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
	}
	
	public Pessoa() {
		
	}
}
