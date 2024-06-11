package view;

import model.Cargo;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;

public class AdicionarCargo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField codigoCargo;
    private JTextField nomeCargo;
    private JTextField descricaoCargo;
    private JTextField cargaHorariaCargo;
    private JLabel aviso;

    public AdicionarCargo() {
        setContentPane(contentPane);
        setModal(true);
        setSize(600, 600);
        getRootPane().setDefaultButton(buttonOK);

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
        if (codigoCargo.getText().isBlank() || nomeCargo.getText().isBlank() || descricaoCargo.getText().isBlank() || cargaHorariaCargo.getText().isBlank()) {
            aviso.setVisible(true);
        } else {
            Cargo cargo = new Cargo(codigoCargo.getText(), nomeCargo.getText(), descricaoCargo.getText(), cargaHorariaCargo.getText());
            SistemaBiblioteca.adicionarCargo(cargo);
            dispose();
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AdicionarCargo dialog = new AdicionarCargo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
