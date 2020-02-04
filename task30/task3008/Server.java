package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap= new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());

        while(true){
            try {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            } catch (Exception e) {
                serverSocket.close();
                System.out.println(e.getMessage());
                break;
            }
        }

    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String,Connection> entry: connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не отправлено");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;
        private String userName;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message message = connection.receive();
            if (!(message.getType().equals(MessageType.USER_NAME))||message.getData().equals("")||connectionMap.containsKey(message.getData()))
                 return serverHandshake(connection);
            else{
                connectionMap.put(message.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return message.getData();
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String,Connection> entry:connectionMap.entrySet()){
                if(!entry.getKey().equals(userName))
                connection.send(new Message(MessageType.USER_ADDED,entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName + ":" + " " + message.getData()));
                }
                else {
                    ConsoleHelper.writeMessage("Сообщение не является текстом");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connected to "+socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                userName=serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection,userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(String.valueOf(e));
            }
        }
    }
}
