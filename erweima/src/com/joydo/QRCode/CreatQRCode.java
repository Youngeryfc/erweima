package com.joydo.QRCode;


import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
//生成二维码
public class CreatQRCode {
    public static void main(String []args)throws Exception{
        Qrcode x=new Qrcode();
        x.setQrcodeErrorCorrect('M');    //纠错等级
        x.setQrcodeEncodeMode('B');      //N代表数字，A代表a-z，B代表其他字符
        x.setQrcodeVersion(7);            //版本

        String qrData="www.immoc.com";
        int width=67+12*(7-1);       //固定公式：67+12*（版本号-1）；
        int height=67+12*(7-1);
        //创建一个缓冲区的图片
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //画图工具
        Graphics2D gs=bufferedImage.createGraphics();

        gs.setBackground(Color.white);
        gs.setColor(Color.BLACK);
        gs.clearRect(0,0,width,height);

        //偏移量
        int pixoff=2;

        //往画板中填充内容
        byte[] d=qrData.getBytes("gb2312");
        if(d.length>0 && d.length<120){
            boolean[][] s=x.calQrcode(d);
            for (int i=0;i<s.length;i++){
                for(int j=0;j<s.length;j++){
                    if(s[j][i]){
                        gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);    //不加偏移量可能会导致解析出错
                    }
                }
            }
        }

        gs.dispose();
        bufferedImage.flush();

        ImageIO.write(bufferedImage,"png",new File("d:/upload/qrcode.png"));
    }
}
