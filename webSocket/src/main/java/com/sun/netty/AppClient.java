package com.sun.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * author sungw
 *
 * @description 客户端启动类
 * @date 2021/6/18
 */
public class AppClient {

    public static void main(String[] args) throws InterruptedException {
        new AppClient("127.0.0.1",1111).run();
    }

    private final int port ;

    private final String  host ;

    public AppClient(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void run() throws InterruptedException {
        //IO线程池
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        try {
            //客户端辅助启动类
            Bootstrap bs = new Bootstrap();
            //初始化配置
            bs.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //超时检测handle
                            ch.pipeline().addLast(new IdleStateHandler(5,0,0, TimeUnit.SECONDS));
                            //添加自定义的Handle处理器
                            ch.pipeline().addLast(new HandlerClient());
                        }
                    });
            //连接到远程节点，等待连接完成
            ChannelFuture future = bs.connect().sync();
            System.out.println("在"+future.channel().localAddress()+"被监听");

            while(true){
                Thread.sleep(6000);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
                String str= sdf.format(new Date());
                future.channel().writeAndFlush(Unpooled.copiedBuffer("我是心跳声音"+str+"\r\n",CharsetUtil.UTF_8));
            }
            //连接成功发送消息到服务端，编码格式维utf-8
//            future.channel().writeAndFlush(Unpooled.copiedBuffer("你好，我是sungw", CharsetUtil.UTF_8));
            //阻塞操作，closeFuture开启了channel的监听器，避免连接断开
//            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            group.shutdownGracefully().sync();

        }

    }
}
