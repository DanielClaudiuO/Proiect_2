package online_banking;

import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<ICard> cards = new ArrayList<>();

    @Override
    public void Register(ICard card) {
        if (!cards.contains(card))
            cards.add(card);
        card.toString();
    }

    @Override
    public boolean CanWithdraw(ICard card, long amount) {
        if (card.getAmount() >= amount)
            return true;
        System.out.println("Not enough founds to withdraw ");
        return false;
    }

    @Override
    public boolean CanPay(ICard card, long amount) {
        if (card.getAmount() >= amount)
            return true;
        System.out.println("Not enough founds to pay ");
        return false;
    }

    @Override
    public boolean CanTransfer(ICard card, long amount, ICard card2) {
        if (card.getAmount() >= amount)
            return true;
        System.out.println("Not enough founds to transfer ");
        return false;
    }

    @Override
    public void Withdraw(ICard card, long amount) {
        card.updateAmount(-amount);
        System.out.println("Withdrawn " + amount);
    }

    @Override
    public void Pay(ICard card, long amount) {
        card.updateAmount(-amount);
        System.out.println("Payed: " + amount);
    }

    @Override
    public void Transfer(ICard card, long amount, ICard card2) {
        card.updateAmount(-amount);
        card2.updateAmount(amount);
        System.out.println("Transfered " + amount);
    }

    @Override
    public void Add(ICard card, long amount) {
        card.updateAmount(amount);
        System.out.println("Recieved " + amount);
    }
}
