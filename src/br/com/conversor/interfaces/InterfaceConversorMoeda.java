package src.br.com.conversor.interfaces;

public interface InterfaceConversorMoeda {
    double converter(double valor, double taxaConversao, String moedaOrigem, String moedaDestino);
}