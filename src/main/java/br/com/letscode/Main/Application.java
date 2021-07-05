package br.com.letscode.Main;
import br.com.letscode.Controller.ContaEspecial;
import br.com.letscode.Controller.ContaPoupança;
import br.com.letscode.Controller.ContaService;
import br.com.letscode.Controller.ContaSimples;
import br.com.letscode.Exceptions.CPFinexistente;
import br.com.letscode.Exceptions.SaldoInsuficienteException;
import br.com.letscode.Model.Conta;
import br.com.letscode.Model.Usuario;
import br.com.letscode.View.ContaView;
import br.com.letscode.View.UsuarioView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Getter
@Setter
public class Application {

    @Inject
    private ContaView contaView;
    @Inject
    private UsuarioView usuarioView;

    private ContaService contaService;
    private ContaEspecial contaEspecial;
    private ContaSimples contaSimples;
    private ContaPoupança contaPoupança;
    private List<Usuario> listUsuario;
    public ContaView getContaView() {
        return contaView;
    }

    @PostConstruct
    public void init(){
        this.listUsuario = new ArrayList<>();
    }
    public UsuarioView getUsuarioView(){
        return this.usuarioView;
    }

    public void adicionar(Usuario usuario){
        this.listUsuario.add(usuario);
    }

    public void linkContaUsuario(String cpf, Conta conta){
        for(int i =0; i < this.listUsuario.size();i++){
            if(this.listUsuario.get(i).getCpf().equals(cpf)){
                var usuario = this.listUsuario.get(i);
                conta.setUsuarioPai(usuario);
                var tipoConta = conta.getTipoConta();
                switch (tipoConta){
                    case "Conta Poupanca":
                        usuario.setContaPoupanca(conta);

                        break;
                    case "Conta Especial":
                        usuario.setContaEspecial(conta);

                        break;
                    case "Conta Simples":
                        usuario.setContaSimples(conta);

                        break;
                    default:
                        System.err.println("Digite um valor válido.");
                        break;
                }
            }
        }
    }

    public Usuario buscarCPF(String cpf) throws CPFinexistente {

        for(int i =0; i < this.listUsuario.size();i++){
            if(this.listUsuario.get(i).getCpf().equals(cpf)){
                return this.listUsuario.get(i);
            }
        }
        throw new CPFinexistente();
    }

    public void atualizarArquivo(Conta conta) throws IOException{
        //TODO - PROF QUANDO FOR CORRIGIR NÃO ESQUEÇA DE MUDAR O PATH PARA CONSEGUIR CRIAR FILES SE NÃO VAI DAR ERRO :D;
        var path = ".\\src\\main\\java\\br\\com\\letscode\\Files\\"+conta.getUsuarioPai().getNome()+".txt";
        try(FileWriter f = new FileWriter(path,true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter p = new PrintWriter(b);){

            p.println(conta.getTipoConta());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sistemaLogin(Usuario usuario) throws SaldoInsuficienteException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual conta você deseja acessar?");
        if(usuario.getContaSimples()!=null){
            System.out.println("1 - Conta Simples");
        }

        if(usuario.getContaEspecial()!=null){
            System.out.println("2 - Conta Especial");
        }

        if(usuario.getContaPoupanca()!=null){
            System.out.println("3 - Conta Poupança");
        }
        //TODO -- O MEU BUG DE NULLPOINTER COMEÇA NAS OPERAÇÕES ABAIXO:
        int opcaoLogin = sc.nextInt();
        switch(opcaoLogin){
            case 1:
                System.out.println("Digite o seu login: ");
                if(!sc.next().equals(usuario.getContaSimples().getLogin())){
                    System.err.println("Login não encontrado.");
                    break;
                }
                System.out.println("Digite a sua senha: ");
                if(!sc.next().equals(usuario.getContaSimples().getSenha())){
                    System.err.println("Senha errada.");
                    break;
                }
                int opcaoOpecarao;
                do{
                    System.out.println("Qual operação você deseja executar??\n 0 - Sair da conta\n 1 - Sacar\n 2 - Checar saldo\n 3 - Depositar\n");
                    opcaoOpecarao = sc.nextInt();
                    switch(opcaoOpecarao){
                        case 1:
                            //TODO -- Gerando NullPointer por algum motivo;
                            System.out.println("Digite qual o valor que você deseja sacar: ");
                            int x = sc.nextInt();
                            this.getContaSimples().saque(usuario,new BigDecimal(x),usuario.getContaSimples());
                            break;
                        case 2:
                            this.getContaSimples().saldo(usuario,usuario.getContaSimples());
                            break;
                        case 3:
                            System.out.println("Digite qual valor você deseja depositar: ");
                            this.getContaSimples().depositar(usuario,new BigDecimal(sc.next()), usuario.getContaSimples());
                            break;
                    }

                } while(opcaoOpecarao<0);
                break;
            case 2:
                System.out.println("Digite o seu login: ");
                if(!sc.next().equals(usuario.getContaEspecial().getLogin())){
                    System.err.println("Login não encontrado.");
                    break;
                }
                System.out.println("Digite a sua senha: ");
                if(!sc.next().equals(usuario.getContaEspecial().getSenha())){
                    System.err.println("Senha errada.");
                    break;
                }
                int opcaoOpecarao2;
                do{
                    System.out.println("Qual operação você deseja executar??\n 0 - Sair da conta\n1 - Sacar\n 2 - Checar saldo\n 3 - Depositar\n");
                    opcaoOpecarao2 = sc.nextInt();
                    switch(opcaoOpecarao2){
                        case 1:
                            System.out.println("Digite qual o valor que você deseja sacar: ");
                            int x = sc.nextInt();
                            this.getContaEspecial().saque(usuario,new BigDecimal(x),usuario.getContaEspecial());
                            break;
                        case 2:
                            this.getContaEspecial().saldo(usuario,usuario.getContaEspecial());
                            break;
                        case 3:
                            System.out.println("Digite qual valor você deseja depositar: ");
                            this.getContaEspecial().depositar(usuario,new BigDecimal(sc.next()), usuario.getContaEspecial());
                    }

                } while(opcaoOpecarao2<0);
                break;
            case 3:

                System.out.println("Digite o seu login: ");
                if(!sc.next().equals(usuario.getContaPoupanca().getLogin())){
                    System.err.println("Login não encontrado.");
                    break;
                }
                System.out.println("Digite a sua senha: ");
                if(!sc.next().equals(usuario.getContaPoupanca().getSenha())){
                    System.err.println("Senha errada.");
                    break;
                }
                int opcaoOpecarao3;
                do{
                    System.out.println("Qual operação você deseja executar??\n 0 - Sair da conta\n1 - Sacar\n 2 - Checar saldo\n 3 - Depositar\n");
                    opcaoOpecarao3 = sc.nextInt();
                    switch(opcaoOpecarao3){
                        case 1:
                            System.out.println("Digite qual o valor que você deseja sacar: ");
                            int x = sc.nextInt();
                            this.getContaPoupança().saque(usuario,new BigDecimal(x),usuario.getContaPoupanca());
                            break;
                        case 2:
                            this.getContaPoupança().saldo(usuario,usuario.getContaPoupanca());
                            break;
                        case 3:
                            System.out.println("Digite qual valor você deseja depositar: ");
                            this.getContaPoupança().depositar(usuario,new BigDecimal(sc.next()), usuario.getContaPoupanca());
                    }

                } while(opcaoOpecarao3<0);
                break;
        }
    }

}
