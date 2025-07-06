package service;

import model.Conta;

public class ContaService {

	public void sacar(Conta conta, double valor) {
		if (conta.getSaldo() >= valor) {
			conta.sacar(valor);
			System.out.println("Saque realizado.");
		} else {
			double limite = conta.getCliente().getLimiteChequeEspecial();
			double total = conta.getSaldo() + limite;
			if (total >= valor) {
				double usoCheque = valor - conta.getSaldo();
				double taxa = usoCheque * 0.10;
				conta.sacar(conta.getSaldo() + usoCheque + taxa);
				System.out.printf("Usou cheque especial: R$ %.2f com taxa R$ %.2f\n", usoCheque, taxa);
			} else {
				System.out.println("Saque negado. Saldo insuficiente.");
			}
		}
	}

	public void depositar(Conta conta, double valor) {
		conta.depositar(valor);
		System.out.println("Depósito realizado.");
	}

	public void transferir(Conta origem, Conta destino, double valor) {
		origem.transferir(valor, destino);
		System.out.println("Transferência realizada.");
	}
}
