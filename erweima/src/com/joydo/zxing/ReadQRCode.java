package com.joydo.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class ReadQRCode {
    public static void main(String []args){
        try {
            MultiFormatReader formatReader=new MultiFormatReader();
            File file=new File("d:/upload/img.png");
            BufferedImage image= ImageIO.read(file);
            BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            //定义二维码的参数
            HashMap hints=new HashMap();
            //设置字符编码
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

            Result result=formatReader.decode(binaryBitmap, hints);

            System.out.println("解析结果："+result.toString());
            System.out.println("二维码格式："+result.getBarcodeFormat());
            System.out.println("二维码文本："+result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
