package com.joydo.zxing;


import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.util.HashMap;
import java.util.HashMap;

//生成二维码,纠错能力越高，所存储的数据量越少
public class CreateLogoQRCode {
    public static int createQRCode(String content, String imgPath,String logo) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(7);
            // System.out.println(content);
            byte[] contentBytes = content.getBytes("gb2312");
            //构造一个BufferedImage对象 设置宽、高
            BufferedImage bufImg = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, 140, 140);
            // 设定图像颜色 > BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 120) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                System.err.println("QRCode content bytes length = "+ contentBytes.length + " not in [ 0,120 ]. ");
                return -1;
            }
            Image img = ImageIO.read(new File(logo));//实例化一个Image对象。
            gs.drawImage(img, 55, 55, 30, 30, null);
            gs.dispose();
            bufImg.flush();
            // 生成二维码QRCode图片
            File imgFile = new File(imgPath);
            ImageIO.write(bufImg, "png", imgFile);
        }catch (Exception e){
            e.printStackTrace();
            return -100;
        }
        return 0;
    }

    public static void main(String[] args){
        createQRCode("http://vl.alfaromeocollegechina.com/web/0704/main.html",
                "d:/upload/code1.png",
                "d:/upload/logo.png");
    }
}
