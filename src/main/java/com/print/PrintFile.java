package com.print;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.File;
import java.io.FileInputStream;
/**
 * @ClassName PrintFile
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/2 15:05
 */
public class PrintFile {
    public void printPdf(String fileName) {
        //构造一个文件选择器，默认为当前目录
        File file = new File(fileName);//获取选择的文件
        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用打印服务
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        //定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        // 显示打印对话框
        PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (service != null) {

            try {
                DocPrintJob job = service.createPrintJob(); // 创建打印作业
                FileInputStream fis; // 构造待打印的文件流
                fis = new FileInputStream(file);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        PrintFile pic = new PrintFile();
        pic.printPdf("C:\\Users\\Administrator\\Desktop\\基本信息.txt");
    }
}
