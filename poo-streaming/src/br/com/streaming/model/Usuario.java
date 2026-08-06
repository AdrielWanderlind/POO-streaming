package br.com.streaming.model;

import java.util.List;

public class Usuario {
    private String nome;
    private String emailString;
    private boolean ativo;
    private List <Video>historicoAssistidos;
    public void assistirVideo(Video v){}
    public static int contadorUsuarios;
    public static final String nomePlataforma= "JavaFlix";

    public Usuario(String emailString, String nome){
        this.emailString=emailString;
        this.nome=nome;
        this.ativo=true;
        contadorUsuarios++;

    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emailString == null) ? 0 : emailString.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (emailString == null) {
            if (other.emailString != null)
                return false;
        } else if (!emailString.equals(other.emailString))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", emailString=" + emailString + ", ativo=" + ativo + ", historicoAssistidos="
                + historicoAssistidos + "]";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmailString() {
        return emailString;
    }
    public void setEmailString(String emailString) {
        this.emailString = emailString;
    };
}

