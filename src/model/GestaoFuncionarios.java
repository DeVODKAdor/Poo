package model;

import java.util.ArrayList;
import java.util.List;

public class GestaoFuncionarios {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final List<Cargo> cargos = new ArrayList<>();

    public void cadastrarCargo(Cargo cargo) {
        cargos.add(cargo);
    }

    public List<Cargo> listarCargos() {
        return cargos;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}
