package src.br.com.conversor;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double valor_a_converter;

        System.out.println("Usuário, selecione uma das opções de abaixo. Para sair, digite '7': ");
        System.out.println("[1] - Real (BRL) para Dólar Americano (USD)");
        System.out.println("[2] - Dólar Americano (USD) para Real (BRL)");
        System.out.println("[3] - Real (BRL) para Peso Argentino (ARS)");
        System.out.println("[4] - Peso Argentino (ARS) para Real (BRL)");
        System.out.println("[5] - Real (BRL) para Euro (EUR)");
        System.out.println("[6] - Euro (EUR) para Real (BRL)");
        System.out.println("[7] - Sair");

        valor_a_converter = entrada.nextDouble();

        entrada.close();
    }
}