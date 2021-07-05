package br.com.letscode.View;

import br.com.letscode.Annotations.Enums.ContaEnum;
import br.com.letscode.Factory.ContaFactory;
import br.com.letscode.Model.Conta;
import br.com.letscode.Model.ContaEspecialModel;
import br.com.letscode.Model.ContaPoupancaModel;
import br.com.letscode.Model.ContaSimplesModel;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class ContaViewImpl implements ContaView{
    @Inject
    private ContaFactory contaFactory;
    public ContaFactory getContaFactory() {
        return contaFactory;
    }

    @Override
    public Conta criarConta(Scanner sc) throws IOException {
        var conta = new Conta();
        System.out.println("Qual o tipo de conta que você deseja criar?\n 1 - Conta especial \n 2 - Conta Poupança\n 3 - Conta Simples\n 0 - Voltar");
        int opcaoConta = sc.nextInt();
        ContaEnum contaEnum = null;
        switch (opcaoConta){
            case 1:
                contaEnum = ContaEnum.ESPECIAL;
                break;
            case 2:
                contaEnum = ContaEnum.POUPANCA;
                break;
            case 3:
                contaEnum = ContaEnum.NORMAL;
                break;
            default:
                System.err.println("Digite um valor válido.");
                break;
        }
        var contaServiceE =  contaFactory.create(contaEnum);
        return contaServiceE.criarConta(conta);

    }
}
