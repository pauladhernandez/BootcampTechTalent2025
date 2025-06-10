package Juego_Grupal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Point;
import java.util.List;

public class JuegoNavalGUI extends JFrame {
    private final BoardPanel board1, board2;
    private final JButton orientToggle;
    private final JLabel infoLabel;

    private enum Mode { PVP, PVC }
    private Mode mode;

    private boolean placingPhase = true;
    private int[] shipSizes = {5,4,3,3,2};
    private int currentShipIndex = 0;
    private boolean horizontal = true;

    private Tablero tablero1 = new Tablero();
    private Tablero tablero2 = new Tablero();

    // 0 = jugador1, 1 = humano2 o IA
    private int turno = 0;

    public JuegoNavalGUI() {
        super("Batalla Naval");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 1) Elegir modo
        String[] opciones = {"Jugador vs Jugador", "Jugador vs Computadora"};
        int sel = JOptionPane.showOptionDialog(
            null, "Elige modo de juego:", "Modo",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, opciones, opciones[0]
        );
        mode = (sel == 1 ? Mode.PVC : Mode.PVP);

        // 2) Top: info + toggle orientación
        JPanel top = new JPanel();
        infoLabel = new JLabel("Jugador 1: coloca barco de tamaño " + shipSizes[currentShipIndex]);
        orientToggle = new JButton("Horizontal");
        orientToggle.addActionListener(e -> {
            horizontal = !horizontal;
            orientToggle.setText(horizontal ? "Horizontal" : "Vertical");
        });
        top.add(infoLabel);
        top.add(orientToggle);
        add(top, BorderLayout.NORTH);

        // 3) Center: dos tableros
        board1 = new BoardPanel(this::handleClick, true);
        board2 = new BoardPanel(this::handleClick, false);
        Dimension d = new Dimension(300,300);
        board1.setPreferredSize(d);
        board2.setPreferredSize(d);

        JPanel center = new JPanel(new GridLayout(1,2,20,0));
        center.add(board1);
        center.add(board2);
        add(center, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // 4) IA coloca si es PVC
        if (mode == Mode.PVC) autoPlaceShips(tablero2);

        // 5) Primer pase de turno para que jugador 1 empiece
        pauseForTurn("Jugador 1");
    }

