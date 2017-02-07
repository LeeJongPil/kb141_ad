package org.kb141.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileMaker {
	
	private FileOutputStream fos;
	private FileInputStream fis;
	
	public void sendFile(MultipartFile file){
		
		try{
			byte fileData[] = file.getBytes();
			
			fos= new FileOutputStream( "C://zzz//upload//" + file.getOriginalFilename());
			IOUtils.copy(file.getInputStream(), fos);
			fos.write(fileData);
			
			}catch(Exception e){
			e.printStackTrace();
			
			}finally{
				
				if(fos != null){
				
					try{
					fos.close();
					}catch (Exception e) {}
			}//if end
		}// finally end
		
	}
	
	public byte[] pushFile(String fileName) throws IOException{
		int count=0;
		InputStream fis = new FileInputStream("C://zzz//upload//"+fileName);
		byte[] readBuffer = new byte[fis.available()];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((count=fis.read(readBuffer)) != -1){
			baos.write(readBuffer,0,count);
		}

		return readBuffer;
	}

}
