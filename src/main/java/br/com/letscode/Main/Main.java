package br.com.letscode.Main;

import br.com.letscode.Exceptions.CPFinexistente;
import br.com.letscode.Exceptions.SaldoInsuficienteException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, CPFinexistente, SaldoInsuficienteException {

        WeldContainer container = new Weld().initialize();
        final Application application = container.select(Application.class).get();
        init(application);
    }

    public static void init(Application aplicacao) throws IOException, CPFinexistente, SaldoInsuficienteException {
        int opcao = 0;
        System.out.println("Bem vindo.");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Oque gostaria de fazer? \n 1- Cadastrar usuario \n 2- Criar conta \n 3 - Fazer login em alguma conta \n 0 - Sair");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao, aplicacao);
        } while (opcao > 0);
    }

    private static void definirOpcao(Scanner sc, int opcao, Application aplicacao) throws IOException, CPFinexistente, SaldoInsuficienteException {

        switch (opcao) {
            case 1:
                var usuario= aplicacao.getUsuarioView().Create(sc);
                aplicacao.adicionar(usuario);
                break;
            case 2:
                System.out.println("Digite o seu cpf para associar a conta:  ");
                var cpf = sc.next();
                var conta = aplicacao.getContaView().criarConta(sc);
                System.out.println("Qual sera o login da sua conta?: ");
                conta.setLogin(sc.next());
                System.out.println("Qual sera a senha da sua conta?: ");
                conta.setSenha(sc.next());
                aplicacao.linkContaUsuario(cpf, conta);
                aplicacao.atualizarArquivo(conta);
                break;
            case 3:
                System.out.println("Digite o seu CPF para fazer o login:  ");
                var usuarioAutenticado = aplicacao.buscarCPF(sc.next());
                aplicacao.sistemaLogin(usuarioAutenticado);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Digite um valor válido.");
                break;
        }
    }


}
