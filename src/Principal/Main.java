package Principal;
import Fabrica.Cliente;
import Fabrica.Fita;
import Fabrica.Funcionario;
import Fabrica.Locacao;
import Fabrica.Pessoa;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	private List<Cliente> clientes = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Fita> fitas = new ArrayList<>();
    private List<Locacao> locacoes = new ArrayList<>();
    
    int registroCliente = 0;
    int registroFuncionario = 0;
    int idLocacao = 0;
    int idFita = 0;
 
    
    
	public static void main(String[] args) {
		Main sistema = new Main();
        sistema.menu();
	}
	
	private void menu() {
		Cliente cli = new Cliente("Helena","123","312",1,"12/10",3);
		clientes.add(cli);
		cli = new Cliente("Brenda","123","312",1,"12/10",7);
		clientes.add(cli);
		cli = new Cliente("Hellen","123","312",1,"12/10",4);
		clientes.add(cli);
		cli = new Cliente("Alexandre","123","312",1,"12/10",2);
		clientes.add(cli);
		
		Funcionario func = new Funcionario("Gustavo", "321", "123", 1, 1500, 9);
		funcionarios.add(func);
		func = new Funcionario("José", "321", "123", 1, 1500, 7);
		funcionarios.add(func);
		func = new Funcionario("Hedu", "321", "123", 1, 1500, 4);
		funcionarios.add(func);
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Cadastrar Cliente\n" +
                    "2 - Cadastrar Funcionário\n" +
                    "3 - Cadastrar Fita\n" +
                    "4 - Cadastrar Locação\n" +
                    "5 - Total de locações\n" +
                    "6 - Ranking de Locações\n" +
                    "7 - Total faturamento\n"+ 
                    "8 - Quantidade de cada cadastro\n" +
                    "9 - Funcionário com mais locações\n" +
                    "10 - Buscar\n" +
                    "0 - Sair"
            ));

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarFita();
                    break;
                case 4:
                    cadastrarLocacao();
                    break;
                case 5:
                	totalLocacoes();
                	break;
                case 6:
                    rankingLocacoes();
                    break;
                case 7: 
                	totalFaturamento();
                	break;
                case 8:
                	quantidadeCadastros();
                	break;
                case 9:
                	rankingFuncionarios();
                	break;
                case 10:
                	busca();
                	break;
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
    	String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        String rg = JOptionPane.showInputDialog("Digite o RG do cliente:");
        String dataCadastro = JOptionPane.showInputDialog("Digite a data do cadastro do cliente:");
        registroCliente++;
        Cliente cliente = new Cliente(nome, cpf, rg, registroCliente, dataCadastro, 0);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }
    
    private void cadastrarFuncionario() {
    	String nome = JOptionPane.showInputDialog("Digite o nome do funcionario:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do funcionario:");
        String rg = JOptionPane.showInputDialog("Digite o RG do funcionario:");
        registroFuncionario++;        
        Funcionario funcionario = new Funcionario(nome, cpf, rg, registroFuncionario, 1500, 0);
        funcionarios.add(funcionario);

        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
    }
    
    private void cadastrarFita() {
    	idFita++;
    	String nome = JOptionPane.showInputDialog("Digite o nome da fita:");
    	String genero = JOptionPane.showInputDialog("Digite o genêro da fita:");
    	int duracaoMinutos = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração da fita em minutos:"));
    	
    	Fita fita = new Fita(idFita, nome, genero, duracaoMinutos);
    	
    	fitas.add(fita);
    	
    	JOptionPane.showMessageDialog(null, "Fita cadastrada com sucesso!");
    }
    
    private void cadastrarLocacao() {
    	Cliente clienteLocacao = new Cliente("", "", "", 0, "", 0);
    	Fita fitaLocacao = new Fita(0, "", "", 0);
    	Funcionario funcionarioLocacao = new Funcionario("", "", "", 0, 0, 0);
    	idLocacao++;
    	String clienteAtual = JOptionPane.showInputDialog("Digite qual cliente irá fazer a locação:");
    	for (Cliente c : clientes) {
			if(c.getNome().contains(clienteAtual) == true)
			{
				clienteLocacao = new Cliente(c.getNome(), c.getCpf(), c.getRg(), c.getRegistroCliente(), c.getDataCadastro(), c.getQtdLocacao() + 1);
				c.setQtdLocacao(c.getQtdLocacao() + 1);
				break;
			}
		}
    	String fitaAtual = JOptionPane.showInputDialog("Digite o nome da fita escolhida: ");
    	for (Fita fi : fitas) {
			if(fi.getNome().contains(fitaAtual) == true)
			{
				fitaLocacao = new Fita(fi.getId(), fi.getNome(), fi.getGenero(), fi.getDuracaoMinutos());	
				break;
			}
		}
    	String funcionarioAtual = JOptionPane.showInputDialog("Digite qual funcionario será o responsável pela locação:");
    	for (Funcionario f : funcionarios) {
			if(f.getNome().contains(funcionarioAtual) == true)
			{
				funcionarioLocacao = new Funcionario(f.getNome(), f.getCpf(), f.getRg(), f.getRegistroFuncionario(), f.getSalario() + 20, f.getQtdLocacoes() + 1);
				f.setQtdLocacoes(f.getQtdLocacoes() + 1);
				break;
			}
		}
    	String dataLocacao = JOptionPane.showInputDialog("Digite a data da locação:");
    	String dataEntrega = JOptionPane.showInputDialog("Digite a data de entrega da fita:");
    	double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor desta locação:"));
    	Locacao locacao = new Locacao(idLocacao, clienteLocacao, fitaLocacao, funcionarioLocacao, dataLocacao, dataEntrega, valor);
    	locacoes.add(locacao);
    	JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso!");
    }
    
    private void rankingLocacoes() {    
    	int tamanho = 0;
    	tamanho = clientes.size();
    	int i = 0;
    	String rankingTexto = "";
        String[] ranking = new String[tamanho];
        for(Cliente c : clientes) 
        {
        	ranking[i] = c.getNome() + " - " + c.getQtdLocacao(); 
        	i++;
        }
        Arrays.sort(ranking, new Comparator<String>() {
            @Override
            public int compare(String cliente1, String cliente2) {
                int indiceHifen1 = cliente1.indexOf('-');
                int indiceHifen2 = cliente2.indexOf('-');

                int numero1 = Integer.parseInt(cliente1.substring(indiceHifen1 + 2));
                int numero2 = Integer.parseInt(cliente2.substring(indiceHifen2 + 2));

                return Integer.compare(numero2, numero1);
            }
        });
        
        for(String rank : ranking)
        {
        	rankingTexto += rank + "\n"; 
        }

        JOptionPane.showMessageDialog(null, "Ranking de locações:\n" + rankingTexto);
    }
    
    private void rankingFuncionarios() {    
    	int tamanho = 0;
    	tamanho = funcionarios.size();
    	int i = 0;
        String[] ranking = new String[tamanho];
        for(Funcionario f : funcionarios) 
        {
        	ranking[i] = f.getNome() + " - " + f.getQtdLocacoes(); 
        	i++;
        }
        Arrays.sort(ranking, new Comparator<String>() {
            @Override
            public int compare(String funcionario1, String funcionario2) {
                int indiceHifen1 = funcionario1.indexOf('-');
                int indiceHifen2 = funcionario2.indexOf('-');

                int numero1 = Integer.parseInt(funcionario1.substring(indiceHifen1 + 2));
                int numero2 = Integer.parseInt(funcionario2.substring(indiceHifen2 + 2));

                return Integer.compare(numero2, numero1);
            }
        });
     

        JOptionPane.showMessageDialog(null, "Ranking de locações:\n" + ranking[0] + " locações.");
    }
    
    private void busca() {
    	int opcaoBuscar = Integer.parseInt(JOptionPane.showInputDialog("O que deseja buscar?\n"
    			+ "1 - Cliente\n"
    			+ "2 - Funcionario\n"
    			+ "3 - Fita\n"
    			+ "4 - Voltar"));
    	switch(opcaoBuscar) {
    		case 1:
    			String itemBusca = "";
				String busca = ""; 
				int contagem = 0;
				busca = JOptionPane.showInputDialog("Digite o nome do cliente que deseja procurar: ");
				
				for (Cliente c : clientes) {
					if(c.getNome().contains(busca) == true)
					{
						itemBusca = "Index: " + contagem  + " | Nome: " + c.getNome() + " | CPF: " + c.getCpf() + " | RG: " + c.getRg() + " | Registro: " + c.getRegistroCliente() + " | Data do Cadastro: " + c.getDataCadastro() + " | Quantidade de Locações: " + c.getQtdLocacao() + "\n";
					}
					contagem++;
				}
				
				if(itemBusca != "")
				{
					JOptionPane.showMessageDialog(null, "Exibindo cliente da busca\n" + itemBusca);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
				}
    			break;
    		case 2:
    			String itemBuscaF = "";
				String buscaF = ""; 
				int contagemF = 0;
				buscaF = JOptionPane.showInputDialog("Digite o nome do funcionario que deseja procurar: ");
				
				for (Funcionario f : funcionarios) {
					if(f.getNome().contains(buscaF) == true)
					{
						itemBuscaF = "Index: " + contagemF  + " | Nome: " + f.getNome() + " | CPF: " + f.getCpf() + " | RG: " + f.getRg() + " | Registro: " + f.getRegistroFuncionario() + " | Salário atual: " + f.calculaSalarioFuncionario() + " | Quantidade de Locações: " + f.getQtdLocacoes() + "\n";
					}
					contagemF++;
				}
				
				if(itemBuscaF != "")
				{
					JOptionPane.showMessageDialog(null, "Exibindo funcionario da busca\n" + itemBuscaF);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
				}
    			break;
    		case 3:
    			String itemBuscaFi = "";
				String buscaFi = ""; 
				buscaFi = JOptionPane.showInputDialog("Digite o nome da fita que deseja procurar: ");
				
				for (Fita fi : fitas) {
					if(fi.getNome().contains(buscaFi) == true)
					{
						itemBuscaFi = "Id: " + fi.getId()  + " | Nome: " + fi.getNome() + " | Genêro: " + fi.getGenero() + " | Duração em Minutos: " + fi.getDuracaoMinutos() + "\n";
					}
				}
				
				if(itemBuscaFi != "")
				{
					JOptionPane.showMessageDialog(null, "Exibindo fita da busca\n" + itemBuscaFi);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Fita não encontrada!");
				}
    			break;
    		default:
    			JOptionPane.showMessageDialog(null, "Saindo da busca...");
    			break;
    	}
    }
    
    private void totalFaturamento() {
		double total = 0.0;
    	for(Locacao l : locacoes) 
    	{
    		total += l.getValor();
    	}
    	JOptionPane.showMessageDialog(null, "O total de faturamento da locadora é: R$" + total);
	}
    
    private void quantidadeCadastros() {
    	int quantClientes = 0, quantFuncionarios = 0, quantFitas = 0;
    	quantClientes = clientes.size();
    	quantFuncionarios = funcionarios.size();
    	quantFitas = fitas.size();
    	
    	JOptionPane.showMessageDialog(null, "Total de cadastros\n\n"
    			+ "Quantidade de clientes cadastrados: " + quantClientes +
    			"\nQuantidade de funcionários cadastrados: " + quantFuncionarios +
    			"\nQuantidade de fitas cadastradas: " + quantFitas);
    }
    
    private void totalLocacoes() {
		int total = 0;
    	for(Cliente c : clientes) 
    	{
    		total += c.getQtdLocacao();
    	}
    	JOptionPane.showMessageDialog(null, "O total de locações da locadora é de " + total + " locações.");
	}
}
