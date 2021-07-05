package br.com.letscode.Exceptions;

public class CPFinexistente extends Throwable{

    public CPFinexistente(){
        System.err.println("Não existe nenhum usuário cadastrado com este CPF.");
    }
}
