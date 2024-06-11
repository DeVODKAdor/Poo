package view;

import model.Professor;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginProfessor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfProfessor;
    private JPasswordField senhaProfessor;
    private JLabel aviso;

    public LoginProfessor() {
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
        if (cpfProfessor.getText().isBlank() || senhaProfessor.getPassword().length == 0) {
            aviso.setText("Um campo está vazio.");
        }
        ArrayList<Professor> professores = SistemaBiblioteca.consultarProfessor();
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpfProfessor.getText()) && Arrays.equals(professor.getSenha().toCharArray(), senhaProfessor.getPassword())) {
                dispose();
                new ConsultarLivro().setVisible(true);
            }
        }
        cpfProfessor.setText("");
        senhaProfessor.setText("");
        aviso.setText("Um campo está errado.");

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        LoginProfessor dialog = new LoginProfessor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
