package view;

import model.Professor;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class AdicionarProfessor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfProfessor;
    private JTextField nomeProfessor;
    private JTextField emailProfessor;
    private JTextField titulacaoProfessor;
    private JLabel aviso;

    public AdicionarProfessor() {
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
        if(titulacaoProfessor.getText().isBlank() || cpfProfessor.getText().isBlank() || emailProfessor.getText().isBlank() || nomeProfessor.getText().isBlank()) {
            aviso.setVisible(true);
        } else {
            Random rand = new Random();
            int numero = rand.nextInt(9000) + 1000; // Gera um número entre 1000 e 9999
            String senha = String.valueOf(numero);
            Professor professor = new Professor(cpfProfessor.getText(), nomeProfessor.getText(), emailProfessor.getText(), titulacaoProfessor.getText(), senha);
            SistemaBiblioteca.adicionarProfessor(professor);
            JOptionPane.showInputDialog("Sua senha é: " + professor.getSenha());
            dispose();
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AdicionarProfessor dialog = new AdicionarProfessor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
