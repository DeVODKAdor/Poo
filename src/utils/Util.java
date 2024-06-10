package utils;

import view.TelaPrincipalFuncionario;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<String[]> leitor(String caminho) {
        BufferedReader reader = null;
        String line;
        ArrayList<String[]> matrix = new ArrayList<String[]>();
        try {
            reader = new BufferedReader(new FileReader(caminho));
            while ((line = reader.readLine()) != null) {
                matrix.add(line.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return matrix;
    }
    public static void escritor(String caminho, String linha) {

        try {
            FileWriter fw = new FileWriter(caminho, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(linha);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
