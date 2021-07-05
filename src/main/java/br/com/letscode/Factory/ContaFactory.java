package br.com.letscode.Factory;

import br.com.letscode.Annotations.Enums.ContaEnum;
import br.com.letscode.Controller.ContaService;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class ContaFactory {

    @Inject
    @Any
    private Instance<ContaService> contaServiceInstance;
    public ContaService create(final ContaEnum contaEnum){
        final ContaAnnotationLiteral literal = new ContaAnnotationLiteral(contaEnum);
        return this.contaServiceInstance.select(literal).get();
    }
}
