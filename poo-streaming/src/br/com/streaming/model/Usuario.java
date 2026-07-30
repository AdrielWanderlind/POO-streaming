package br.com.streaming.model;

import java.util.List;

public class Usuario {
    private String nome;
    private String emailString;
    private boolean ativo;
    private List <Video>historicoAssistidos;
    public void assistirVideo(Video v){};
}
