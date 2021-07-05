package br.com.letscode.Controller;
import br.com.letscode.Exceptions.SaldoInsuficienteException;
import br.com.letscode.Model.Conta;
import br.com.letscode.Model.Usuario;
import java.io.IOException;
import java.math.BigDecimal;

public interface ContaService {
    Conta criarConta(Conta conta) throws IOException;

    void depositar(Usuario usuario, BigDecimal valor, Conta conta) ;

    void saque(Usuario usuario, BigDecimal valor, Conta conta) throws SaldoInsuficienteException;

    void saldo(Usuario usuario, Conta conta);
}
