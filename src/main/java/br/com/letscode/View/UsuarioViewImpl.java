package br.com.letscode.View;

import br.com.letscode.Controller.UsuarioServices;
import br.com.letscode.Main.Application;
import br.com.letscode.Model.Usuario;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView{

    @Inject
    private UsuarioServices usuarioServices;

    public UsuarioServices getUsuarioServices() {
        return usuarioServices;
    }

    @Override
    public Usuario Create(Scanner sc) throws IOException {
        Usuario usuario = new Usuario();
        System.out.println("Digite seu nome: ");
        usuario.setNome(sc.next());
        System.out.println("Digite o seu CPF: ");
        usuario.setCpf(sc.next());
        System.out.println("Digite sua idade: ");
        usuario.setIdade(sc.nextInt());
        System.out.println("Digite o seu email: ");
        usuario.setEmail(sc.next());
        System.out.printf("Usuario %s criado.\n",usuario.getNome());
        return usuarioServices.criarUsuario(usuario);
    }

    @Override
    public Usuario getUsuario(String nome) {
        return null;
    }

}
