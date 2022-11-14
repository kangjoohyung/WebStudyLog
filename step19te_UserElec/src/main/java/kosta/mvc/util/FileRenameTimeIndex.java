package kosta.mvc.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * ?��?�� ?��로드?�� ?���? �?�? (중복방�?) ?��?��?��
 * -> 기존?��?���?+?��?��?���?+중복index�? �?�?
 * 
 * ?��로드 ?��?��?���? : 기존?��?���?_yyyy-MM-dd_hhMMss_sss
 * 중복?�� ?��?��?���? : 기존?��?���?_yyyy-MM-dd_hhMMss_sss(1~9999)
 * 
 * ?��?��?��?��1
 * MultipartRequest m = 
 * 		new MultipartRequest(request,saveDir, maxSize, 
 * 					encoding, new FileRenameTimeIndex());
 * 
 * ?��?��?��?��2
 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
 * file = new FileRenameTimeIndex().rename(file);
 * 
 * @author 강주?��
 *
 */
public class FileRenameTimeIndex implements FileRenamePolicy {
   
	//?��?���? �?�? 메소?��
	/**
	 * ?��?��?��?��
	 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
	 * file = new FileRenameTimeIndex().rename(file);
	 * @param f (?��?��?���?)
	 * @return f (�?경후 ?���?)
	 */
	public File rename(File f) {//File f?�� ?���? ?��?��
		//if (createNewFile(f)) return f;//?��?��?�� f�? 중복?���? ?��?���? 리턴 -> ?��간�?경으�? ?��?�� ?��?��
     
		String name = f.getName();
		String body = null;
		String ext = null;
	 
		int dot = name.lastIndexOf(".");
		if (dot != -1) {//?��?��?���? ?��?��?��
		  body = name.substring(0, dot);
		  ext = name.substring(dot);
		} else { //?��?��?���? ?��?��?��
			body = name;
			ext = "";
		}
 
		//?��름에 붙일 ?���? 구하�?
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //?���? 구하�?(�?리세컨드까�?)
		SimpleDateFormat timeSdf = new SimpleDateFormat ("yyyy-MM-dd_hhMMss_sss"); //?��맷�?�?
		
		if(createNewFile(f)==true) { //중복 ?��?���? ?��간만 붙이�?
			
			String newNameTime = body + "_" + timeSdf.format(timestamp)+ext; //기존?��?���?_?���?+?��?��?��
			f = new File(f.getParent(), newNameTime);
			
		}else{ //중복?�� ?��?��?�� ?��?��?�� ?��?��?��름뒤?�� (1~9999)까�? 붙이�?
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
	 * 중복?���? 체크 메소?��
	 * @param f
	 * @return 중복?��?��?�� 그�?�? 리턴/중복?�� false�? 리턴
	 */
	private boolean createNewFile(File f) { 
		try {//f.exists() try~
			return f.createNewFile(); //존재?��?�� ?��?��?�� ?��?���?
		}catch (IOException ignored) {
			return false;
		}
	
	}
}
