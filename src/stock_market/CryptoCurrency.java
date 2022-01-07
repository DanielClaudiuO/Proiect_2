package stock_market;

public class CryptoCurrency {
    public String name;
    public double price;

    public CryptoCurrency(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public CryptoCurrency updateCrypto(double price){
        this.price=price;
        return this;
    }
}
