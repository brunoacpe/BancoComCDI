package br.com.letscode.DAO;

import br.com.letscode.Model.Usuario;

import java.io.IOException;

public interface UsuarioDAO {

    Usuario create(Usuario usuario) throws IOException;

}
