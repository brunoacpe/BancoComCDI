package br.com.letscode.View;

import br.com.letscode.Model.Conta;

import java.io.IOException;
import java.util.Scanner;

public interface ContaView {

    Conta criarConta(Scanner sc) throws IOException;
}
