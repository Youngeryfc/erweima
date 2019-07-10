package com.joydo.QRCode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

public class MYQRCodeImage implements QRCodeImage {
    BufferedImage bufferedImage;
    public MYQRCodeImage(BufferedImage bufferedImage){
        this.bufferedImage=bufferedImage;
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public int getPixel(int i, int j) {
        return bufferedImage.getRGB(i,j);
    }
}
