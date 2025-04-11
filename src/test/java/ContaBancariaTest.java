import br.senai.entities.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unidade de testes para {@code ContaBancaria}
 */
public class ContaBancariaTest {

    /**
     * Instância de {@code ContaBancaria} para testes
     */
    private ContaBancaria conta;

    /**
     * Prepara a variável {@code conta} para os testes
     */
    @BeforeEach
    void novaConta() {
        this.conta = new ContaBancaria();
    }

    /**
     * Testa se consegue criar uma {@code ContaBancaria}
     */
    @Test
    void criaConta() {
        assertNotNull(this.conta,"Conta não deveria ser nula após criação");
    }

    /**
     * Testa se ao criar uma {@code ContaBancaria} o {@code saldo} é zerado
     */
    @Test
    void SaldoZero() {
        assertEquals(0d, this.conta.getSaldo(),"O saldo inicial deveria ser zero");
    }

    /**
     * Testa se é possível depositar $100 R$ ao criar uma {@code ContaBancaria}
     */
    @Test
    void depositar() {
        double saldo = conta.depositar(100d);
        assertEquals(100d, saldo, "O saldo deveria ser 100R$ após depositar pela primeira vez");
        assertEquals(saldo, conta.getSaldo(), "Saldo deveria ser igual ao retorno de getSaldo()");
        saldo = conta.depositar(100d);
        assertEquals(200d, saldo,"O saldo deveria ser 200R$ após depositar pela segunda vez");
        assertEquals(200, conta.getSaldo(), "O retorno de getSaldo() deveria ser 200R$ após depositar pela segunda vez");
    }

    /**
     * Testa se explode quando deposita negativo
     */
    @Test
    void depositaNegativo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,()-> {
            double saldo = conta.depositar(-100d);}
                ,"Não deveria ser possível depositar valores negativa");
        assertEquals("Valor do depósito deve sempre ser positivo.",ex.getMessage(), "Mensagem de exceção de deposito negativo não conforma com padrões");
    }


    /**
     * Testa se explode quando saca um valor negativo
     */
    @Test
    void sacarNegativo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
                    double saldo = conta.sacar(-100d);
                }
                , "Não deveria ser possível sacar valores negativa");
        assertEquals("Valor sacado deve sempre ser positivo.", ex.getMessage(), "Mensagem da exceção de saque negativo não conforma com padrões");
    }

    /**
     * Testa se explode quando saca um valor maior que o saldo
     */
    @Test
    void sacarMaior() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,()-> {
                    double saldo = conta.sacar(100d);}
                ,"Não deveria ser possível sacar valores maiores que o saldo");
        assertEquals("Valor sacado deve ser menor que o saldo.",ex.getMessage(), "Mensagem de exceção de saque maior que o valor não conforma com padrões");

    }
}
