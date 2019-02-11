package com.learnyeai.learnai.codec;

/**
 * Created by zpz on 2016/4/19.
 */
public class MessageCoder {
    /**
     * @FieldName: decoder
     * @FieldType: MessageDecoder[]
     * @Description: 解码器
     */
    private IMessageDecoder[] decoder;

    /**
     * @FieldName: encoder
     * @FieldType: MessageEncoder[]
     * @Description: 编码器
     */
    private IMessageEncoder[] encoder;

    /**
     * @return the decoder
     */
    public IMessageDecoder[] getDecoder() {
        return decoder;
    }

    /**
     * @param decoder the decoder to set
     */
    public void setDecoder(IMessageDecoder decoder) {
        this.setDecoder(new IMessageDecoder[]{decoder});
    }

    /**
     * @param decoder the decoder to set
     */
    public void setDecoder(IMessageDecoder[] decoder) {
        this.decoder = decoder;
    }

    /**
     * @return the encoder
     */
    public IMessageEncoder[] getEncoder() {
        return encoder;
    }

    /**
     * @param encoder the encoder to set
     */
    public void setEncoder(IMessageEncoder encoder) {
        this.setEncoder(new IMessageEncoder[]{encoder});
    }

    /**
     * @param encoder the encoder to set
     */
    public void setEncoder(IMessageEncoder[] encoder) {
        this.encoder = encoder;
    }

}

