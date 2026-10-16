
import java.util.Objects; // Importa recursos para comparar objetos e gerar hashCode. - RA: 25149683-2

public class Cliente { // Define a classe que representa um cliente da NexusCloud. - RA: 25149683-2

    private String cpf; // Armazena o CPF do cliente, usado como identificador único. - RA: 25149683-2
    private String nome; // Armazena o nome do cliente. - RA: 25149683-2

    public Cliente(String cpf, String nome) { // Construtor usado para criar um cliente com CPF e nome. - RA: 25149683-2
        this.cpf = cpf; // Guarda o CPF recebido no atributo do objeto atual. - RA: 25149683-2
        this.nome = nome; // Guarda o nome recebido no atributo do objeto atual. - RA: 25149683-2
    }

    public String getCpf() { // Permite consultar o CPF sem acessar diretamente o atributo privado. - RA: 25149683-2
        return cpf; // Retorna o CPF armazenado no cliente. - RA: 25149683-2
    }

    public String getNome() { // Permite consultar o nome do cliente. - RA: 25149683-2
        return nome; // Retorna o nome armazenado no cliente. - RA: 25149683-2
    }

    @Override // Indica que o método abaixo substitui uma implementação herdada da classe Object. - RA: 25149683-2
    public boolean equals(Object obj) { // Define quando dois clientes devem ser considerados iguais. - RA: 25149683-2
        if (this == obj) return true; // Se for exatamente o mesmo objeto, retorna verdadeiro. - RA: 25149683-2
        if (!(obj instanceof Cliente)) return false; // Se o objeto não for um Cliente, retorna falso. - RA: 25149683-2

        Cliente outro = (Cliente) obj; // Converte o objeto recebido para o tipo Cliente. - RA: 25149683-2
        return Objects.equals(cpf, outro.cpf); // Considera os clientes iguais quando seus CPFs são iguais. - RA: 25149683-2
    }

    @Override // Indica que o método hashCode está sendo sobrescrito. - RA: 25149683-2
    public int hashCode() { // Gera um código hash baseado na identidade do cliente. - RA: 25149683-2
        return Objects.hash(cpf); // Utiliza o CPF para gerar o hash, mantendo a regra do equals. - RA: 25149683-2
    }
}
