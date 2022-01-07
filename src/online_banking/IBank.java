package online_banking;

public interface IBank {
    void Register(ICard card);

    boolean CanWithdraw(ICard card, long amount);

    boolean CanPay(ICard card, long amount);

    boolean CanTransfer(ICard card, long amount, ICard card2);

    void Withdraw(ICard card, long amount);

    void Pay(ICard card, long amount);

    void Transfer(ICard card, long amount, ICard forcard);

    void Add(ICard card, long amount);


}
