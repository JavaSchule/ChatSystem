package net.byteexception.chatsystem.main;

import net.byteexception.chatsystem.main.network.Server;
import net.byteexception.chatsystem.main.network.handler.NetworkHandler;
import net.byteexception.chatsystem.main.network.handler.PacketDecoder;
import net.byteexception.chatsystem.main.network.handler.PacketEncoder;
import net.byteexception.chatsystem.main.network.utils.ConnectableAdress;
import net.byteexception.chatsystem.main.utils.Contact;
import net.byteexception.chatsystem.main.utils.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mike
 * @version 1.0
 */
public class ChatServer {

    private final Server server = new Server(new ConnectableAdress("localhost", 50000));
    private final List<Message> messages = new ArrayList<>();
    private final List<Contact> contacts = new ArrayList<>();


    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
        setUpServer();
    }

    private final void setUpServer() {
        this.server.bind(() -> {
        }, channel -> channel.pipeline().addLast(new PacketEncoder()).addLast(new PacketDecoder()).addLast(new NetworkHandler()));
    }
}
