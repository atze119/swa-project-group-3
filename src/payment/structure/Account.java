package payment.structure;

public class Account {

    private CurrencyAmount currencyAmount;

    private String name;

    public Account(CurrencyAmount currencyAmount, String name) {
        this.currencyAmount = currencyAmount;
        this.name = name;
    }

    public CurrencyAmount getCurrencyAmount() {
        return currencyAmount;
    }

    public String getName() {
        return name;
    }

}
