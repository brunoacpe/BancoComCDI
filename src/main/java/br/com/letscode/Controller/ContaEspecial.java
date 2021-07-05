package br.com.letscode.Controller;


import br.com.letscode.Annotations.Enums.ContaEnum;
import br.com.letscode.Annotations.TipoConta;
import br.com.letscode.Model.Conta;
import br.com.letscode.Model.Usuario;

import java.io.IOException;
import java.math.BigDecimal;

@TipoConta(value = ContaEnum.ESPECIAL)
public class ContaEspecial implements ContaService {
    @Override
    public Conta criarConta(Conta conta) throws IOException {
        //TODO- O services não esta reconhecendo o tipo de conta no Model :( por isso não preenchi o especial;
        conta.setTipoConta("Conta Especial");
        return conta;
    }

    @Override
    public void depositar(Usuario usuario, BigDecimal valor, Conta conta) {

    }

    @Override
    public void saque(Usuario usuario, BigDecimal valor, Conta conta) {

    }

    @Override
    public void saldo(Usuario usuario, Conta conta){
        System.out.println(conta.getSaldo() + " R$");
    }
}

