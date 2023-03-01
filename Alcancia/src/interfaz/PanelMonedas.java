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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se selecciona la denominaci�n de una moneda para agregarla a la alcanc�a.
 */
@SuppressWarnings("serial")
public class PanelMonedas extends JPanel implements ActionListener, ItemListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar una moneda a la alcanc�a.
     */
    private static final String AGREGAR = "agregar";

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
     * Opci�n para seleccionar monedas de $50.
     */
    private JRadioButton radio50;

    /**
     * Opci�n para seleccionar monedas de $100.
     */
    private JRadioButton radio100;

    /**
     * Opci�n para seleccionar monedas de $200.
     */
    private JRadioButton radio200;

    /**
     * Opci�n para seleccionar monedas de $500.
     */
    private JRadioButton radio500;

    /**
     * Opci�n para seleccionar monedas de $1000.
     */
    private JRadioButton radio1000;

    /**
     * Grupo de botones que asegura que solamente se selecciona una moneda a la vez.
     */
    private ButtonGroup grupoBotones;

    /**
     * Bot�n para agregar una moneda a la alcanc�a.
     */
    private JButton btnAgregar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo panel. <br>
     * <b>post: </b> Se construy� el panel y se inicializaron sus componentes.
     *
     * @param pPrincipal Referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelMonedas(InterfazAlcancia pPrincipal) {
        principal = pPrincipal;

        // Inicializa los componentes del panel
        grupoBotones = new ButtonGroup();

        radio50 = new JRadioButton("0", new ImageIcon("./data/50.png"));
        grupoBotones.add(radio50);
        radio50.setVerticalTextPosition(SwingConstants.BOTTOM);
        radio50.setHorizontalTextPosition(SwingConstants.CENTER);
        radio50.addItemListener(this);
        radio50.setBorder(null);
        add(radio50);

        radio100 = new JRadioButton("0", new ImageIcon("./data/100.png"));
        grupoBotones.add(radio100);
        radio100.setVerticalTextPosition(SwingConstants.BOTTOM);
        radio100.setHorizontalTextPosition(SwingConstants.CENTER);
        radio100.addItemListener(this);
        radio100.setBorder(null);
        add(radio100);

        radio200 = new JRadioButton("0", new ImageIcon("./data/200.png"));
        grupoBotones.add(radio200);
        radio200.setVerticalTextPosition(SwingConstants.BOTTOM);
        radio200.setHorizontalTextPosition(SwingConstants.CENTER);
        radio200.addItemListener(this);
        radio200.setBorder(null);
        add(radio200);

        radio500 = new JRadioButton("0", new ImageIcon("./data/500.png"));
        grupoBotones.add(radio500);
        radio500.setVerticalTextPosition(SwingConstants.BOTTOM);
        radio500.setHorizontalTextPosition(SwingConstants.CENTER);
        radio500.addItemListener(this);
        radio500.setBorder(null);
        add(radio500);

        radio1000 = new JRadioButton("0", new ImageIcon("./data/1000.png"));
        grupoBotones.add(radio1000);
        radio1000.setVerticalTextPosition(SwingConstants.BOTTOM);
        radio1000.setHorizontalTextPosition(SwingConstants.CENTER);
        radio1000.addItemListener(this);
        radio1000.setBorder(null);
        add(radio1000);

        radio50.setSelected(true);

        btnAgregar = new JButton("Agregar moneda");
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        add(btnAgregar);

        setBorder(new TitledBorder("Monedas"));
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia la cantidad de monedas que hay de una cierta cantidad.
     *
     * @param pDenominacion Denominaci�n de la moneda. pDenominacion > 0.
     * @param pCantidad     Cantidad de esas monedas que hay. pCantidad > 0.
     */
    public void cambiarCantidad(int pDenominacion, int pCantidad) {
        if (pDenominacion == 1000) {
            radio1000.setText("" + pCantidad);
        } else if (pDenominacion == 50) {
            radio50.setText("" + pCantidad);
        } else if (pDenominacion == 100) {
            radio100.setText("" + pCantidad);
        } else if (pDenominacion == 200) {
            radio200.setText("" + pCantidad);
        } else if (pDenominacion == 500) {
            radio500.setText("" + pCantidad);
        }
    }

    /**
     * Ejecuta la acci�n seg�n el bot�n sobre el que se haya hecho click.
     *
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();

        if (AGREGAR.equals(comando)) {
            int denominacion = 0;
            if (radio1000.isSelected()) {
                denominacion = 1000;
            } else if (radio50.isSelected()) {
                denominacion = 50;
            } else if (radio100.isSelected()) {
                denominacion = 100;
            } else if (radio200.isSelected()) {
                denominacion = 200;
            } else if (radio500.isSelected()) {
                denominacion = 500;
            }

            principal.agregarMoneda(denominacion);
        }
    }

    /**
     * M�todo se llama cuando se selecciona alguno de los botones que indican las denominaciones. <br>
     * El m�todo se encarga de dibujar un borde alrededor de la denominaci�n seleccionada.
     *
     * @param pEvento Evento de la selecci�n de una denominaci�n. pEvento != null.
     */
    public void itemStateChanged(ItemEvent pEvento) {
        JRadioButton boton = (JRadioButton) pEvento.getItem();

        if (pEvento.getStateChange() == ItemEvent.SELECTED) {
            boton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY));
            boton.setBorderPainted(true);
        } else {
            boton.setBorder(null);
        }
        validate();
    }

}