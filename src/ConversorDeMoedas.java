import java.util.Scanner;

public class ConversorDeMoedas {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        Double valorConvertido = 0.0;

        System.out.println("BEM-VINDO AO CONVERSOR DE MOEDAS");

        while (opcao != 7) {
            System.out.println("""
                    Menu de Conversão de Moedas:
                    ("1. Converter Dólar Americano (USD) para Euro (EUR)");
                    ("2. Converter Euro (EUR) para Dólar Americano (USD)");
                    ("3. Converter Dólar Americano (USD) para Real Brasileiro (BRL)");
                    ("4. Converter Real Brasileiro (BRL) para Dólar Americano (USD)");
                    ("5. Converter Euro (EUR) para Real Brasileiro (BRL)");
                    ("6. Converter Real Brasileiro (BRL) para Euro (EUR)");
                    ("7. Sair");
                    "Escolha uma opção: """);

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 6) {
                    
                    System.out.print("Digite o valor a ser convertido: ");
                    Double valor = scanner.nextDouble();
                    valorConvertido = ConversorMoeda(opcao) * valor;

                    System.out.println("O valor de (" + valor + ") convertido é de: " + valorConvertido);

                } else if (opcao == 7) {
                    System.out.println("Saindo");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
            }

            System.out.println("*******************************************************" + "\n");
        }

        scanner.close();
    }

    public static Double ConversorMoeda(int opcao) {

        ConsultaCambio consultarCambio = new ConsultaCambio();
        Cambio valorMoeda;

        switch (opcao) {
            case 1:
                valorMoeda = consultarCambio.buscaCambio("USD");
                return valorMoeda.getConversion_rates().get("EUR");// Exemplo de taxa de câmbio USD para EUR
            case 2:
                valorMoeda = consultarCambio.buscaCambio("EUR");
                return valorMoeda.getConversion_rates().get("USD"); // Exemplo de taxa de câmbio EUR para USD
            case 3:
                valorMoeda = consultarCambio.buscaCambio("USD");
                return valorMoeda.getConversion_rates().get("BRL"); // Exemplo de taxa de câmbio USD para BRL
            case 4:
                valorMoeda = consultarCambio.buscaCambio("BRL");
                return valorMoeda.getConversion_rates().get("USD"); // Exemplo de taxa de câmbio BRL para USD
            case 5:
                valorMoeda = consultarCambio.buscaCambio("EUR");
                return valorMoeda.getConversion_rates().get("BRL"); // Exemplo de taxa de câmbio EUR para BRL
            case 6:
                valorMoeda = consultarCambio.buscaCambio("BRL");
                return valorMoeda.getConversion_rates().get("EUR"); // Exemplo de taxa de câmbio BRL para EUR
            default:
                return null;
        }
    }
}
