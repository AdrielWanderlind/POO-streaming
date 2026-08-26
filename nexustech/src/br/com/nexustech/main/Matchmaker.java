package br.com.nexustech.main;

public class Matchmaker {

    public void encontrarSala(ModoJogo modo, boolean jogadorBanido)
            throws BanidoException {

        if (jogadorBanido) {
            throw new BanidoException();
        }

        modo.buscarPartida();
    }
}
