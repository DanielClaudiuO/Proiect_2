package stock_market;

public interface IStockMarket {

    void registerAdd(IObserver iObserver);

    void unregisterAdd(IObserver iObserver);

    void registerUpdate(IObserver iObserver);

    void unregisterUpdate(IObserver iObserver);

    void notifyObserverAdd(CryptoCurrency cryptoCurrency);

    void notifyObserverUpdate(CryptoCurrency updatedCrypto,double newPrice);

}
