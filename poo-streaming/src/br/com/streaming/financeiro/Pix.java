package br.com.streaming.financeiro;

public class Pix implements IPagamento{
    private int chave;

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    @Override
    public void efetuarPagamento(double valor) {
        System.out.println("Gerando a chave PIX copia e cola...");
        System.out.println("Aguardando transferência de R$ " +valor + " . ");
    }

    
}
