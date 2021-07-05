package br.com.letscode.View;

import br.com.letscode.Model.Usuario;

import java.io.IOException;
import java.util.Scanner;

public interface UsuarioView {

    Usuario Create(Scanner sc) throws IOException;
    Usuario getUsuario(String nome);

}
