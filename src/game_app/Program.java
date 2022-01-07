package game_app;

public class Program {

    public static void main (String[] args){
        Pawn pawn=new Pawn("1D");
        GamePlay gamePlay=new GamePlay(pawn);
        gamePlay.DoMove(Moves.UP);//2d
        gamePlay.DoMove(Moves.UP);//3d
        gamePlay.DoMove(Moves.UP);//4d
        gamePlay.DoMove(Moves.UP);//5d
        gamePlay.DoMove(Moves.UP);//6d
        gamePlay.DoMove(Moves.DOWN);//5d
        gamePlay.DoMove(Moves.LEFT);//5e
        gamePlay.DoMove(Moves.LEFT);//5f
        gamePlay.DoMove(Moves.LEFT);//5g
        gamePlay.DoMove(Moves.RIGHT);//5f
        gamePlay.DoMove(Moves.RIGHT);//5e
        gamePlay.DoMove(Moves.RIGHT);//5d
        gamePlay.DoMove(Moves.RIGHT);//5c


        gamePlay.Undo();//5d
        gamePlay.Redo();//5c

        gamePlay.DoMove(Moves.UP);//6c
        gamePlay.DoMove(Moves.UP);//7c
        gamePlay.DoMove(Moves.UP);//8c
        gamePlay.DoMove(Moves.UP);




    }
}
