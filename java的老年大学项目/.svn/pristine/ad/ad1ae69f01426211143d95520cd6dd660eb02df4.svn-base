package com.learnyeai.learnai.utils.smg;


import com.learnyeai.learnai.utils.smg.util.SmsService;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Administrator on 2016/6/17 0017.
 */
public class SmsSerivceImp implements ISmsService {

    @Override
    public void sendSmg(String telephone, String code) throws UnsupportedEncodingException,MalformedURLException {
        try {
            SmsService.sendSmscode(telephone, code);
        }catch (RuntimeException e){
            throw e;
        }catch (UnsupportedEncodingException u){
            throw u;
        }catch (MalformedURLException m){
            throw m;
        }
    }

    @Override
    public void sendSmg(String telephone, String tplId, String tplValue) throws UnsupportedEncodingException, MalformedURLException {
        try {
            SmsService.sendSmscode(telephone, tplId,tplValue);
        }catch (RuntimeException e){
            throw e;
        }catch (UnsupportedEncodingException u){
            throw u;
        }catch (MalformedURLException m){
            throw m;
        }
    }


}
