package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleDeAcesso {
    List<funcionario> historicoCatraca = new ArrayList<>();
    Set<funcionario> autorizadosSalaSegura = new HashSet<>();

    public void registrarPassagem(funcionario f) {
        historicoCatraca.add(f);
    }

    public void concederAcessoSala(funcionario f) {
        
        if (autorizadosSalaSegura.contains(f)) {
            System.out.println("Aviso: matrícula já registrada na sala. Acesso não permitido");
        } else {
            autorizadosSalaSegura.add(f);
            System.out.println("Acesso liberado para a Sala Segura");
        }
        
    }

}
