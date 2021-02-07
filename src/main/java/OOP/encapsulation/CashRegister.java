package OOP.encapsulation;

public class CashRegister {
    private int cash = 0;

    public int getCash() {
        return cash;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

}
