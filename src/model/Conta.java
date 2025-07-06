package model;

public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		cliente.calcularLimites(saldo);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		cliente.calcularLimites(saldo);
	}

	@Override
	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
	}

	public void imprimirLimites() {
		System.out.printf("Limite Cheque Especial: R$ %.2f\n", cliente.getLimiteChequeEspecial());
		System.out.printf("Empréstimo Pré-Aprovado: R$ %.2f\n", cliente.getEmprestimoPreAprovado());
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s\n", cliente.getNome());
		System.out.printf("Agência: %d\n", agencia);
		System.out.printf("Número: %d\n", numero);
		System.out.printf("Saldo: R$ %.2f\n", saldo);
	}
}
