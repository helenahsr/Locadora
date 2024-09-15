package Fabrica;

public class Cliente extends Pessoa {
	private int registroCliente;
	private String dataCadastro;
	private int qtdLocacao;
	
	public int getRegistroCliente() {
		return registroCliente;
	}
	public void setRegistroCliente(int registroCliente) {
		this.registroCliente = registroCliente;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public int getQtdLocacao() {
		return qtdLocacao;
	}
	public void setQtdLocacao(int qtdLocacao) {
		this.qtdLocacao = qtdLocacao;
	}
	
	public Cliente(String nome, String cpf, String rg, int registroCliente, String dataCadastro, int qtdLocacao) {
		super(nome, cpf, rg);
		this.registroCliente = registroCliente;
		this.dataCadastro = dataCadastro;
		this.qtdLocacao = qtdLocacao;
	}
	
	public Cliente() {
		
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "cpf=" + cpf + "rg=" + rg +  "registroCliente=" + registroCliente + ", dataCadastro=" + dataCadastro + ", qtdLocacao="
				+ qtdLocacao + "]";
	}
}
