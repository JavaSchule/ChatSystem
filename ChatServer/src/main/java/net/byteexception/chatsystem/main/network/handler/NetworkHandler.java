package net.byteexception.chatsystem.main.network.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.byteexception.chatsystem.main.network.packet.Packet;

public class NetworkHandler extends SimpleChannelInboundHandler<Packet> {

    /**
     * Handle the incoming packets
     *
     * @param ctx    ChannelHandler context for handling channel
     * @param packet Packet which you want to handle
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        packet.handle(ctx.channel());
    }
}