package vip.linhs.stock.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Test2 {

    public static void main(String[] args) {
        String file = "/Users/jin/Downloads/xxxxx.pdf";
        String path = "/Users/jin/Downloads/img/";
        try {
            // 打开pdf文件流
            FileInputStream fis = new FileInputStream(file);
            // 加载 pdf 文档,获取PDDocument文档对象
            PDDocument document = PDDocument.load(fis);
            // 获取PDDocumentCatalog文档目录对象
            PDDocumentCatalog catalog = document.getDocumentCatalog();
            // 获取文档页面PDPage列表
            int pages = document.getNumberOfPages();
            int count = 1;
            for (int j = 1; j < pages; j++) {
                PDPage page = document.getPage(j);
                PDResources resources = page.getResources();
                Iterable xobjects = resources.getXObjectNames();
                if (xobjects != null) {
                    Iterator imageIter = xobjects.iterator();
                    while (imageIter.hasNext()) {
                        COSName key = (COSName) imageIter.next();
                        if (resources.isImageXObject(key) && (!key.getName().equals("QuickPDFIm848de7a9"))) {
                            try {
                                PDImageXObject image = (PDImageXObject) resources.getXObject(key);
                                BufferedImage bimage = image.getImage();
                                ImageIO.write(bimage, "jpg", new File(path + count + ".jpg"));
                                count++;
                                System.out.println(count);
                            } catch (Exception e) {
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}