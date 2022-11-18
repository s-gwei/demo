package com.sun.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author sungw
 *
 * @description
 * @date 2021/6/18
 * 服务器Handel,IO处理类
 */
@ChannelHandler.Sharable
@Slf4j
public class HandelServer extends ChannelInboundHandlerAdapter {


    //通道数组，保存所有注册到Eventloop的通道
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     *
     * @param ctx
     * @param msg
     * 处理接收到客户端的消息，并给客户端发送消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        //处理接收到的数据，并反馈到客户端
        ByteBuf in = (ByteBuf)msg;
        System.out.println("客户端发送的消息"+in.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好，我是服务端",CharsetUtil.UTF_8));
    }


    /**
     * 处理异常
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(ctx);
        cause.printStackTrace();
        //关闭通道
        ctx.close();
    }



    /**
     * 增加通道出发本方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //新建立的连接触发的动作
        Channel channel = ctx.channel();
        System.out.println("客户端"+channel.remoteAddress()+"已连接");

        channels.add(channel);
    }

    /**
     * 断开连接出发本方法
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //新建立的连接触发的动作
        Channel channel = ctx.channel();
        System.out.println("客户端"+channel.remoteAddress()+"断开连接");
        channels.remove(channel);
    }

    /**
     * 建立通道触发本方法,只会在通道建立触发一次
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        log.info("与"+ctx.channel().localAddress()+"建立连接，通道开启！");
        Channel channel = ctx.channel();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
        String strDate = sdf.format(new Date());
        ctx.writeAndFlush(Unpooled.copiedBuffer("这是服务端在channelActive返回的数据"+strDate,CharsetUtil.UTF_8));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
//        log.info("客户端"+channel.remoteAddress()+"断开连接");
        channels.remove(channel);
    }
}
