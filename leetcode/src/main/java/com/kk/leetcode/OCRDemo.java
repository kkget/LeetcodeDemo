package com.kk.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.security.MessageDigest;
import java.math.BigInteger;
/**
 * @author zhaozhenkun
 * @create 2022-04-01 11:05
 */
@Slf4j
public class OCRDemo {

    public static void main(String[] args) throws IOException {

        // 创建实例
        ITesseract instance = new Tesseract();

        // 设置识别语言

        instance.setLanguage("chi_sim");

        // 设置识别引擎

        instance.setOcrEngineMode(0);

        // 读取文件

        String ocrResultNew = dealImage("C:\\Users\\Admin\\Desktop\\9-160514164SDY.jpg");
        File image = new File(ocrResultNew);
        try {

            // 识别
            String result = instance.doOCR(image);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

    /*public static void main(String[] args) throws TesseractException, IOException {

        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
        //设置训练库的位置
        //instance.setDatapath("the absolute path of tessdata");

        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
        // chi_sim ：简体中文， eng    根据需求选择语言库
        instance.setLanguage("chi_sim");

        // 指定识别图片
        instance.setOcrEngineMode(0);
        long startTime = System.currentTimeMillis();
        String ocrResultNew = dealImage("C:\\Users\\Admin\\Desktop\\9-160514164SDY.jpg");
        File imgDir = new File(ocrResultNew);
        String ocrResult = instance.doOCR(imgDir);
        String el ="/^[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY][\\dABCDEFGHJKLNMxPQRSTUVWXYZ]{5}$/";
        System.out.println("识别结果: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        if(ocrResult.matches(el)){
            // 输出识别结果
            System.out.println("识别结果: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        }else{
            log.error("车牌识别有误");
        }

    }*/
    public static String dealImage(String imagePath) throws IOException {
        String formatName = imagePath.substring(imagePath.indexOf(".") + 1);
        File file = new File(imagePath);
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage outImage = new BufferedImage(width, height, image.getType());
        int backgroudColor = image.getRGB(0, 0);
        int backgroudR = (backgroudColor >> 16) & 0xff;
        int backgroudG = (backgroudColor >> 8) & 0xff;
        int backgroudB = backgroudColor & 0xff;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = image.getRGB(i, j);
                int r = (color >> 16) & 0xff;
                int g = (color >> 8) & 0xff;
                int b = color & 0xff;
                int newColor = color;

                // 去除干扰信息，干扰信息为黑色相近46/256之内全部清理
                if(r < 64 && g < 64 && b < 64) {
                    if(j-1 >= 0)
                        newColor = image.getRGB(i, j-1);
                    else if(i-1 >= 0)
                        newColor = image.getRGB(i-1, j);
                    else if(j+1 < height)
                        newColor = image.getRGB(i, j+1);
                    else if(i+1 < width)
                        newColor = image.getRGB(i+1, j);
                    r = (newColor >> 16) & 0xff;
                    g = (newColor >> 8) & 0xff;
                    b = newColor & 0xff;
                }

                // 去除背景颜色，相近的±30之内的全部设置为白色，灰色的干扰信息改为白色，文字改为黑色
                if(Math.abs((r - backgroudR)) <= 30 && Math.abs((g - backgroudG)) <= 30 && Math.abs((b - backgroudB)) <= 30) {
                    newColor = 0xffffff;
                } else if(r > 150 && g > 150 && b > 150){
                    newColor = 0xffffff;
                } else {
                    newColor = 0x000000;
                }
                outImage.setRGB(i, j, newColor);
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(outImage, formatName, out);
        String outPath = new File(imagePath).getParent() + File.separator + getFileMd5(out.toByteArray()) + "." + formatName;
        File newFile = new File(outPath);
        ImageIO.write(outImage, formatName, newFile);
        log.debug("处理后的验证码文件：" + outPath);

        return outPath;
    }
    /**
     * 根据文件字节流获取文件MD5
     * @param fileBytes
     * @return
     */
    public static String getFileMd5(byte[] fileBytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mdBytes = md.digest(fileBytes);
            BigInteger bigInt = new BigInteger(1, mdBytes);
            return bigInt.toString(16);
        } catch (Exception e) {
            log.error("删除文件失败",e);
            return null;
        }
    }

    public void testDoOCR_ImageByte(byte[] imageByte) {
        log.info("doOCR on a jpg image");
        try {
            InputStream sbs = new ByteArrayInputStream(imageByte);
            BufferedImage img = ImageIO.read(sbs);
            ITesseract instance = new Tesseract();
            //设置语言库所在的文件夹位置，最好是绝对的，不然加载不到就直接报错了
            instance.setDatapath("C:\\Users\\Admin\\Desktop\\9-160514164SDY.jpg");
            //设置使用的语言库类型：chi_sim 中文简体
            instance.setLanguage("chi_sim");
            String result = instance.doOCR(img);
            log.info("扫描的文本："+result);
        } catch (Exception e) {
            log.error("扫描图片文本错误:{}", e);
        }
    }
}
