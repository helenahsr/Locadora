package Fabrica;

public class Locacao {
	private int id;
	private Cliente cliente;
	private Fita fita;
	private Funcionario funcionario;
	private String dataLocacao;
	private String dataEntrega;
	private double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Fita getFita() {
		return fita;
	}
	public void setFita(Fita fita) {
		this.fita = fita;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Locacao(int id, Cliente cliente, Fita fita, Funcionario funcionario, String dataLocacao, String dataEntrega,
			double valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fita = fita;
		this.funcionario = funcionario;
		this.dataLocacao = dataLocacao;
		this.dataEntrega = dataEntrega;
		this.valor = valor;
	}
	
	public Locacao() {
		
	}
	
	@Override
	public String toString() {
		return "Locacao [id=" + id + ", cliente=" + cliente + ", fita=" + fita + ", funcionario=" + funcionario
				+ ", dataLocacao=" + dataLocacao + ", dataEntrega=" + dataEntrega + ", valor=" + valor + "]";
	}
}
