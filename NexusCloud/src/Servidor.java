
import java.util.ArrayList; // Importa a implementação ArrayList para armazenar os containers em uma lista. - RA: 25149683-2
import java.util.List; // Importa a interface List utilizada para declarar a lista de containers. - RA: 25149683-2
import java.util.Objects; // Importa recursos para comparar objetos e gerar hashCode. - RA: 25149683-2

public class Servidor { // Define a classe que representa um servidor da NexusCloud. - RA: 25149683-2

    private String ip; // Armazena o endereço IP que identifica o servidor. - RA: 25149683-2
    private double precoPorHora; // Armazena o preço cobrado por hora de utilização do servidor. - RA: 25149683-2
    private double ramTotal; // Armazena a capacidade total de memória RAM do servidor. - RA: 25149683-2
    private boolean statusLigado; // Indica se o servidor está ligado ou desligado. - RA: 25149683-2
    private List<Container> containers = new ArrayList<>(); // Inicializa a lista que armazenará os containers alocados. - RA: 25149683-2

    public Servidor(String ip, double ramTotal, double precoPorHora) { // Construtor que recebe os dados necessários para criar um servidor. - RA: 25149683-2
        this.ip = ip; // Armazena o IP recebido no atributo do objeto atual. - RA: 25149683-2
        this.ramTotal = ramTotal; // Define a capacidade total de RAM do servidor. - RA: 25149683-2
        this.precoPorHora = precoPorHora; // Define o preço por hora do servidor. - RA: 25149683-2
        this.statusLigado = false; // Define que o servidor começa desligado. - RA: 25149683-2
    }

    public void ligar() { // Define o método responsável por ligar o servidor. - RA: 25149683-2
        statusLigado = true; // Altera o estado do servidor para ligado. - RA: 25149683-2
    }

    public void desligar() { // Define o método responsável por desligar o servidor. - RA: 25149683-2
        statusLigado = false; // Altera o estado do servidor para desligado. - RA: 25149683-2
    }

    public void alocarContainer(Container c) throws CapacidadeExcedidaException { // Tenta alocar um container e declara a exceção checked de capacidade. - RA: 25149683-2

        if (!statusLigado) { // Verifica se o servidor está desligado antes de tentar alocar o container. - RA: 25149683-2
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado."); // Interrompe a operação e lança uma exceção se o servidor estiver desligado. - RA: 25149683-2
        }

        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) { // Soma a RAM utilizada à RAM exigida pelo novo container e verifica se o limite será ultrapassado. - RA: 25149683-2
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + "."); // Lança uma exceção checked quando não existe memória suficiente. - RA: 25149683-2
        }

        containers.add(c); // Adiciona o container à lista somente se as validações forem aprovadas. - RA: 25149683-2
    }

    public double calcularRamEmUso() { // Calcula a quantidade total de RAM utilizada pelos containers alocados. - RA: 25149683-2
        return containers.stream() // Cria um fluxo para processar os containers existentes na lista. - RA: 25149683-2
                .mapToDouble(Container::getRamNecessaria) // Obtém a RAM necessária de cada container como um valor double. - RA: 25149683-2
                .sum(); // Soma os valores de RAM e retorna o total utilizado. - RA: 25149683-2
    }

    public String getIp() { // Permite consultar o endereço IP do servidor. - RA: 25149683-2
        return ip; // Retorna o IP armazenado. - RA: 25149683-2
    }

    public double getPrecoPorHora() { // Permite consultar o preço por hora do servidor. - RA: 25149683-2
        return precoPorHora; // Retorna o preço por hora armazenado. - RA: 25149683-2
    }

    public double getRamTotal() { // Permite consultar a capacidade total de memória RAM. - RA: 25149683-2
        return ramTotal; // Retorna a capacidade total de RAM. - RA: 25149683-2
    }

    public boolean isStatusLigado() { // Permite verificar se o servidor está ligado. - RA: 25149683-2
        return statusLigado; // Retorna true se o servidor estiver ligado ou false se estiver desligado. - RA: 25149683-2
    }

    public List<Container> getContainers() { // Permite consultar a lista de containers do servidor. - RA: 25149683-2
        return containers; // Retorna a lista de containers alocados no servidor. - RA: 25149683-2
    }

    @Override // Indica que o método abaixo substitui a implementação herdada da classe Object. - RA: 25149683-2
    public boolean equals(Object obj) { // Define quando dois servidores devem ser considerados iguais. - RA: 25149683-2
        if (this == obj) return true; // Retorna true quando os dois objetos são a mesma instância. - RA: 25149683-2
        if (!(obj instanceof Servidor)) return false; // Retorna false se o objeto recebido não for um Servidor. - RA: 25149683-2

        Servidor outro = (Servidor) obj; // Converte o objeto recebido para o tipo Servidor. - RA: 25149683-2
        return Objects.equals(ip, outro.ip); // Considera dois servidores iguais quando possuem o mesmo IP. - RA: 25149683-2
    }

    @Override // Indica que o método hashCode está sendo sobrescrito. - RA: 25149683-2
    public int hashCode() { // Gera um código hash baseado na identidade do servidor. - RA: 25149683-2
        return Objects.hash(ip); // Utiliza o IP para gerar o hash de acordo com a regra definida em equals. - RA: 25149683-2
    }
}
