package br.com.letscode.Factory;

import br.com.letscode.Annotations.Enums.ContaEnum;
import br.com.letscode.Annotations.TipoConta;

import javax.enterprise.util.AnnotationLiteral;

public class ContaAnnotationLiteral extends AnnotationLiteral<TipoConta> implements TipoConta {

    private final ContaEnum contaEnum;


    public ContaAnnotationLiteral(ContaEnum contaEnum) {
        this.contaEnum = contaEnum;
    }

    @Override
    public ContaEnum value() {
        return this.contaEnum;
    }
}
