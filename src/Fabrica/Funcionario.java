package Fabrica;

public class Funcionario extends Pessoa {
	private int registroFuncionario;
	private double salario;
	private int qtdLocacoes;
	
	public int getRegistroFuncionario() {
		return registroFuncionario;
	}
	public void setRegistroFuncionario(int registroFuncionario) {
		this.registroFuncionario = registroFuncionario;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getQtdLocacoes() {
		return qtdLocacoes;
	}
	public void setQtdLocacoes(int qtdLocacoes) {
		this.qtdLocacoes = qtdLocacoes;
	}
	
	public Funcionario(String nome, String cpf, String rg, int registroFuncionario, double salario, int qtdLocacoes) {
		super(nome, cpf, rg);
		this.registroFuncionario = registroFuncionario;
		this.salario = salario;
		this.qtdLocacoes = qtdLocacoes;
	}
	
	public Funcionario() {
		
	}
	
	@Override
	public String toString() {
		return "Funcionario nome=" + nome + "cpf=" + cpf + "rg=" + rg + "registroFuncionario=" + registroFuncionario + ", salario=" + salario + ", qtdLocacoes="
				+ qtdLocacoes + "]";
	}
	
	public double calculaSalarioFuncionario() {
		return this.salario + (this.qtdLocacoes * 20);
	}
	
}
