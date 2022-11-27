package it.hillel.server;

import lombok.*;

import java.net.Socket;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    private String name;
    private Long connectionTime;
    private Socket socket;
}
