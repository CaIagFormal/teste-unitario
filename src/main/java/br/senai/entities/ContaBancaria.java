package br.senai.entities;

/**
 * Representa uma conta bancária e permite sacar,
 * depositar e verficar o {@code saldo}.
 */
public class ContaBancaria {
    /**
     * Valor monetário atual da {@code ContaBancária} em R$
     */
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0d;
    }

    /**
     * @return {@code saldo} da conta (double)
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Saca um {@code valor} no {@code saldo}
     * @param valor valor positivo em R$ sacado
     * @return {@code saldo} da conta após transação (double)
     */
    public double sacar(double valor) {
        if (valor<0) {
            throw new IllegalArgumentException("Valor sacado deve sempre ser positivo.");
        } else if (valor>saldo) {
            throw new IllegalArgumentException("Valor sacado deve ser menor que o saldo.");
        }
        this.saldo -= valor;
        return getSaldo();
    }

    /**
     * Deposita um {@code valor} no {@code saldo}
     * @param valor valor positivo em R$ depositado
     * @return {@code saldo} da conta após transação (double)
     */
    public double depositar(double valor) {
        if (valor<0) {
            throw new IllegalArgumentException("Valor do depósito deve sempre ser positivo.");
        }
        this.saldo += valor;
        return getSaldo();
    }
}
