package model;


import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public Banco(String nome) {
		this.nome = nome;
	}

	public void addConta(Conta conta) {
		contas.add(conta);
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public List<Conta> getContas() {
		return contas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Conta buscarContaPorNumero(int numero) {
		return contas.stream().filter(c -> c.getNumero() == numero).findFirst().orElse(null);
	}

	public void imprimirCarteiraClientes(String usuario, String senha) {
		if ("admin".equals(usuario) && "1234".equals(senha)) {
			System.out.println("--- Carteira de Clientes ---");
			for (Cliente cliente : clientes) {
				System.out.println("Nome: " + cliente.getNome());
			}
		} else {
			System.out.println("Acesso negado.");
		}
	}
}

