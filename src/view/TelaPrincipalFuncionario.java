package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalFuncionario extends JFrame {
    private JPanel pane;
    private JButton consultarLivrosButton;
    private JButton consultarProfessoresButton;
    private JButton consultarAlunosButton;
    private JButton consultarCargosButton;
    private JButton consultarFuncionáriosButton;
    private JButton adicionarLivroButton;
    private JButton adicionarProfessorButton;
    private JButton adicionarAlunoButton;
    private JButton adicionarCargoButton;
    private JButton adicionarFuncionárioButton;

    TelaPrincipalFuncionario () {
        setContentPane(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escolha uma opção");
        setSize(600, 600);
        setLocationRelativeTo(null);
        adicionarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarLivro().setVisible(true);
            }
        });
    }
}
