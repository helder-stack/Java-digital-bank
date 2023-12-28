import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        bank.setName("Banco do Hélder");
        while (true) {
            System.out.println(String.format("Bem-vindo ao banco %s", bank.getName()));
            System.out.println(
                    "\nMENU:\n\n1 - Criar novo cliente\n2 - Consultar extrato do cliente\n3 - Fazer depósito\n4 - Sacar\n5 - Transferir\n6 - Ver contas");
                    System.out.print("\nDigite uma opção: ");
                    String option = input.nextLine();
            switch (option) {
                case "1":
                    Client client = new Client();
                    System.out.print("\nDigite o nome do cliente: ");
                    client.name = input.nextLine();
                    CheckingAccount cc = new CheckingAccount(client);
                    bank.addAccount(cc);
                    cc.getExtract();
                    break;
                case "2":
                    System.out.print("\nDigite o número da conta do cliente: ");
                    Account clientAccount = bank.getAccount(input.nextInt());
                    clientAccount.getExtract();
                    input.nextLine();
                    break;
                case "3":
                    System.out.print("\nDigite o número da conta do cliente: ");
                    Account account = bank.getAccount(input.nextInt());
                    System.out.print("\nDigite o valor do depósito: ");
                    account.deposit(input.nextDouble());
                    input.nextLine();
                    System.out.println(String.format("\nNovo saldo: R$%.2f\n", account.getCash()));
                    break;
                case "4":
                    System.out.print("\nDigite o número da conta do cliente: ");
                    Account accountToWithdraw = bank.getAccount(input.nextInt());
                    System.out.print("\nDigite o valor para saque: ");
                    accountToWithdraw.withDraw(input.nextDouble());
                    input.nextLine();
                    System.out.println(String.format("\nNovo saldo: R$%.2f\n", accountToWithdraw.getCash()));
                    break;
                case "5":
                    System.out.print("\nDigite o número da conta de quem irá transferir: ");
                    Account targetWithdrawalAccount = bank.getAccount(input.nextInt());
                    System.out.print("\nDigite o valor de transferência: ");
                    Double value = input.nextDouble();
                    System.out.println("\nDigite o número da conta de quem irá receber: ");
                    Account accountToTransfer = bank.getAccount(input.nextInt());
                    targetWithdrawalAccount.transfer(value, accountToTransfer);
                    targetWithdrawalAccount.getExtract();
                    input.nextLine();
                    break;
                case "6":
                    bank.getAccounts();
                    break;
                default:
                    break;
            }
        }
    }

}
