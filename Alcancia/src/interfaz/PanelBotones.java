/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: alcancia
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel en el que se encuentran los botones para romper la alcanc�a y crear una nueva.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para romper la alcanc�a.
     */
    private static final String ROMPER = "romper";

    /**
     * Constante para crear una nueva alcanc�a.
     */
    private static final String NUEVA = "nueva";

    /**
     * Constante para la extensi�n 1.
     */
    private static final String OPCION_1 = "opcion1";

    /**
     * Constante para la extensi�n 2.
     */
    private static final String OPCION_2 = "opcion2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazAlcancia principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n usado para romper la alcanc�a.
     */
    private JButton btnRomper;

    /**
     * Bot�n usado para crear una nueva alcanc�a.
     */
    private JButton btnNueva;

    /**
     * Bot�n para la extensi�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para la extensi�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo panel. <br>
     * <b>post: </b> Se construy� el panel y se inicializaron sus componentes.
     *
     * @param pPrincipal Referencia a la clase principal de la interfaz. pPrincipal != null
     */
    public PanelBotones(InterfazAlcancia pPrincipal) {
        principal = pPrincipal;

        setLayout(new BorderLayout());

        // Inicializa los componentes del panel
        JPanel panelInternoRomper = new JPanel();
        btnRomper = new JButton(new ImageIcon("./data/martillo.png"));
        btnRomper.setActionCommand(ROMPER);
        btnRomper.setMargin(new Insets(1, 1, 1, 1));
        btnRomper.addActionListener(this);
        btnRomper.setOpaque(false);
        btnRomper.setContentAreaFilled(false);

        panelInternoRomper.add(btnRomper);
        panelInternoRomper.setBorder(new TitledBorder("Romper alcanc�a"));
        add(panelInternoRomper, BorderLayout.CENTER);

        JPanel panelInternoBotones = new JPanel();

        btnNueva = new JButton("Nueva alcanc�a");
        btnNueva.setActionCommand(NUEVA);
        btnNueva.addActionListener(this);
        panelInternoBotones.add(btnNueva);

        btnOpcion1 = new JButton("Moneda Numerosa");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        panelInternoBotones.add(btnOpcion1);

        btnOpcion2 = new JButton("Valiosa?");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        panelInternoBotones.add(btnOpcion2);

        add(panelInternoBotones, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n seg�n el bot�n sobre el que se haya hecho click.
     *
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();

        if (NUEVA.equals(comando)) {
            principal.nuevaAlcancia();
        } else if (ROMPER.equals(comando)) {
            principal.romperAlcancia();
        } else if (OPCION_1.equals(comando)) {
            principal.reqFunc1();
        } else if (OPCION_2.equals(comando)) {
            principal.reqFunc2();
        }
    }

}