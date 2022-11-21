package it.hillel.server;

import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;


public class ServerEngine {
    private static final int SERVER_PORT = 8888;

    private final ServerSocket serverSocket;
    private CopyOnWriteArrayList<Client> activeConnections = new CopyOnWriteArrayList<>();
    private int clientsCount;


    @SneakyThrows
    public ServerEngine() {
        serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
            new Thread(multiThreadClient()).start();
        }
    }

    @SneakyThrows
    private Runnable multiThreadClient() {
        clientsCount++;
        Socket client = serverSocket.accept();
        String name = "Client-" + clientsCount;
        Date connectionTime = new Date();

        Client newConnections = new Client(name, connectionTime.getTime(), client);
        activeConnections.add(newConnections);
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        for (Client connection : activeConnections) {
            DataOutputStream messageAboutConect =
                    new DataOutputStream(connection.getSocket().getOutputStream());
            messageAboutConect.writeUTF("[SERVER] " + newConnections.getName() + " was connected");
        }
        return () -> {
            try {
                String inBoundMessage;
                while (true) {
                    inBoundMessage = in.readUTF();
                    System.out.println(inBoundMessage);
                    if (inBoundMessage.equals("-exit")) {
                        out.writeUTF("Thank you for the session. Bye!");
                        for (Client connection : activeConnections) {
                            DataOutputStream messageAboutDisconect =
                                    new DataOutputStream(connection.getSocket().getOutputStream());
                            if (connection.getName().equals(newConnections.getName())) {
                                activeConnections.remove(connection);
                            }
                            messageAboutDisconect.writeUTF("[SERVER] " + newConnections.getName()
                                    + " was disconnected");
                        }
                        break;
                    }
                    if (inBoundMessage.toLowerCase().contains("-file")) {
                        getFile(client);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private void getFile(Socket socket) {
        File file = new File("copy_file.txt");
        byte[] data = new byte[1024];

        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream(file);
            int num;
            while (in.read(data) != 1) {
                fos.write(data);
                fos.flush();
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
