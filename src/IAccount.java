public interface IAccount {
    public void deposit(double value);
    public void transfer(double value, Account account) throws RuntimeException;
    public void withDraw(double value);
}
