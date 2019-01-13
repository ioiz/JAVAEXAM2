import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PiccopyforChar {
    FileReader fr;
    FileWriter fw;
    String  extName;
    public PiccopyforChar(String picPath){
        File file=new File(picPath);
        if (!file.exists()){
            JOptionPane.showMessageDialog(null,"文件不存在");
            return;

        }else{
            try{
                extName=picPath.substring(picPath.lastIndexOf("."));//最后一个点的索伊位置
                fr=new FileReader(file);
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }


    public void uploadpic(String targetPath) throws IOException {
        File file=new File(targetPath+"/"+new Date().getTime()+extName);
        try{
            fw=new FileWriter(file);
            int length;
            char[] size=new char[1024];
            while( (length=fr.read(size))!=-1){
                fw.write(length);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        fw.close();
        fr.close();
    }

}
