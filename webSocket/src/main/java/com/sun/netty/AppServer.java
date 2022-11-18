package com.sun.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * author sungw
 *
 * @description 服务端启动类
 * @date 2021/6/18
 */
public class AppServer {
    public static void main(String[] args) throws Exception {
        new AppServer(1111).run();
    }
    private final int port;

    public AppServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        //Netty的Reactor线程池，初始化了一个NioEventLoop数组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.option(ChannelOption.SO_BACKLOG, 1024);
            // 绑定线程池
            sb.group(group)
                    // 指定使用的channel
                    .channel(NioServerSocketChannel.class)
                    // 绑定监听端口
                    .localAddress(this.port)
                    // 绑定客户端连接时候触发操作
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

//                            ch.pipeline().addLast(new LineBasedFrameDecoder(Integer.MAX_VALUE));
//                            ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
//                            //解码格式
//                            ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
//                            //设置超时检测，60s没有回应，则关闭连接
//                            ch.pipeline().addLast(new IdleStateHandler(0, 0, 60, TimeUnit.SECONDS));
//
                     ch.pipeline().addLast(new HandelServer());
                        }
                    });
            // 服务器异步创建绑定
            ChannelFuture cf = sb.bind().sync();
            System.out.println("在"+cf.channel().localAddress()+"上开启监听");
            // 关闭服务器通道
            cf.channel().closeFuture().sync();
        } finally {
            // 释放线程池资源
            group.shutdownGracefully().sync();
        }
    }
}
