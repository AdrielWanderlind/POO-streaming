
import java.util.Objects; // Importa recursos para comparar objetos e gerar hashCode. - RA: 25149683-2

public class Container { // Define a classe que representa uma aplicação hospedada em um servidor. - RA: 25149683-2

    private String id; // Armazena o identificador único do container. - RA: 25149683-2
    private String nomeApp; // Armazena o nome da aplicação executada no container. - RA: 25149683-2
    private double ramNecessaria; // Armazena a quantidade de memória RAM exigida pela aplicação. - RA: 25149683-2

    public Container(String id, String nomeApp, double ramNecessaria) { // Construtor que recebe os dados do container. - RA: 25149683-2
        this.id = id; // Define o identificador do container. - RA: 25149683-2
        this.nomeApp = nomeApp; // Define o nome da aplicação. - RA: 25149683-2
        this.ramNecessaria = ramNecessaria; // Define a quantidade de RAM necessária. - RA: 25149683-2
    }

    public String getId() { // Disponibiliza a consulta do identificador do container. - RA: 25149683-2
        return id; // Retorna o identificador armazenado. - RA: 25149683-2
    }

    public String getNomeApp() { // Disponibiliza a consulta do nome da aplicação. - RA: 25149683-2
        return nomeApp; // Retorna o nome da aplicação armazenado. - RA: 25149683-2
    }

    public double getRamNecessaria() { // Disponibiliza a consulta da RAM exigida pela aplicação. - RA: 25149683-2
        return ramNecessaria; // Retorna a quantidade de RAM necessária. - RA: 25149683-2
    }

    @Override // Indica que o método substitui a implementação herdada de Object. - RA: 25149683-2
    public boolean equals(Object obj) { // Define quando dois containers devem ser considerados iguais. - RA: 25149683-2
        if (this == obj) return true; // Retorna verdadeiro quando os dois objetos são a mesma instância. - RA: 25149683-2
        if (!(obj instanceof Container)) return false; // Retorna falso quando o objeto recebido não é um Container. - RA: 25149683-2

        Container outro = (Container) obj; // Converte o objeto recebido para Container. - RA: 25149683-2
        return Objects.equals(id, outro.id); // Considera os containers iguais quando possuem o mesmo ID. - RA: 25149683-2
    }

    @Override // Indica que o método hashCode está sendo sobrescrito. - RA: 25149683-2
    public int hashCode() { // Gera um código hash para identificar o container em Collections. - RA: 25149683-2
        return Objects.hash(id); // Utiliza o ID para gerar o código hash. - RA: 25149683-2
    }
}
