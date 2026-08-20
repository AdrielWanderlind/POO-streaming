package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.funcionario;

public class MainTechCorp {
    public static void main(String[] args) {
        ControleDeAcesso controleDeAcesso = new ControleDeAcesso();

        // Criação funcionario 1 e 2
        funcionario f1 = new funcionario("T-001", "Alice", null);
        funcionario f2 = new funcionario("T-001", "Alice", null);
        
        //Catraca
        controleDeAcesso.registrarPassagem(f1);
        controleDeAcesso.registrarPassagem(f2);

        //Sala segura
        controleDeAcesso.concederAcessoSala(f1);
        controleDeAcesso.concederAcessoSala(f2);
    }

}
