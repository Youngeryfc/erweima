package com.joydo.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//生成二维码,纠错能力越高，所存储的数据量越少
public class CreateQRCode {
    public static void main(String args[]){
        int width=600;
        int height=600;
        String format="png";
        //二维码的内容和需要跳转的路径
        String content="http://vl.alfaromeocollegechina.com/web/0704/main.html";

        //定义二维码的参数
        HashMap hints=new HashMap();
        //设置字符编码
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置边框边距
        hints.put(EncodeHintType.MARGIN,2);

        //生成二维码
        try{
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path file=new File("D:/upload/ar.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        }catch (Exception e){

        }
    }
}
