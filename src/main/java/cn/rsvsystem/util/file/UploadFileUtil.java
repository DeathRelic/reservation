package cn.rsvsystem.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class UploadFileUtil {

	public static String createFileName(String mime) {	
		String fileName = UUID.randomUUID() + "." + mime.split("/")[1] ;
		return fileName ;
	}

	public static boolean save(InputStream inputStream, File destFile) {
		boolean flag = false ;
		OutputStream output = null ;
		if (!destFile.getParentFile().exists()) {	
			destFile.getParentFile().mkdirs() ;	
		}
		try {
			output = new FileOutputStream(destFile) ;
			byte data [] = new byte [2048] ;	
			int temp = 0 ;	
			while ((temp = inputStream.read(data)) != -1) {
				output.write(data, 0, temp);
			} 
			flag = true ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag ;
	}
}
