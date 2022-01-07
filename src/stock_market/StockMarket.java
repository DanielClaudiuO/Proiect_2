package stock_market;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements IStockMarket {
    private List<IObserver> addObservers;
    private List<IObserver> updateObservers;
    private List<CryptoCurrency> currencies = new ArrayList<>();

    public StockMarket(List<IObserver> addObservers, List<IObserver> updateObservers) {
        this.addObservers = addObservers;
        this.updateObservers = updateObservers;
    }

    @Override
    public void registerAdd(IObserver iObserver) {
        addObservers.add(iObserver);
    }

    @Override
    public void unregisterAdd(IObserver deletedObserver) {
        int observerIndex = addObservers.indexOf(deletedObserver);
        System.out.println("Client " + (observerIndex + 1) + " will no longer be updated on price change");
        addObservers.remove(observerIndex);
    }

    @Override
    public void registerUpdate(IObserver iObserver) {
        updateObservers.add(iObserver);
    }

    @Override
    public void unregisterUpdate(IObserver deletedObserver) {
        int observerIndex = updateObservers.indexOf(deletedObserver);
        System.out.println("Client " + (observerIndex + 1) + " will no longer be notified about new crypto");
        updateObservers.remove(observerIndex);
    }

    @Override
    public void notifyObserverAdd(CryptoCurrency cryptoCurrency) {
        for (IObserver addObserver : addObservers) {
            addObserver.updateAdd(cryptoCurrency);
        }
    }

    @Override
    public void notifyObserverUpdate(CryptoCurrency updatedCrypto, double newPrice) {

        for (IObserver updateObserver : updateObservers) {
            updateObserver.updateChange(updatedCrypto, newPrice);
        }
    }

    public void addCrypto(CryptoCurrency cryptoCurrency) {
        currencies.add(cryptoCurrency);
        notifyObserverAdd(cryptoCurrency );
    }

    public void setCryptoPrice(CryptoCurrency cryptoCurrency, double newPrice) {
        int cryptoIndex = currencies.indexOf(cryptoCurrency);
        CryptoCurrency updatedCrypto = currencies.get(cryptoIndex).updateCrypto(newPrice);
        notifyObserverUpdate(updatedCrypto, newPrice);
    }


}
