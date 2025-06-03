package src.br.com.conversor;

import src.br.com.conversor.modelos.Moeda;
import src.br.com.conversor.exceptions.ApiException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();

        String opcaoSelecionada = "";
        double quantidadeAConverter;
        Moeda moedaOrigem = new Moeda();
        Moeda moedaDestino = new Moeda();

        while (!opcaoSelecionada.equalsIgnoreCase("sair")) {
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

            if (opcaoSelecionada.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                switch (opcaoSelecionada) {
                    case "1":
                        moedaOrigem.setCodigo("BRL");
                        moedaDestino.setCodigo("USD");
                        break;
                    case "2":
                        moedaOrigem.setCodigo("USD");
                        moedaDestino.setCodigo("BRL");
                        break;
                    case "3":
                        moedaOrigem.setCodigo("BRL");
                        moedaDestino.setCodigo("EUR");
                        break;
                    case "4":
                        moedaOrigem.setCodigo("EUR");
                        moedaDestino.setCodigo("BRL");
                        break;
                    case "5":
                        moedaOrigem.setCodigo("BRL");
                        moedaDestino.setCodigo("GBP");
                        break;
                    case "6":
                        moedaOrigem.setCodigo("GBP");
                        moedaDestino.setCodigo("BRL");
                        break;
                    default:
                        System.out.println("ERRO: Opção inválida selecionada. Tente novamente.");
                        continue;
                }

                System.out.print("Digite a quantidade a ser convertida: ");
                quantidadeAConverter = entrada.nextDouble();
                entrada.nextLine();

                double valorConvertido = conversor.converterComTaxaApi(quantidadeAConverter, moedaOrigem.getCodigo(), moedaDestino.getCodigo());
                System.out.printf("O valor de %.2f %s equivale a %.2f %s%n",
                        quantidadeAConverter, moedaOrigem.getCodigo(), valorConvertido, moedaDestino.getCodigo());

            } catch (InputMismatchException e) {
                System.err.println("Erro: Por favor, digite um número válido para a quantidade.");
                entrada.nextLine();
            } catch (ApiException e) {
                System.err.println("Erro ao obter taxa de câmbio: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
            System.out.println("-------------------------------------");
        }
        System.out.println("Saindo...");
        entrada.close();
    }
}