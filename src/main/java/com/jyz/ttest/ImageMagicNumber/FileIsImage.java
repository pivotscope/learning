package com.jyz.ttest.ImageMagicNumber;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileIsImage {
	/**   
     * <p>Discription:[isImage,判断文件是否为图片]</p>  
     * @param file  
     * @return true 是 | false 否   
     */  
    public static final boolean isImage(File file){  
        boolean flag = false;  
        try  
        {  
            BufferedImage bufreader = ImageIO.read(file);  
            int width = bufreader.getWidth();  
            int height = bufreader.getHeight();  
            if(width==0 || height==0){  
                flag = false;  
            }else {  
                flag = true;  
            }  
        }  
        catch (IOException e)  
        {  
            flag = false;  
        }catch (Exception e) {  
            flag = false;  
        }  
        return flag;  
    }  
}
