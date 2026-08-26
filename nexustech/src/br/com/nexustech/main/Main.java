package br.com.nexustech.main;

import br.com.nexustech.exception.NivelInsuficienteException;
import br.com.nexustech.model.Masmorra;

public class Main {

    public static void main(String[] args) {

        // EXERCÍCIO 1 e 2 - Bug do K/D
        int kills = 15;
        int deaths = 0;

        try {
            System.out.println(kills / deaths);
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }


        // EXERCÍCIO 3 - Inventário Bugado
        String[] inventario = new String[3];

        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventário cheio!");
        }


        // EXERCÍCIO 4 - NullPointer
        String jogador = null;

        if (jogador != null) {
            System.out.println(jogador);
        } else {
            System.out.println("Jogador desconectado");
        }


        // EXERCÍCIO 6 e 7 - Queda de Internet
        try {
            conectarServidor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fechando portas de rede do jogo...");
        }


        // EXERCÍCIO 9 - Masmorra
        Masmorra masmorra = new Masmorra();

        try {
            masmorra.entrar(20);
        } catch (NivelInsuficienteException e) {
            System.out.println(e.getMessage());
        }


        // BOSS - Matchmaker
        Matchmaker matchmaker = new Matchmaker();

        ModoJogo casual = new ModoCasual();
        ModoJogo ranqueado = new ModoRanqueado();

        try {
            matchmaker.encontrarSala(casual, true);
            matchmaker.encontrarSala(ranqueado, false);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }
    }


    // EXERCÍCIO 5
    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }
}
