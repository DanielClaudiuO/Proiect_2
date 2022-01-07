package game_app;

public class PawnCommand implements Command {
    private Moves move;
    private Pawn pawn;

    public PawnCommand(Moves move, Pawn pawn) {
        this.move = move;
        this.pawn = pawn;
    }

    @Override
    public void Move() {
        pawn.changePosition(move);
    }

    @Override
    public void Undo() {
        pawn.changePosition(UndoMove(move));
    }

    private Moves UndoMove(Moves move) {
        switch (move) {
            case UP:
                return Moves.DOWN;
            case DOWN:
                return Moves.UP;
            case RIGHT:
                return Moves.LEFT;
            case LEFT:
                return Moves.RIGHT;
            default:
                throw new IndexOutOfBoundsException();
        }
    }
}
