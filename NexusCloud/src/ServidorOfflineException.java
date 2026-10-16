
public class ServidorOfflineException extends RuntimeException { // Cria uma exceção personalizada para tentativas de uso de servidor desligado. - RA: 25149683-2

    public ServidorOfflineException(String msg) { // Construtor que recebe a mensagem que explica o erro. - RA: 25149683-2
        super(msg); // Armazena a mensagem na exceção para que possa ser exibida. - RA: 25149683-2
    }
}
