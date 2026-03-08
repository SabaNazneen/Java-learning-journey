package three.classdemo.abstraction;

public class AbstractionDemo {
    static void main() {
        Savings savings = new Savings();
        savings.deposit(10000);

        BankAccount ba = new CurrentAccount(10000);
        ba.deposit(10000);
        ba.withdraw(20000);
    }
}
