package view;

import model.Aluno;
import model.Professor;
import model.SistemaBiblioteca;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConsultarAluno extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea alunosDisplay;

    public ConsultarAluno() {
        setContentPane(contentPane);
        setModal(true);
        setSize(600, 600);
        getRootPane().setDefaultButton(buttonOK);

        ArrayList<Aluno> alunos = SistemaBiblioteca.consultarAluno();
        String texto = "";

        for (Aluno aluno: alunos) {
            texto += ((aluno.getCpf()) + " | " + aluno.getNome() + " | " + aluno.getEmail() + " | " + aluno.getInstituicaoDeEnsino() + " | " + aluno.getCurso() + " | " + aluno.getNotaENEM() + "\n");
        }

        alunosDisplay.setText(texto);

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
        ConsultarAluno dialog = new ConsultarAluno();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
