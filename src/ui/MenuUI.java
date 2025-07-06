package ui;

import model.*;
import service.ContaService;

import java.util.Scanner;

public class MenuUI {
	private Scanner sc = new Scanner(System.in);
	private Banco banco;
	private ContaService contaService = new ContaService();

	public MenuUI(Banco banco) {
		this.banco = banco;
	}

	public void iniciar() {
		boolean sair = false;
		while (!sair) {
			System.out.println("\n--- MENU PRINCIPAL ---");
			System.out.println("1. Abrir Conta Corrente");
			System.out.println("2. Abrir Conta Poupança");
			System.out.println("3. Acessar Conta");
			System.out.println("4. Ver Carteira de Clientes (admin)");
			System.out.println("5. Sair");

			int op = sc.nextInt();
			sc.nextLine();

			switch (op) {
				case 1 -> abrirConta(true);
				case 2 -> abrirConta(false);
				case 3 -> acessarConta();
				case 4 -> {
					System.out.print("Usuário: ");
					String user = sc.nextLine();
					System.out.print("Senha: ");
					String pass = sc.nextLine();
					banco.imprimirCarteiraClientes(user, pass);
				}
				case 5 -> sair = true;
				default -> System.out.println("Opção inválida.");
			}
		}
	}

	private void abrirConta(boolean corrente) {
		System.out.print("Nome do cliente: ");
		String nome = sc.nextLine();
		System.out.print("Depósito inicial: ");
		double valor = sc.nextDouble();
		sc.nextLine();

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.calcularLimites(valor);

		Conta conta = corrente ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);
		conta.depositar(valor);

		banco.addCliente(cliente);
		banco.addConta(conta);

		System.out.println("Conta criada com sucesso! Nº: " + conta.getNumero());
	}

	private void acessarConta() {
		System.out.print("Número da conta: ");
		int numero = sc.nextInt();
		sc.nextLine();

		Conta conta = banco.buscarContaPorNumero(numero);
		if (conta == null) {
			System.out.println("Conta não encontrada.");
			return;
		}

		boolean voltar = false;
		while (!voltar) {
			System.out.println("\n--- MENU CONTA ---");
			System.out.println("1. Extrato");
			System.out.println("2. Depósito");
			System.out.println("3. Saque");
			System.out.println("4. Transferência");
			System.out.println("5. Limites");
			System.out.println("6. Voltar");

			int op = sc.nextInt();
			sc.nextLine();

			switch (op) {
				case 1 -> conta.imprimirExtrato(0);
				case 2 -> {
					System.out.print("Valor: ");
					double v = sc.nextDouble();
					sc.nextLine();
					contaService.depositar(conta, v);
				}
				case 3 -> {
					System.out.print("Valor: ");
					double v = sc.nextDouble();
					sc.nextLine();
					contaService.sacar(conta, v);
				}
				case 4 -> {
					System.out.print("Conta destino: ");
					int destinoNum = sc.nextInt();
					System.out.print("Valor: ");
					double valor = sc.nextDouble();
					sc.nextLine();
					Conta destino = banco.buscarContaPorNumero(destinoNum);
					if (destino != null)
						contaService.transferir(conta, destino, valor);
					else
						System.out.println("Conta destino não encontrada.");
				}
				case 5 -> conta.imprimirLimites();
				case 6 -> voltar = true;
				default -> System.out.println("Opção inválida.");
			}
		}
	}
}
