package view;

import model.Cargo;
import model.Funcionario;
import model.SistemaBiblioteca;
import utils.Util;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AdicionarFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfFuncionario;
    private JTextField nomeFuncionario;
    private JTextField emailFuncionario;
    private JTextField salarioFuncionario;
    private JComboBox cargoFuncionario;
    private JLabel aviso;

    public AdicionarFuncionario() {
        setContentPane(contentPane);
        setModal(true);
        setSize(600, 600);
        getRootPane().setDefaultButton(buttonOK);

        ArrayList<Cargo> cargos = SistemaBiblioteca.consultarCargo();
        for (Cargo cargo : cargos) {
            cargoFuncionario.addItem(cargo.getNome());
        }
        cargoFuncionario.removeItemAt(0);

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
        if (cpfFuncionario.getText().isBlank() || nomeFuncionario.getText().isBlank() || emailFuncionario.getText().isBlank() || salarioFuncionario.getText().isBlank()) {
            aviso.setVisible(true);
        } else {
            Cargo cargo = Util.buscarCargo(cargoFuncionario.getSelectedItem().toString());
            Funcionario funcionario = new Funcionario(cpfFuncionario.getText(), nomeFuncionario.getText(), emailFuncionario.getText(), cargo, salarioFuncionario.getText());
            SistemaBiblioteca.adicionarFuncionario(funcionario);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AdicionarFuncionario dialog = new AdicionarFuncionario();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
