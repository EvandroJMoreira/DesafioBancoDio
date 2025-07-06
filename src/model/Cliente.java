package model;

public class Cliente {
	private String nome;
	private double limiteChequeEspecial;
	private double emprestimoPreAprovado;

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public double getLimiteChequeEspecial() { return limiteChequeEspecial; }
	public double getEmprestimoPreAprovado() { return emprestimoPreAprovado; }

	public void calcularLimites(double saldo) {
		if (saldo <= 500) {
			limiteChequeEspecial = saldo * 0.2;
			emprestimoPreAprovado = 0;
		} else if (saldo <= 2000) {
			limiteChequeEspecial = saldo * 0.4;
			emprestimoPreAprovado = saldo * 0.6;
		} else {
			limiteChequeEspecial = saldo * 0.5;
			emprestimoPreAprovado = saldo * 0.75;
		}
	}
}

