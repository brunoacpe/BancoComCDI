package br.com.letscode.Model;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Usuario {

    private String cpf;
    private String nome;
    private int idade;
    private String email;
    private Conta contaSimples;
    private Conta contaPoupanca;
    private Conta contaEspecial;



    public Usuario() {
    }

    public Usuario(String nome, int idade, String email,String cpf){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Usuario;
    }



}
