package br.com.letscode.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;



@Getter
@Setter
public class Conta {

    private BigDecimal saldo;
    private String login;
    private String senha;
    private String tipoConta;
    private Usuario usuarioPai;

    public Conta() {

    }

    public Conta(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Conta(BigDecimal saldo, String login, String senha) {
        this.saldo = saldo;
        this.login = login;
        this.senha = senha;
    }
}
