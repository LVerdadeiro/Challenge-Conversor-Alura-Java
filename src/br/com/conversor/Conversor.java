package src.br.com.conversor;

import src.br.com.conversor.interfaces.InterfaceConversorMoeda;
import src.br.com.conversor.modelos.ServicoTaxaCambio;
import src.br.com.conversor.exceptions.ApiException;

public class Conversor implements InterfaceConversorMoeda {

    private final ServicoTaxaCambio servicoTaxaCambio;

    public Conversor() {
        this.servicoTaxaCambio = new ServicoTaxaCambio();
    }

    @Override
    public double converter(double valor, double taxaConversao, String moedaOrigem, String moedaDestino) {
        System.out.printf("Convertendo %.2f %s para %s...%n", valor, moedaOrigem, moedaDestino);
        return valor * taxaConversao;
    }

    public double converterComTaxaApi(double valor, String moedaOrigem, String moedaDestino) throws ApiException {
        double taxa = servicoTaxaCambio.getTaxaDeCambio(moedaOrigem, moedaDestino);
        return converter(valor, taxa, moedaOrigem, moedaDestino);
    }
}