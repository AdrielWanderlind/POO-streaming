package br.com.streaming.main;
import br.com.streaming.financeiro.Boleto;
import br.com.streaming.financeiro.CartaoDeCredito;
import br.com.streaming.financeiro.IPagamento;
import br.com.streaming.financeiro.Pix;
import br.com.streaming.financeiro.ProcessarPagamento;
import br.com.streaming.model.Usuario;

public class MainTeste {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE STREAMING ===");
        
        Usuario u1 = new Usuario(null, null);
        u1.setNome("Joao Silva");
        u1.setEmailString("joao@email.com");

        Usuario u2 = new Usuario(null, null);
        u2.setNome("Renan Silva");
        u2.setEmailString("renan@email.com");

        Usuario u3 = new Usuario(null, null);
        u3.setNome("Lucas Silva");
        u3.setEmailString("lucas@email.com");

        ProcessarPagamento processador = new ProcessarPagamento();
        IPagamento cartao = new CartaoDeCredito(null, 0);
        IPagamento pix = new Pix();
        IPagamento boleto = new Boleto();

        processador.finalizarCompra(cartao, 150.50);
        processador.finalizarCompra(pix, 300.00);
        processador.finalizarCompra(boleto, 50.99);

        if (u1.equals(u2)) {
            System.out.println("Erro: Usuário já existe!");
        } else {
            System.out.println("Cadastro liberado!");
        }

        System.out.println(Usuario.nomePlataforma);
        System.out.println(u1); 
        System.out.println(u2); 
        System.out.println(u3); 
        System.out.println("Total de contas: " + Usuario.contadorUsuarios);
    }
}
