package online_banking;

public interface ICard {
    boolean withdraw(long amount);

    boolean pay(long amount);

    boolean transfer(long amount, ICard card);

    boolean add(long amount);

    ICard updateAmount(long amount);

    long getAmount();
    void setAmount(long amount);

}
