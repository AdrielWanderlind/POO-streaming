
public class CapacidadeExcedidaException extends Exception { // Cria uma exceção personalizada para indicar falta de memória RAM. - RA: 25149683-2

    public CapacidadeExcedidaException(String msg) { // Construtor que recebe a mensagem de erro. - RA: 25149683-2
        super(msg); // Envia a mensagem para a classe Exception, permitindo recuperá-la com getMessage(). - RA: 25149683-2
    }
}
