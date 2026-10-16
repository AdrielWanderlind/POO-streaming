
import java.util.HashMap; // Importa a implementação HashMap para armazenar pares de chave e valor. - RA: 25149683-2
import java.util.HashSet; // Importa HashSet para armazenar servidores sem duplicações. - RA: 25149683-2
import java.util.Map; // Importa a interface Map para relacionar clientes aos seus servidores. - RA: 25149683-2
import java.util.Set; // Importa a interface Set para representar conjuntos de servidores. - RA: 25149683-2

public class CloudManager { // Define a classe que gerencia os clientes e seus servidores. - RA: 25149683-2

    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>(); // Associa cada cliente ao seu conjunto de servidores. - RA: 25149683-2

    public CloudManager() { // Construtor responsável por criar uma instância do gerenciador. - RA: 25149683-2
    } // Encerra o construtor sem operações adicionais. - RA: 25149683-2

    public void registrarCliente(Cliente c) { // Registra o cliente sem substituir um cadastro que já existe. - RA: 25149683-2
        bancoDeDados.putIfAbsent(c, new HashSet<>()); // Cria um conjunto vazio somente se o cliente ainda não estiver cadastrado. - RA: 25149683-2
    }

    public void provisionarServidor(Cliente c, Servidor s) { // Associa um servidor ao cliente informado. - RA: 25149683-2
        registrarCliente(c); // Garante que o cliente esteja cadastrado antes de associar o servidor. - RA: 25149683-2
        bancoDeDados.get(c).add(s); // Adiciona o servidor ao conjunto do cliente, sem duplicações conforme equals e hashCode. - RA: 25149683-2
    }

    public double calcularFaturaAtiva(Cliente c) { // Calcula a soma dos preços por hora dos servidores ligados de um cliente. - RA: 25149683-2
        return bancoDeDados.getOrDefault(c, new HashSet<>()) // Obtém os servidores do cliente ou um conjunto vazio se ele não estiver cadastrado. - RA: 25149683-2
                .stream() // Cria um fluxo para processar os servidores do conjunto. - RA: 25149683-2
                .filter(Servidor::isStatusLigado) // Mantém somente os servidores cujo status esteja ligado. - RA: 25149683-2
                .mapToDouble(Servidor::getPrecoPorHora) // Extrai o preço por hora de cada servidor aprovado pelo filtro. - RA: 25149683-2
                .sum(); // Soma os preços e retorna o valor total da fatura ativa. - RA: 25149683-2
    }
}
