package br.com.streaming.financeiro;

public class ProcessarPagamento {
    public void finalizarCompra(IPagamento pagamento, double valor){
        System.out.println("Iniciando processamento...");
        pagamento.efetuarPagamento(valor);
        System.out.println("Processamento finalizado com sucesso!");
    }
}
