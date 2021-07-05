package br.com.letscode.Controller;

import br.com.letscode.Annotations.Enums.ContaEnum;
import br.com.letscode.Annotations.TipoConta;
import br.com.letscode.Exceptions.SaldoInsuficienteException;
import br.com.letscode.Model.Conta;
import br.com.letscode.Model.Usuario;
import java.math.BigDecimal;

@TipoConta(value = ContaEnum.POUPANCA)
public class ContaPoupança implements ContaService {

    @Override
    public Conta criarConta(Conta conta){
        conta.setTipoConta("Conta Poupanca");
        conta.setSaldo(new BigDecimal("100.00"));
        return conta;
    }

    @Override
    public void depositar(Usuario usuario, BigDecimal valor, Conta conta) {
        var taxa = new BigDecimal("0.07");
        conta.setSaldo(conta.getSaldo().subtract(conta.getSaldo().multiply(taxa)));
        conta.setSaldo(conta.getSaldo().add(valor));
    }

    @Override
    public void saque(Usuario usuario, BigDecimal valor, Conta conta) throws SaldoInsuficienteException {
        if(conta.getSaldo().compareTo(valor)==-1){
            throw new SaldoInsuficienteException();
        }
        var taxa = new BigDecimal("0.07");
        conta.setSaldo(conta.getSaldo().subtract(conta.getSaldo().multiply(taxa)));
        conta.setSaldo(conta.getSaldo().subtract(valor));
    }

    @Override
    public void saldo(Usuario usuario, Conta conta) {
        System.out.println(conta.getSaldo() + " R$");
    }
}

