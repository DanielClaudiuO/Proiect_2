package chat_app;

public interface IObserver {
    void updateAdd(CryptoCurrency cryptoCurrency);
    void updateChange(CryptoCurrency cryptoCurrency, double newPrice);
}
