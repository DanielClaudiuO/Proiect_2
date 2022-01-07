package online_banking;

public class ProcessComand implements Command {

    private ICard card;
    private ICard card2;
    private long amount;
    private Actions action;
    private boolean isExecuted;

    public ProcessComand(ICard card, long amount, Actions action) {
        this.card = card;
        this.amount = amount;
        this.action = action;
        isExecuted = false;
    }

    public ProcessComand(ICard card, ICard card2, long amount) {
        this.card = card;
        this.card2 = card2;
        this.amount = amount;
        action = Actions.TRANSFER;
        isExecuted = false;
    }

    @Override
    public void execute() {
        switch (action) {
            case ADD -> isExecuted = card.add(amount);
            case PAY -> isExecuted = card.pay(amount);
            case TRANSFER -> isExecuted = card.transfer(amount, card2);
            case WITHDRAW -> isExecuted = card.withdraw(amount);
        }

    }

    @Override
    public void unExecute() {
        if (isExecuted)
            switch (action) {
                case TRANSFER -> {
                    card.add(amount);
                    card2.pay(amount);
                }
                case ADD -> card.pay(amount);
                case WITHDRAW, PAY -> card.add(amount);
            }
    }

    public boolean isExecuted() {
        return isExecuted;
    }

}
