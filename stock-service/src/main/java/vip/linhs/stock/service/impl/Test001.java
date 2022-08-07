package vip.linhs.stock.service.impl;


import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.exporting.text.SimpleTextExtractionStrategy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test001 {
    public static void main(String[] args) throws IOException {
        //加载测试文档
        PdfDocument pdf = new PdfDocument("C:\\Users\\peter\\Downloads\\111.pdf");

        //实例化StringBuilder类
        StringBuilder sb = new StringBuilder();
        //定义一个int型变量
        int index = 0;

        //遍历PDF文档中每页
        PdfPageBase pp = pdf.getPages().get(100);
        System.out.println(pp.extractText(false).substring(110,130).replaceAll("\n",""));

        PdfPageBase page;
        for (int i= 0; i<pdf.getPages().getCount();i++) {
            page = pdf.getPages().get(i);
            //调用extractText()方法提取文本
            String text1 = page.extractText(false);
            String text2 = text1.replace("Evaluation Warning : The document was created with Spire.PDF for Java.","");
//            String text3 = text2.substring(0,text2.length()-20);
            sb.append(text2);
            FileWriter writer;
            try {
                //将StringBuilder对象中的文本写入到txt
                writer = new FileWriter("D:\\learnNotes\\00ExtractText.txt");
                writer.write(sb.toString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            //调用extractImages方法获取图片
//            for (BufferedImage image : page.extractImages()) {
//                //指定输出图片名，指定图片格式
//                File output = new File(String.format("Image_%d.png", index++));
//                ImageIO.write(image, "PNG", output);
//            }
        }
        System.out.println(sb);
        pdf.close();
    }
}


