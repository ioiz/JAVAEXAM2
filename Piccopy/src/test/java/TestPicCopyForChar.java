import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class TestPicCopyForChar {
    public static void main(String [] args) throws IOException {
        PiccopyforChar piccopyforChar=null;
        JFileChooser jFileChooser=new JFileChooser();//文件选择器对象
        int i=jFileChooser.showOpenDialog(null);
        if (i==0){
            File selectedFile=jFileChooser.getSelectedFile();
            piccopyforChar=new PiccopyforChar(selectedFile.getAbsolutePath());
         int j=   jFileChooser.showOpenDialog(null);
         if (j==1){
             piccopyforChar.uploadpic(jFileChooser.getSelectedFile().getPath());
         }
        }
        System.out.println("文件上传成功");
    }
}
