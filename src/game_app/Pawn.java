package game_app;

import java.util.Arrays;
import java.util.List;

public class Pawn {
    private final List<String> columns = Arrays.asList("H", "G", "F", "E", "D", "C", "B", "A");
    private String position;
    private int positionRow;
    private int positionColumn;

    public Pawn(String position) {
        this.position = position;
        positionRow = Integer.parseInt(position.replaceAll("[^1-8]", ""));
        for (int i = 0; i <= columns.size() - 1; i++) {
            if (position.contains(columns.get(i))) {
                positionColumn = i;
            }

        }
    }

    public void changePosition(Moves move) {

        if (positionRow != 8) {
            switch (move) {
                case UP -> {
                    positionRow += 1;
                    position = positionRow + columns.get(positionColumn);
                }
                case DOWN -> {
                    if (positionRow > 1) {
                        positionRow -= 1;
                        position = positionRow + columns.get(positionColumn);
                    }
                }
                case LEFT -> {
                    if (positionColumn > 0) {
                        positionColumn -= 1;
                        position = positionRow + columns.get(positionColumn);

                    }
                }
                case RIGHT -> {
                    if (positionColumn < 7) {
                        positionColumn += 1;
                        position = positionRow + columns.get(positionColumn);
                    }
                }
            }
            System.out.println("You have moved " + move.toString() + " to " + position);
        }
        if (positionRow == 8)
            System.out.println("You are at the last row, you can't go off the board");
    }

}


