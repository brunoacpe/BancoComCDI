package br.com.letscode.Model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaPoupancaModel extends Conta{


    public ContaPoupancaModel(){

    }
    public ContaPoupancaModel(BigDecimal saldo, String login, String senha){
        super(saldo, login, senha);
        this.setTipoConta("Conta Poupanca");
    }


}
