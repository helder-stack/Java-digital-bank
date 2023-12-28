public abstract class Account implements IAccount {

    private static final int DEFAULT_BRANCH = 1;
    private static int SEQUENTIAL = 1;

    protected int branch;
    protected int number;
    protected double cash;
    protected Client client;

    public Account(Client client) {
        this.branch = Account.DEFAULT_BRANCH;
        this.number = SEQUENTIAL++;
        this.client = client;
    }

    public void deposit(double value) {
        this.cash += value;
    }

    public void transfer(double value, Account account) {
        this.withDraw(value);
        account.deposit(value);
    }

    public void withDraw(double value) throws RuntimeException{
        if(value > this.cash){
            throw new RuntimeException("Cash is not enough");
        }
        this.cash -= value;
    }

    public int getBranch() {
        return this.branch;
    }

    public int getNumber() {
        return this.number;
    }

    public double getCash() {
        return this.cash;
    }

    public void getExtract(){
        System.out.println("\n================");
        System.out.println(String.format("Agência: %s", this.branch));
        System.out.println(String.format("Conta: %s", this.number));
        System.out.println(String.format("Saldo do cliente %s", this.client.name));
        System.out.println(String.format("R$%.2f", this.cash));
        System.out.println("================\n");
    }
}
