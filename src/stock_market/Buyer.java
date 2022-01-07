package stock_market;

public class Buyer implements IObserver {
    public String Name;

    public Buyer(String name) {
        Name = name;
    }

    @Override
    public void updateAdd(CryptoCurrency cryptoCurrency) {
        System.out.println("A new crypto has been added: " + cryptoCurrency.name + " " + cryptoCurrency.price);
    }

    @Override
    public void updateChange(CryptoCurrency cryptoCurrency, double newPrice) {
        System.out.println("The price of the crypto coin" + cryptoCurrency.name + " has changed to" + newPrice);
    }
}
