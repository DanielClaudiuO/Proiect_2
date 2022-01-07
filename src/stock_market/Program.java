package stock_market;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args){
        IObserver client1=new Buyer("Daniel");
        IObserver client2=new Buyer("Oanta");
        IObserver client3=new Buyer("Filip");
        IObserver client4=new Buyer("Nicu");
       List<IObserver> clientList= new ArrayList<>();
       clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        clientList.add(client4);
        var stockMarket=new StockMarket(clientList,clientList);
        CryptoCurrency crypto1=new CryptoCurrency("BTC",12123.45);
        CryptoCurrency crypto2=new CryptoCurrency("ETH", 13345.53);
        CryptoCurrency crypto3=new CryptoCurrency("ETH", 13345.53);
        CryptoCurrency crypto4=new CryptoCurrency("ETH", 13345.53);

        stockMarket.addCrypto(crypto1);
        stockMarket.setCryptoPrice(crypto1,11111.78);

        stockMarket.unregisterAdd(client1);


    }
}
