package com.sun.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author sungw
 *
 * @description netty客服端
 * @date 2021/6/18
 * 处理输入输出 I/O事件
 *@ChannelHandler.Sharable为了线程安全
 */
@ChannelHandler.Sharable
public class HandlerClient extends SimpleChannelInboundHandler<ByteBuf> {
    /**
     *
     * @param channelHandlerContext
     * @param byteBuf
     * @throws Exception
     *
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

       //处理接收到的消息
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
    }

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     * 处理异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        //关闭连接
        ctx.close();
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx,Object evt) throws Exception {

        //超时检测
        super.userEventTriggered(ctx, evt);
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            if(event.state() == IdleState.READER_IDLE){
                System.out.println("客户端读取数据包超时");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
                String str= sdf.format(new Date());
                ctx.writeAndFlush(Unpooled.copiedBuffer("我是心跳声音"+str+"\r\n",CharsetUtil.UTF_8));
            }
        }
    }
}
