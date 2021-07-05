package br.com.letscode.Controller;

import br.com.letscode.Model.Usuario;

import java.io.IOException;

public interface UsuarioServices {

    Usuario criarUsuario(Usuario usuario) throws IOException;

}
