import javax.swing.*;
import java.io.*;
import java.util.Date;

public class PiccopyforStream {
    FileOutputStream fw;
    FileInputStream fr;
    String  extName;
    public PiccopyforStream(String picPath){
        File file=new File(picPath);
        if (!file.exists()){
            JOptionPane.showMessageDialog(null,"文件不存在");
            return;

        }else{
            try{
                extName=picPath.substring(picPath.lastIndexOf("."));//最后一个点的索伊位置
                fw=new FileOutputStream(file);
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
    public void uploadpic(String targetPath) throws IOException {
        File file=new File(targetPath+"/"+new Date().getTime()+extName);
        try{
            fr= new FileInputStream(file);
            int length;
            byte []size=new byte[1024];
            while( (length=fr.read(size))!=-1){
                fw.write(size,0,length);
            }
            fw.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("文件上传成功");
    }
}
