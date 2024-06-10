package model;

import java.util.ArrayList;
import java.util.List;

public class GestaoUsuarios {
    private final List<Professor> professores = new ArrayList<>();
    private final List<Aluno> alunos = new ArrayList<>();

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }
}
