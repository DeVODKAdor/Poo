package view;

import model.Cargo;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConsultarCargo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea cargosDisplay;

    public ConsultarCargo() {
        setContentPane(contentPane);
        setModal(true);
        setSize(600, 600);
        getRootPane().setDefaultButton(buttonOK);

        ArrayList<Cargo> cargos = SistemaBiblioteca.consultarCargo();
        String texto = "";

        for (Cargo cargo : cargos) {
            texto += ((cargo.getCodigo() + " | " + cargo.getNome() + " | " + cargo.getDescricao() + " | " + cargo.getCargaHoraria() + "\n"));
        }

        cargosDisplay.setText(texto);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ConsultarCargo dialog = new ConsultarCargo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
