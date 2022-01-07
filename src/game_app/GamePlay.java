package game_app;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private Pawn pawn;
    private PawnCommand pawnCommand;
    private List<PawnCommand> commandHistory= new ArrayList<>();

    public GamePlay(Pawn pawn) {
        this.pawn = pawn;
    }

    public void DoMove(Moves move){
        PawnCommand command=new PawnCommand(move,pawn);
        command.Move();
        commandHistory.add(command);
    }

    public void Undo(){
        PawnCommand lastCommand=commandHistory.get(commandHistory.size()-1);
        if(lastCommand== null) return;
        pawnCommand=lastCommand;
        lastCommand.Undo();
        commandHistory.remove(lastCommand);
    }

    public void Redo(){
        PawnCommand lastCommand=pawnCommand;
        lastCommand.Move();
    }
}
