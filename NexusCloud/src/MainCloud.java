
public class MainCloud { // Define a classe que contém o ponto de entrada da aplicação. - RA: 25149683-2

    public static void main(String[] args) { // Método principal executado quando o programa é iniciado. - RA: 25149683-2

        CloudManager manager = new CloudManager(); // Cria o gerenciador dos clientes e servidores. - RA: 25149683-2

        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises"); // Cria o cliente de exemplo com CPF e nome. - RA: 25149683-2

        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50); // Cria um servidor com 16 GB de RAM e preço de R$ 5,50 por hora. - RA: 25149683-2

        manager.registrarCliente(cliente); // Registra o cliente no banco de dados do gerenciador. - RA: 25149683-2
        manager.provisionarServidor(cliente, servidor); // Associa o servidor ao cliente registrado. - RA: 25149683-2

        Container c1 = new Container("C-01", "Aplicacao 1", 10.0); // Cria o primeiro container, que exige 10 GB de RAM. - RA: 25149683-2
        Container c2 = new Container("C-02", "Aplicacao 2", 8.0); // Cria o segundo container, que exige 8 GB de RAM. - RA: 25149683-2

        // Testa a exceção unchecked enquanto o servidor ainda está desligado. - RA: 25149683-2
        // Descomente a linha abaixo para realizar esse teste isoladamente. - RA: 25149683-2
        // servidor.alocarContainer(c1); // Lança ServidorOfflineException porque o servidor começa desligado. - RA: 25149683-2
        // Comente novamente a chamada depois do teste para continuar a execução normal. - RA: 25149683-2

        servidor.ligar(); // Liga o servidor para permitir as tentativas de alocação. - RA: 25149683-2

        try { // Inicia o bloco que pode tratar a exceção checked de capacidade. - RA: 25149683-2
            servidor.alocarContainer(c1); // Tenta alocar o primeiro container, que exige 10 GB de RAM. - RA: 25149683-2
            System.out.println("Container C-01 alocado com sucesso."); // Exibe a confirmação se a alocação for concluída. - RA: 25149683-2
        } catch (CapacidadeExcedidaException e) { // Captura uma eventual falha de capacidade na primeira alocação. - RA: 25149683-2
            System.out.println(e.getMessage()); // Exibe a mensagem de erro recebida da exceção. - RA: 25149683-2
        }

        try { // Inicia o tratamento da exceção na tentativa de alocar o segundo container. - RA: 25149683-2
            servidor.alocarContainer(c2); // Tenta adicionar 8 GB aos 10 GB já utilizados, ultrapassando o limite de 16 GB. - RA: 25149683-2
            System.out.println("Container C-02 alocado com sucesso."); // Só aparece se a segunda alocação for concluída. - RA: 25149683-2
        } catch (CapacidadeExcedidaException e) { // Captura a falha causada pela falta de memória RAM. - RA: 25149683-2
            System.out.println(e.getMessage()); // Exibe a mensagem informando a capacidade excedida. - RA: 25149683-2
        }

        System.out.printf("Fatura ativa: R$ %.2f%n", manager.calcularFaturaAtiva(cliente)); // Exibe a fatura com duas casas decimais. - RA: 25149683-2
    }
}
