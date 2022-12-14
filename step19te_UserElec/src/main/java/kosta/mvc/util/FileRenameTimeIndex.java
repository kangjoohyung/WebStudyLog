package kosta.mvc.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * ??Ό ?λ‘λ? ?΄λ¦? λ³?κ²? (μ€λ³΅λ°©μ?) ?΄??€
 * -> κΈ°μ‘΄??Όλͺ?+??±?κ°?+μ€λ³΅indexλ‘? λ³?κ²?
 * 
 * ?λ‘λ ??Ό?΄λ¦? : κΈ°μ‘΄??Όλͺ?_yyyy-MM-dd_hhMMss_sss
 * μ€λ³΅? ??Ό?΄λ¦? : κΈ°μ‘΄??Όλͺ?_yyyy-MM-dd_hhMMss_sss(1~9999)
 * 
 * ?¬?©??1
 * MultipartRequest m = 
 * 		new MultipartRequest(request,saveDir, maxSize, 
 * 					encoding, new FileRenameTimeIndex());
 * 
 * ?¬?©??2
 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
 * file = new FileRenameTimeIndex().rename(file);
 * 
 * @author κ°μ£Ό?
 *
 */
public class FileRenameTimeIndex implements FileRenamePolicy {
   
	//??Όλͺ? λ³?κ²? λ©μ?
	/**
	 * ?¬?©??
	 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
	 * file = new FileRenameTimeIndex().rename(file);
	 * @param f (??Ό?΄λ¦?)
	 * @return f (λ³?κ²½ν ?΄λ¦?)
	 */
	public File rename(File f) {//File f? ?λ³? ??Ό
		//if (createNewFile(f)) return f;//??±? fκ°? μ€λ³΅?μ§? ??Όλ©? λ¦¬ν΄ -> ?κ°λ?κ²½μΌλ‘? ?¬?© ??¨
     
		String name = f.getName();
		String body = null;
		String ext = null;
	 
		int dot = name.lastIndexOf(".");
		if (dot != -1) {//??₯?κ°? ???
		  body = name.substring(0, dot);
		  ext = name.substring(dot);
		} else { //??₯?κ°? ???
			body = name;
			ext = "";
		}
 
		//?΄λ¦μ λΆμΌ ?κ°? κ΅¬νκΈ?
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //?κ°? κ΅¬νκΈ?(λ°?λ¦¬μΈμ»¨λκΉμ?)
		SimpleDateFormat timeSdf = new SimpleDateFormat ("yyyy-MM-dd_hhMMss_sss"); //?¬λ§·λ?κ²?
		
		if(createNewFile(f)==true) { //μ€λ³΅ ??€λ©? ?κ°λ§ λΆμ΄κΈ?
			
			String newNameTime = body + "_" + timeSdf.format(timestamp)+ext; //κΈ°μ‘΄??Όλͺ?_?κ°?+??₯?
			f = new File(f.getParent(), newNameTime);
			
		}else{ //μ€λ³΅? ??Ό?΄ ??? ??Ό?΄λ¦λ€? (1~9999)κΉμ? λΆμ΄κΈ?
			int count=1;
			
			while (!createNewFile(f) && count <= 9999) {
				String newNameIndex = 
						body + "_" + timeSdf.format(timestamp) + "(" + count + ")" + ext;
				f = new File(f.getParent(), newNameIndex);
			}
		}
		 return f;
	}
 
	/**
	 * μ€λ³΅?¬λΆ? μ²΄ν¬ λ©μ?
	 * @param f
	 * @return μ€λ³΅??? κ·Έλ?λ‘? λ¦¬ν΄/μ€λ³΅? falseλ‘? λ¦¬ν΄
	 */
	private boolean createNewFile(File f) { 
		try {//f.exists() try~
			return f.createNewFile(); //μ‘΄μ¬?? ??Ό?΄ ??λ©?
		}catch (IOException ignored) {
			return false;
		}
	
	}
}
