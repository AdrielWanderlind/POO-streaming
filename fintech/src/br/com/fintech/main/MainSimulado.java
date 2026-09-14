package br.com.fintech.main;

import java.util.HashSet;
import java.util.Set;

import br.com.fintech.exception.LimiteTransacoesExcedidoException;
import br.com.fintech.model.CarteiraDigital;
import br.com.fintech.model.GatewayPagamentos;
import br.com.fintech.model.Transacao;

public class MainSimulado {
    public static void main(String[] args) {
        Transacao t1 = new Transacao("TX-101-BR", "PIX", 400.00, 2.00);
        Transacao t2 = new Transacao("TX-102-BR", "CARTAO", 1500.00, 45.00);
        Transacao t3 = new Transacao("TX-103-BR", "PIX", 600.00, 3.00);
        Transacao t4 = new Transacao("TX-104-BR", "BOLETO", 200.00, 2.50);

        System.out.println(t1);
        System.out.println(t4);

        Set<Transacao> auditoria = new HashSet<>();
        auditoria.add(t1);
        auditoria.add(new Transacao("TX-101-BR", "PIX", 990.00, 4.95));
        auditoria.add(t2);
        System.out.println("Tamanho da auditoria(HashSet):" + auditoria.size());

        try{
            new Transacao("", "PIX", 10.0, 0.1);
        }  catch(IllegalArgumentException e){
        System.out.println("Construtor validado: " + e.getMessage());
        }

        CarteiraDigital carteira = new CarteiraDigital("WALLET-001", 3);

        try{
            carteira.adicionarTransacao(t1);
            System.out.println("Transacao" + t1.getIdTransacao() + " adicionada com sucesso.");
            carteira.adicionarTransacao(t2);
            System.out.println("Transacao" + t2.getIdTransacao() + " adicionada com sucesso.");
            carteira.adicionarTransacao(t3);
            System.out.println("Transacao" + t3.getIdTransacao() + " adicionada com sucesso.");
            carteira.adicionarTransacao(t4);
        } catch(LimiteTransacoesExcedidoException e){
            System.out.println("Excecao capturada: " + e.getMessage());
        }
        
        carteira.calcularTarifaTotal();
        System.out.println("Tarifa total: " + carteira.calcularTarifaTotal());
        carteira.contarPorTipo("PIX");
        System.out.println("Transacoes PIX: " + carteira.contarPorTipo("PIX"));
        carteira.calcularTarifaPorTipo("PIX");
        System.out.println("Tarifa PIX: " + carteira.calcularTarifaPorTipo("PIX"));

        GatewayPagamentos gateway = new GatewayPagamentos();
        gateway.cadastrarCarteira(carteira);
        System.out.println("Carteira 'WALLET-001' cadastrada no gateway.");
        System.out.println("Carteira " + gateway.buscarCarteira("WALLET-001").getCodigoCarteira() + " recuperada do gateway.");
    }
}
