import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Created by JFormDesigner on Wed Nov 20 22:41:44 CET 2019
 */


/**
 * @author unknown
 */
public class GUI extends JFrame {
    Cifrario cifrario;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label_testo;
    private JTextField textfiled_testo;
    private JLabel label_chiave;
    private JTextField textfield_chiave;
    private JLabel risultato;
    private JTextField label_risultato;
    private JPanel panel2;
    private JButton encrypt_button;
    private JButton decrypt_button;

    public GUI() {
        initComponents();
        pack();
    }

    private void encryptButtonMouseClicked(MouseEvent e) {
        cifrario = new Cifrario(getChiave(), getTesto());
        textfiled_testo.setText(textfiled_testo.getText().toUpperCase());
        cifrario.cifra();
        setRisultato(cifrario.getOutput());
    }

    private void decryptButtonMouseClicked(MouseEvent e) {
        cifrario = new Cifrario(getChiave(), getTesto());
        textfiled_testo.setText(textfiled_testo.getText().toUpperCase());
        cifrario.decifra();
        setRisultato(cifrario.getOutput());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label_testo = new JLabel();
        textfiled_testo = new JTextField();
        label_chiave = new JLabel();
        textfield_chiave = new JTextField();
        risultato = new JLabel();
        label_risultato = new JTextField();
        panel2 = new JPanel();
        encrypt_button = new JButton();
        decrypt_button = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(445, 170));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new TableLayout(new double[][]{
                    {95, TableLayout.FILL},
                    {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
            ((TableLayout) panel1.getLayout()).setHGap(5);
            ((TableLayout) panel1.getLayout()).setVGap(5);

            //---- label_testo ----
            label_testo.setText("Testo in chiaro");
            label_testo.setFocusable(false);
            panel1.add(label_testo, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panel1.add(textfiled_testo, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label_chiave ----
            label_chiave.setText("Chiave");
            label_chiave.setFocusable(false);
            panel1.add(label_chiave, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            panel1.add(textfield_chiave, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- risultato ----
            risultato.setText("Risultato");
            risultato.setFocusable(false);
            panel1.add(risultato, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label_risultato ----
            label_risultato.setEditable(false);
            panel1.add(label_risultato, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new TableLayout(new double[][]{
                    {TableLayout.FILL, TableLayout.FILL},
                    {TableLayout.PREFERRED}}));
            ((TableLayout) panel2.getLayout()).setHGap(5);
            ((TableLayout) panel2.getLayout()).setVGap(5);

            //---- encrypt_button ----
            encrypt_button.setText("Encrypt");
            encrypt_button.setFocusable(false);
            encrypt_button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    encryptButtonMouseClicked(e);
                }
            });
            panel2.add(encrypt_button, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- decrypt_button ----
            decrypt_button.setText("Decrypt");
            decrypt_button.setFocusable(false);
            decrypt_button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    decryptButtonMouseClicked(e);
                }
            });
            panel2.add(decrypt_button, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        contentPane.add(panel2, BorderLayout.SOUTH);
        setSize(445, 170);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //getter and setters
    public String getTesto() {
        try {
            return textfiled_testo.getText();
        } catch (Exception e) {

        }
        return null;
    }

    public void setTesto(String testo) {
        textfiled_testo.setText(testo);
    }

    public int getChiave() {
        try {
            return Integer.valueOf(textfield_chiave.getText()).intValue();
        } catch (Exception e) {

        }
        return 0;
    }

    public void setRisultato(String testo) {
        label_risultato.setText(testo);
    }
}
