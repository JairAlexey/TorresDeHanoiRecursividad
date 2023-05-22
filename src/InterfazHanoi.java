import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class InterfazHanoi extends JFrame {
    private JTable tablaTorres;
    private JButton btnIniciar;
    private JButton btnReiniciar;
    private JButton btnResolver;
    private JButton btnMoverAB;
    private JButton btnMoverAC;
    private JButton btnMoverBA;
    private JButton btnMoverBC;
    private JButton btnMoverCA;
    private JButton btnMoverCB;
    private JLabel lblNumMovimientos;
    private JLabel lblMovimientosRealizados;
    private Hanoi juego;

    public InterfazHanoi() {
        setTitle("Torres de Hanoi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel de configuración
        JPanel panelConfiguracion = new JPanel();
        JLabel lblNumDiscos = new JLabel("Cantidad de discos:");
        JComboBox<Integer> comboNumDiscos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        btnIniciar = new JButton("Iniciar");
        panelConfiguracion.add(lblNumDiscos);
        panelConfiguracion.add(comboNumDiscos);
        panelConfiguracion.add(btnIniciar);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnReiniciar = new JButton("Reiniciar");
        btnResolver = new JButton("Resolver");
        btnMoverAB = new JButton("Mover A -> B");
        btnMoverAC = new JButton("Mover A -> C");
        btnMoverBA = new JButton("Mover B -> A");
        btnMoverBC = new JButton("Mover B -> C");
        btnMoverCA = new JButton("Mover C -> A");
        btnMoverCB = new JButton("Mover C -> B");
        lblNumMovimientos = new JLabel("Movimientos mínimos: 0");
        lblMovimientosRealizados = new JLabel("Movimientos realizados: 0");
        panelBotones.add(btnReiniciar);
        panelBotones.add(btnResolver);
        panelBotones.add(btnMoverAB);
        panelBotones.add(btnMoverAC);
        panelBotones.add(btnMoverBA);
        panelBotones.add(btnMoverBC);
        panelBotones.add(btnMoverCA);
        panelBotones.add(btnMoverCB);
        panelBotones.add(lblNumMovimientos);
        panelBotones.add(lblMovimientosRealizados);

        // Tabla de torres
        tablaTorres = new JTable(3, 3);
        configurarTabla();

        // Agregar componentes a la ventana
        add(panelConfiguracion, BorderLayout.NORTH);
        add(new JScrollPane(tablaTorres), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción del botón Iniciar
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numDiscos = (int) comboNumDiscos.getSelectedItem();
                juego = new Hanoi(numDiscos);
                actualizarTabla();
                lblNumMovimientos.setText("Movimientos mínimos: " + calcularMovimientosMinimos(numDiscos));
                lblMovimientosRealizados.setText("Movimientos realizados: 0");
            }
        });

        // Acción del botón Reiniciar
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    int numDiscos = juego.getNumDiscos();
                    juego = new Hanoi(numDiscos);
                    actualizarTabla();
                    lblMovimientosRealizados.setText("Movimientos realizados: 0");
                }
            }
        });

        // Acción del botón Resolver
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    resolverAutomatico();
                }
            }
        });

        // Acción del botón Mover A -> B
        btnMoverAB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_A, Hanoi.Torre.TORRE_B)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Acción del botón Mover A -> C
        btnMoverAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_A, Hanoi.Torre.TORRE_C)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Acción del botón Mover B -> A
        btnMoverBA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_B, Hanoi.Torre.TORRE_A)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Acción del botón Mover B -> C
        btnMoverBC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_B, Hanoi.Torre.TORRE_C)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Acción del botón Mover C -> A
        btnMoverCA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_C, Hanoi.Torre.TORRE_A)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Acción del botón Mover C -> B
        btnMoverCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego != null) {
                    if (juego.moverDisco(Hanoi.Torre.TORRE_C, Hanoi.Torre.TORRE_B)) {
                        actualizarTabla();
                        lblMovimientosRealizados.setText("Movimientos realizados: " + juego.getMovimientosRealizados());
                    }
                }
            }
        });

        // Configuración de la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarTabla() {
        tablaTorres.setEnabled(false);
        tablaTorres.setRowHeight(30);
        tablaTorres.setIntercellSpacing(new Dimension(10, 10));
        tablaTorres.setShowGrid(false);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tablaTorres.getColumnCount(); i++) {
            tablaTorres.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) tablaTorres.getModel();
        model.setRowCount(0);

        Stack<Integer> torreA = juego.getTorreA();
        Stack<Integer> torreB = juego.getTorreB();
        Stack<Integer> torreC = juego.getTorreC();

        int numFilas = Math.max(torreA.size(), Math.max(torreB.size(), torreC.size()));

        for (int i = 0; i < numFilas; i++) {
            Integer discoA = i < torreA.size() ? torreA.get(i) : null;
            Integer discoB = i < torreB.size() ? torreB.get(i) : null;
            Integer discoC = i < torreC.size() ? torreC.get(i) : null;
            model.addRow(new Object[]{discoA, discoB, discoC});
        }
    }

    private int calcularMovimientosMinimos(int numDiscos) {
        return (int) Math.pow(2, numDiscos) - 1;
    }

    private void resolverAutomatico() {
        int numDiscos = juego.getNumDiscos();
        int movimientosMinimos = calcularMovimientosMinimos(numDiscos);
        int movimientosRealizados = 0;

        for (int i = 0; i < movimientosMinimos; i++) {
            Hanoi.Torre origen;
            Hanoi.Torre destino;

            if (i % 3 == 0) {
                origen = Hanoi.Torre.TORRE_A;
                destino = Hanoi.Torre.TORRE_B;
            } else if (i % 3 == 1) {
                origen = Hanoi.Torre.TORRE_A;
                destino = Hanoi.Torre.TORRE_C;
            } else {
                origen = Hanoi.Torre.TORRE_B;
                destino = Hanoi.Torre.TORRE_C;
            }

            if (juego.moverDisco(origen, destino)) {
                movimientosRealizados++;
                actualizarTabla();
                lblMovimientosRealizados.setText("Movimientos realizados: " + movimientosRealizados);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazHanoi();
            }
        });
    }
}