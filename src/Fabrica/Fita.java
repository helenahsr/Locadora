package Fabrica;

public class Fita {
	private int id;
	private String nome;
	private String genero;
	private int duracaoMinutos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	
	public Fita(int id, String nome, String genero, int duracaoMinutos) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.duracaoMinutos = duracaoMinutos;
	}
	
	public Fita() {
		
	}
	
	@Override
	public String toString() {
		return "Fita [id=" + id + ", nome=" + nome + ", genero=" + genero + ", duracaoMinutos=" + duracaoMinutos + "]";
	}
}
