package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    private JButton professorButton;
    private JButton funcionarioButton;
    private JPanel mainPanel;

    public TelaInicial() {
        setContentPane(mainPanel);
        setTitle("Tela Principal");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        funcionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFuncionario tela = new LoginFuncionario();
                dispose();
                tela.setVisible(true);
            }
        });
        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginProfessor().setVisible(true);
            }
        });
    }

}
