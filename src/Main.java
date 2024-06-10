import view.TelaInicial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));

    }
}
