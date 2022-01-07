package stock_market;

public interface IObserver {
    void updateAdd(CryptoCurrency cryptoCurrency);
    void updateChange(CryptoCurrency cryptoCurrency, double newPrice);
}
