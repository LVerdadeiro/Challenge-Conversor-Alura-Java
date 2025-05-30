package src.br.com.conversor;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import src.br.com.conversor.interfaces.InterfaceConversorMoeda;
import src.br.com.conversor.modelos.Moeda;

import java.util.Scanner;

public class Conversor implements InterfaceConversorMoeda {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GsonBuilder gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);

        String opcaoSelecionada = "";
        double quantidadeAConverter;
        Moeda moeda_origem = new Moeda();
        Moeda moeda_convertida = new Moeda();

        while(!opcaoSelecionada.equalsIgnoreCase("sair")){
            System.out.println("""
                
                |==============[CONVERSOR DE MOEDAS]===============|
                |Digite uma opção:                                 |
                |[1] Real Brasileiro(BRL) para Dólar (USD)         |
                |[2] Dólar (USD) para Real Brasileiro(BRL)         |
                |[3] Real Brasileiro(BRL) para Euro (EUR)          |
                |[4] Euro(EUR) para Real Brasileiro(BRL)           |
                |[5] Real Brasileiro(BRL) para Libra Esterlina(GBP)|
                |[6] Libra Esterlina(GBP) para Real Brasileiro(BRL)|
                |                                                  |
                |Para sair, digite "Sair".                         |
                """);
            
            opcaoSelecionada = entrada.nextLine();

            if(opcaoSelecionada.equalsIgnoreCase("sair")){
                break;
            };

            switch (opcaoSelecionada){
                case "1":
                    moeda_origem.setCodigo("BRL");
                    moeda_convertida.setCodigo("USD");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                case "2":
                    moeda_origem.setCodigo("USD");
                    moeda_convertida.setCodigo("BRL");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                case "3":
                    moeda_origem.setCodigo("BRL");
                    moeda_convertida.setCodigo("EUR");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                case "4":
                    moeda_origem.setCodigo("EUR");
                    moeda_convertida.setCodigo("BRL");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                case "5":
                    moeda_origem.setCodigo("BRL");
                    moeda_convertida.setCodigo("GBP");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                case "6":
                    moeda_origem.setCodigo("GBP");
                    moeda_convertida.setCodigo("BRL");
                    System.out.println("Digite uma quantidade a ser convertida");
                    quantidadeAConverter = entrada.nextDouble();
                    break;
                default:
                    System.out.println("ERRO: Opção inválida selecionada. Tente novamente");
                    break;
            }
        }

        System.out.println("Saindo...");

        entrada.close();
    }

    @Override
    public double converter(double valor,double taxaConversao, String moedaOrigem, String moedaDestino) {
        System.out.println("Convertendo de " + moedaOrigem + " para " + moedaDestino + ": ");
        return valor * taxaConversao;
    }
}