package Juego_Grupal;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel {
    private final CellButton[][] cells = new CellButton[10][10];

    /**
     * @param clickListener receptor de ActionEvents de cada casilla
     * @param showShips     true para mostrar barcos (fase de colocación o propio tablero)
     */
    public BoardPanel(ActionListener clickListener, boolean showShips) {
        setLayout(new GridLayout(10, 10, 1, 1));
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                CellButton btn = new CellButton(r, c);
                btn.addActionListener(clickListener);
                if (!showShips) {
                    btn.setState(CellButton.State.WATER);
                }
                cells[r][c] = btn;
                add(btn);
            }
        }
    }

    public CellButton getCell(int row, int col) {
        return cells[row][col];
    }
}
