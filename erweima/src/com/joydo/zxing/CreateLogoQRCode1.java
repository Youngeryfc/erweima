package com.joydo.zxing;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

//生成二维码,纠错能力越高，所存储的数据量越少
public class CreateLogoQRCode1 {
    public static int createQRCode(String content, String imgPath,String logo) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(7);
            // System.out.println(content);
            byte[] contentBytes = content.getBytes("gb2312");
            //构造一个BufferedImage对象 设置宽、高
            BufferedImage bufImg = new BufferedImage(360, 360, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, 360, 360);
            // 设定图像颜色 > BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 260) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j *8 + pixoff, i * 8 + pixoff, 8, 8);
                        }
                    }
                }
            } else {
                System.err.println("QRCode content bytes length = "+ contentBytes.length + " not in [ 0,120 ]. ");
                return -1;
            }
            Image img = ImageIO.read(new File(logo));//实例化一个Image对象。
            gs.drawImage(img, 150, 150, 50, 50, null);
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
                "d:/upload/ar.png",
                "d:/upload/logo.png");
    }
}
