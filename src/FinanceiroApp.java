import java.util.ArrayList;
import java.util.Scanner;

public class FinanceiroApp {
    private ArrayList<Transacao> transacoes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("=== Controle de Finanças Pessoais ===");
            System.out.println("1. Adicionar Receita");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Listar Transações");
            System.out.println("4. Consultar Saldo Atual");
            System.out.println("5. Relatório Mensal");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    adicionarTransacao("Receita");
                    break;
                case 2:
                    adicionarTransacao("Despesa");
                    break;
                case 3:
                    listarTransacoes();
                    break;
                case 4:
                    consultarSaldo();
                    break;
                case 5:
                    relatorioMensal();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarTransacao(String tipo) {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Data (MM/yyyy): ");
        String data = scanner.nextLine();
        transacoes.add(new Transacao(tipo, descricao, valor, data));
        System.out.println(tipo + " adicionada com sucesso!\n");
    }

    private void listarTransacoes() {
        System.out.println("=== Transações ===");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
        System.out.println();
    }

    private void consultarSaldo() {
        double saldo = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equals("Receita")) saldo += t.getValor();
            else saldo -= t.getValor();
        }
        System.out.println("Saldo atual: R$ " + saldo + "\n");
    }

    private void relatorioMensal() {
        System.out.print("Informe o mês e ano (MM/yyyy): ");
        String mesAno = scanner.nextLine();
        double receitas = 0, despesas = 0;
        for (Transacao t : transacoes) {
            if (t.getData().equals(mesAno)) {
                if (t.getTipo().equals("Receita")) receitas += t.getValor();
                else despesas += t.getValor();
            }
        }
        System.out.println("Receitas no período: R$ " + receitas);
        System.out.println("Despesas no período: R$ " + despesas);
        System.out.println("Saldo do período: R$ " + (receitas - despesas) + "\n");
    }

    public static void main(String[] args) {
        new FinanceiroApp().iniciar();
    }
}