    private void handleClick(ActionEvent e) {
        CellButton btn = (CellButton)e.getSource();
        int r = btn.getRow(), c = btn.getCol();

        if (placingPhase) {
            // Colocación secuencial en tablero1, luego en tablero2 (si PVP)
            Tablero t = (turno == 0 ? tablero1 : tablero2);
            BoardPanel b = (turno == 0 ? board1 : board2);
            if (t.colocarBarco(new Barco(shipSizes[currentShipIndex]), r, c, horizontal)) {
                for (int i = 0; i < shipSizes[currentShipIndex]; i++) {
                    int rr = r + (horizontal ? 0 : i);
                    int cc = c + (horizontal ? i : 0);
                    b.getCell(rr, cc).setState(CellButton.State.SHIP);
                }
                // siguiente barco / siguiente jugador
                if (mode == Mode.PVP && turno == 0) {
                    turno = 1;
                    infoLabel.setText("Jugador 2: coloca barco de tamaño " + shipSizes[currentShipIndex]);
                    pauseForTurn("Jugador 2");
                } else {
                    currentShipIndex++;
                    if (currentShipIndex < shipSizes.length) {
                        infoLabel.setText("Jugador " + (turno+1) +
                            ": coloca barco de tamaño " + shipSizes[currentShipIndex]);
                    } else {
                        // fin fase colocación
                        placingPhase = false;
                        orientToggle.setEnabled(false);
                        currentShipIndex = 0;
                        infoLabel.setText("¡Turno de Jugador 1, dispara!");
                        pauseForTurn("Jugador 1");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No cabe o se solapa.");
            }
            return;
        }

        // ------------------------
        // Fase de disparos
        // ------------------------
        if (mode == Mode.PVP) {
            // turno humano vs humano
            ejecutarDisparo(turno==0 ? tablero2 : tablero1,
                            turno==0 ? board2 : board1,
                            btn);
            if (checkVictory()) return;
            turno = 1 - turno;
            infoLabel.setText("¡Turno Jugador " + (turno+1) + "!");
            pauseForTurn("Jugador " + (turno+1));
        } else {
            // PVC: jugador vs IA
            if (turno == 0) {
                ejecutarDisparo(tablero2, board2, btn);
                if (checkVictory()) return;
                turno = 1;
                pauseForTurn("Computadora");
                aiTurn();
                if (checkVictory()) return;
                turno = 0;
                pauseForTurn("Jugador 1");
            }
        }
    }

    private void ejecutarDisparo(Tablero targetTablero, BoardPanel targetBoard, CellButton btn) {
        int r = btn.getRow(), c = btn.getCol();
        // ignorar disparos repetidos
        if (btn.getState()==CellButton.State.HIT || btn.getState()==CellButton.State.MISS ||
            btn.getState()==CellButton.State.SUNK) return;

        boolean hit = targetTablero.recibirDisparo(r, c);
        btn.setState(hit ? CellButton.State.HIT : CellButton.State.MISS);

        List<Point> sunk = targetTablero.getLastSunkCoordinates();
        if (!sunk.isEmpty()) {
            for (Point p : sunk)
                targetBoard.getCell(p.x,p.y).setState(CellButton.State.SUNK);
            JOptionPane.showMessageDialog(this,
                "¡Jugador " + (turno+1) + " hundió un barco de tamaño " + sunk.size() + "!");
        }
    }

    private void aiTurn() {
        int r, c;
        do {
            r = (int)(Math.random()*10);
            c = (int)(Math.random()*10);
        } while (true == List.of(CellButton.State.HIT,CellButton.State.MISS,CellButton.State.SUNK)
                 .contains(board1.getCell(r,c).getState()));

        boolean hit = tablero1.recibirDisparo(r,c);
        board1.getCell(r,c).setState(hit ? CellButton.State.HIT : CellButton.State.MISS);

        List<Point> sunk = tablero1.getLastSunkCoordinates();
        if (!sunk.isEmpty()) {
            for (Point p : sunk)
                board1.getCell(p.x,p.y).setState(CellButton.State.SUNK);
            JOptionPane.showMessageDialog(this,
                "¡La computadora hundió tu barco de tamaño " + sunk.size() + "!");
        }
    }

    private boolean checkVictory() {
        if (!tablero2.quedanBarcos() && (mode==Mode.PVP||turno==0)) {
            JOptionPane.showMessageDialog(this,
                "¡Jugador " + (turno+1) + " ha ganado!");
            System.exit(0);
            return true;
        }
        if (!tablero1.quedanBarcos() && mode==Mode.PVC) {
            JOptionPane.showMessageDialog(this,"¡La computadora ha ganado!");
            System.exit(0);
            return true;
        }
        return false;
    }

    private void autoPlaceShips(Tablero t) {
        for (int size : shipSizes) {
            boolean ok;
            do {
                int r=(int)(Math.random()*10), c=(int)(Math.random()*10);
                boolean h=(Math.random()<.5);
                ok = t.colocarBarco(new Barco(size), r, c, h);
            } while (!ok);
        }
    }

    private void pauseForTurn(String playerName) {
        JDialog dlg = new JDialog(this, true);
        dlg.setUndecorated(true);
        dlg.setBackground(Color.DARK_GRAY);
        JLabel lbl = new JLabel("Turno de " + playerName, SwingConstants.CENTER);
        lbl.setFont(lbl.getFont().deriveFont(32f));
        lbl.setForeground(Color.WHITE);
        dlg.add(lbl);
        dlg.setSize(400, 200);
        dlg.setLocationRelativeTo(this);
        dlg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) { dlg.dispose(); }
        });
        dlg.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoNavalGUI::new);
    }
}
