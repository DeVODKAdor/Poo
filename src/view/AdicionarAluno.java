package view;

import model.Aluno;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;

public class AdicionarAluno extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfAluno;
    private JTextField nomeAluno;
    private JTextField emailAluno;
    private JTextField insituicaoAluno;
    private JTextField cursoAluno;
    private JTextField notaEnemAluno;
    private JLabel aviso;

    public AdicionarAluno() {
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
        if (cpfAluno.getText().isBlank() || nomeAluno.getText().isBlank() || emailAluno.getText().isBlank() || insituicaoAluno.getText().isBlank() || cursoAluno.getText().isBlank() || notaEnemAluno.getText().isBlank()) {
            aviso.setVisible(true);
        } else {
            Aluno aluno = new Aluno(cpfAluno.getText(), nomeAluno.getText(), emailAluno.getText(), insituicaoAluno.getText(), cursoAluno.getText(), notaEnemAluno.getText());
            SistemaBiblioteca.adicionarAluno(aluno);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AdicionarAluno dialog = new AdicionarAluno();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
