package br.com.letscode.DAO;
import br.com.letscode.Model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;



public class UsuarioDAOimpl implements UsuarioDAO {

    @Override
    public Usuario create(Usuario usuario) throws IOException {
        var path = ".\\src\\main\\java\\br\\com\\letscode\\Files\\"+usuario.getNome()+".txt";
        PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);
        writer.println("Dados do usuario");
        writer.println("Nome do usuario: "+ usuario.getNome());
        writer.println("Idade: " + usuario.getIdade());
        writer.println("Email: " + usuario.getEmail());
        writer.println("Cpf: "+ usuario.getCpf());
        writer.println("Contas do usuário: ");
        writer.close();
        return usuario;
    }

}
