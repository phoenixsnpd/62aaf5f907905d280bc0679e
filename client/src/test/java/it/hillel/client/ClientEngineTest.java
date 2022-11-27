package it.hillel.client;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

public class ClientEngineTest {
    @SneakyThrows
    @Test
    void ReturnsTrueIfTheClientWasBoundToTheAddressOrThrowConnectException() {
        ServerSocket serverSocket = new ServerSocket(8888);
        ClientEngine clientEngine = new ClientEngine();
        Assertions.assertTrue(clientEngine.getSocket().isBound());
    }

}
