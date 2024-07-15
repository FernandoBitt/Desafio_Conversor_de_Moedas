import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double valor;
        double taxa;

        System.out.println("Bem vindo ao Conversor de Moedas");

        while (opcao != 7) {
            System.out.println("Menu de Conversão de Moedas:");
            System.out.println("1. Converter USD para EUR");
            System.out.println("2. Converter EUR para USD");
            System.out.println("3. Converter USD para BRL");
            System.out.println("4. Converter BRL para USD");
            System.out.println("5. Converter EUR para BRL");
            System.out.println("6. Converter BRL para EUR");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 6) {
                    System.out.print("Digite o valor a ser convertido: ");
                    valor = scanner.nextDouble();
                    taxa = obterTaxaDeCambio(opcao);
                    double valorConvertido = valor * taxa;
                    System.out.printf("Valor convertido: %.2f\n", valorConvertido);
                } else if (opcao == 7) {
                    System.out.println("Saindo...");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
            }

            System.out.println();
        }

        scanner.close();
    }

    public static double obterTaxaDeCambio(int opcao) {
        switch (opcao) {
            case 1:
                return 0.85; // Exemplo de taxa de câmbio USD para EUR
            case 2:
                return 1.18; // Exemplo de taxa de câmbio EUR para USD
            case 3:
                return 5.25; // Exemplo de taxa de câmbio USD para BRL
            case 4:
                return 0.19; // Exemplo de taxa de câmbio BRL para USD
            case 5:
                return 6.18; // Exemplo de taxa de câmbio EUR para BRL
            case 6:
                return 0.16; // Exemplo de taxa de câmbio BRL para EUR
            default:
                return 1.0;
        }
    }
}

