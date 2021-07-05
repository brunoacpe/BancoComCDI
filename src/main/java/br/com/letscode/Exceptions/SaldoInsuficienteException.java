package br.com.letscode.Exceptions;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(){
        System.err.println("Saldo insuficiente.");
    }
}
