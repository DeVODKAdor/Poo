package view;

import model.Livro;
import model.SistemaBiblioteca;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;
import java.util.ArrayList;

public class AdicionarLivro extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField livroTitulo;
    private JTextArea livroAutores;
    private JTextField livroEditora;
    private JTextField livroAno;
    private JTextField livroPaginas;
    private JTextField livroISBN;
    private JTextField livroGenero;
    private JTextArea livroSinopse;
    private JTextField livroIdioma;

    public AdicionarLivro() {
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
        Livro livro = new Livro(livroTitulo.getText(), livroAutores.getText(), livroEditora.getText(), livroAno.getText(), livroPaginas.getText(), livroISBN.getText(), livroGenero.getText(), livroSinopse.getText(), livroIdioma.getText());
        SistemaBiblioteca.adicionarLivro(livro);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AdicionarLivro dialog = new AdicionarLivro();
        dialog.pack();

        dialog.setVisible(true);
        System.exit(0);
    }
}
