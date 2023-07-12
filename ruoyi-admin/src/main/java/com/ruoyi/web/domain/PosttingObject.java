package com.ruoyi.web.domain;


import com.ruoyi.web.netty.NettyClient;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @Author : baye
 * @Date : 2023/3/15 17:04
 * @Code : bug and work
 * @Description : Netty消息实体类
 */
public class PosttingObject {
    private NettyClient nettyClient;


    private NioEventLoopGroup nioEventLoopGroup;

    public NettyClient getNettyClient() {
        return nettyClient;
    }

    public void setNettyClient(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    public NioEventLoopGroup getNioEventLoopGroup() {
        return nioEventLoopGroup;
    }

    public void setNioEventLoopGroup(NioEventLoopGroup nioEventLoopGroup) {
        this.nioEventLoopGroup = nioEventLoopGroup;
    }
}
