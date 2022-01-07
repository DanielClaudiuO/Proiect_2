package online_banking;

import java.util.ArrayList;
import java.util.List;

public class Program {


    public static void main(String[] args) {
        Bank bank = new Bank();
        Card card1 = new Card("Daniel", bank, 3000);
        Card card2 = new Card("Oanta", bank, 2000);

        var singleCommand = new BatchCommands(new ProcessComand(card1, 1000, Actions.PAY));
        card1.toString();
        List<ProcessComand> batch = new ArrayList<>();
        var command1 = new ProcessComand(card1, 1000, Actions.ADD);
        var command3 = new ProcessComand(card1, 1500, Actions.WITHDRAW);
        var command2 = new ProcessComand(card1, card2, 1200);
        var command4 = new ProcessComand(card1, 800, Actions.PAY);
        batch.add(command1);
        batch.add(command2);
        batch.add(command3);
        batch.add(command4);
        BatchCommands list=new BatchCommands(batch);
        list.ExecuteBatch();
        System.out.println(card1);



    }
}
