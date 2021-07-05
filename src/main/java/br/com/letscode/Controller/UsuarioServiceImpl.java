package br.com.letscode.Controller;
import br.com.letscode.DAO.UsuarioDAOimpl;
import br.com.letscode.Model.Usuario;
import javax.inject.Inject;
import java.io.IOException;

public class UsuarioServiceImpl implements UsuarioServices {

    @Inject
    private UsuarioDAOimpl usuarioDAOimpl;

    public UsuarioDAOimpl getUsuarioDAOimpl(){
        return this.usuarioDAOimpl;
    }
    @Override

    public Usuario criarUsuario(Usuario usuario) throws IOException {
        System.out.println("Usuario criado com sucesso !!!");
        return this.getUsuarioDAOimpl().create(usuario);
    }

}
