package Juego_Grupal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class CellButton extends JButton {
    private final int row, col;

    public enum State { WATER, SHIP, HIT, MISS, SUNK }

    private State state = State.WATER;

    public CellButton(int row, int col) {
        this.row = row;
        this.col = col;
        updateAppearance();
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public State getState() { return state; }
    public void setState(State state) {
        this.state = state;
        updateAppearance();
    }

    private void updateAppearance() {
        setText("");
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        switch (state) {
            case WATER:
                setBackground(new Color(173, 216, 230));
                break;
            case SHIP:
                setBackground(new Color(200, 200, 200));
                break;
            case MISS:
                setBackground(Color.WHITE);
                break;
            case HIT:
                setBackground(new Color(255, 165, 0));
                break;
            case SUNK:
                setBackground(Color.RED);
                break;
        }
    }
}
