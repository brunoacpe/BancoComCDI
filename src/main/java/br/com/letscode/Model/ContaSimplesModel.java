package br.com.letscode.Model;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ContaSimplesModel extends Conta{
    public ContaSimplesModel(){

    }
    public ContaSimplesModel(BigDecimal saldo, String login, String senha){
        super(saldo,login,senha);
        this.setTipoConta("Conta Simples");
    }

}
