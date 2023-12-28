import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getAccounts() {
        System.out.println();
        for (Account account : this.accounts) {
            System.out.println(String.format("Cliente: %s | Conta: %s", account.client.name, account.number));
        }
        System.out.println();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccount(int number) throws Exception {
        for (Account account : this.accounts) {
            if (account.number == number) {
                return account;
            }
        }
        throw new Exception("Account not found");
    }

}