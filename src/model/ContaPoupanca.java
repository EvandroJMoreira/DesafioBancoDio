package model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato(double valor) {
		System.out.println("*** Extrato Conta Poupan�a ***");
		super.imprimirInfosComuns();
	}
}

