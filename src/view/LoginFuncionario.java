package view;

import utils.Util;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfFuncionario;
    private JPasswordField senhaFuncionario;
    private JLabel invalido;

    public LoginFuncionario() {
        setContentPane(contentPane);
        setModal(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
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
        // add your code here
        if (cpfFuncionario.getText().isBlank() || senhaFuncionario.getPassword().length == 0) {
            invalido.setVisible(true);
        }
        String file = "src\\loginFuncionarios.csv";
        ArrayList<String[]> matrix = Util.leitor(file);
        for (String[] row : matrix) {
            if (row[0].equals(cpfFuncionario.getText()) && Arrays.equals(row[1].toCharArray(), senhaFuncionario.getPassword())) {

                dispose();
                new TelaPrincipalFuncionario().setVisible(true);
            }
        }
        cpfFuncionario.setText("");
        senhaFuncionario.setText("");
        invalido.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        LoginFuncionario dialog = new LoginFuncionario();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
