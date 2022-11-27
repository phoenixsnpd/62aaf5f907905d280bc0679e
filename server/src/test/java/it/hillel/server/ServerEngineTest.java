package it.hillel.server;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ServerEngineTest {
    @Test
    void ReturnsTrueIfTheServerWasBoundToTheAddressOrThrowConnectException() {
        ServerEngine server = new ServerEngine();
        Assertions.assertTrue(server.getServerSocket().isBound());
    }
}
