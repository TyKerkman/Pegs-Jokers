package com.example.pegsandjokers;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PegsAndJokersApplication {

    public static void main(String[] args) {
        SpringApplication.run(PegsAndJokersApplication.class, args);

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(3306);
        config.setContext("/game/socket.io");
        config.setOrigin("*"); // Allow requests from all origins

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);

        config.setSocketConfig(socketConfig);


        SocketIOServer server = new SocketIOServer(config);

        // Add connect listener
        server.addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient client) {
                System.out.println("Client connected: " + client.getRemoteAddress());
            }
        });

        server.addEventListener("updateBoard", String.class, new DataListener<String>() {
            public void onData(SocketIOClient client, String data, AckRequest ackRequest) throws Exception {
                System.out.println("Received move: " + data);
                // Handle the move here
                // You can send back a response if needed
                // Send the event to every connected client
                for (SocketIOClient connectedClient : server.getAllClients()) {
                    connectedClient.sendEvent("moveResponse", "Move received: " + data);
                }
            }
        });

        server.start();
    }
}