package com.learnyeai.file.fastdfs;

import org.springframework.stereotype.Component;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;

/**
 * Created by zpz on 2018/9/3.
 */
public class FeignUtils {
    private Decoder decoder;
    private Encoder encoder;
    private Client client;
    private Contract contract;
    private static FeignUtils instance;
    public FeignUtils(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.decoder = decoder;
        this.encoder = encoder;
        this.client = client;
        this.contract = contract;
        instance = this;
    }

    public static <T> T buildCleign(String url, Class<T> clzz){
        return Feign.builder().client(instance.client)
//                .encoder(instance.encoder)
//                .decoder(instance.decoder)
//                .contract(instance.contract)
                .target(clzz, url);
    }
}
