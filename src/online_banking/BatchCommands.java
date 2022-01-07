package online_banking;

import java.util.ArrayList;
import java.util.List;

public class BatchCommands {
    private ProcessComand command;
    private List<ProcessComand> batch = new ArrayList<>();

    public BatchCommands(ProcessComand command) {
        this.command = command;
        System.out.println("Executing");
        this.command.execute();
    }

    public BatchCommands(List<ProcessComand> batch) {
        this.batch = batch;
    }

    public void ExecuteBatch() {
        if (batch != null) {
            System.out.println("Executing batch");
            boolean failed = false;

            for (ProcessComand command : batch) {
                command.execute();
                if (!command.isExecuted()) {
                    System.out.println("Command is executed");
                    failed = true;
                    break;
                }
            }
            if (failed)
                for (ProcessComand command : batch) {
                    if (command.isExecuted())
                        command.unExecute();
                }
            if (!failed)
                System.out.println("Executed");
            else
                System.out.println("Failed Rolling Back");
        }
    }
}
