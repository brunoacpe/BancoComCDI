package br.com.letscode.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaEspecialModel extends Conta{
    private BigDecimal limite;
    public ContaEspecialModel(){

    }
    public ContaEspecialModel(BigDecimal saldo, String login, String senha){
        super(saldo, login, senha);
        this.setTipoConta("Conta Especial");
        this.setLimite(new BigDecimal(200));
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
