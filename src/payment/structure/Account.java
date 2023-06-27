package payment.structure;

public class Account {

    private CurrencyAmount currencyAmount;

    public Account(CurrencyAmount currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public CurrencyAmount getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(CurrencyAmount currencyAmount) {
        this.currencyAmount = currencyAmount;
    }
}
