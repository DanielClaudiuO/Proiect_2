package online_banking;

public class Card implements ICard {

    public String Name;
    public IBank bank;
    public long amount;

    public Card(String name, IBank bank, long amount) {
        Name = name;
        this.bank = bank;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean withdraw(long amount) {
        if (bank.CanWithdraw(this, amount)) {
            bank.Withdraw(this, amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        if (bank.CanPay(this, amount)) {
            bank.Pay(this, amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean transfer(long amount, ICard card) {
        if (bank.CanTransfer(this, amount, card)) {
            bank.Transfer(this, amount, card);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(long amount) {
        amount += amount;
        return true;
    }

    @Override
    public ICard updateAmount(long amount) {
        this.amount += amount;
        return this;
    }
}
