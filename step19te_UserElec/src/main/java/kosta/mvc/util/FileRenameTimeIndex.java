package kosta.mvc.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * ?ŒŒ?¼ ?—…ë¡œë“œ?‹œ ?´ë¦? ë³?ê²? (ì¤‘ë³µë°©ì?) ?´?˜?Š¤
 * -> ê¸°ì¡´?ŒŒ?¼ëª?+?ƒ?„±?‹œê°?+ì¤‘ë³µindexë¡? ë³?ê²?
 * 
 * ?—…ë¡œë“œ ?ŒŒ?¼?´ë¦? : ê¸°ì¡´?ŒŒ?¼ëª?_yyyy-MM-dd_hhMMss_sss
 * ì¤‘ë³µ?‹œ ?ŒŒ?¼?´ë¦? : ê¸°ì¡´?ŒŒ?¼ëª?_yyyy-MM-dd_hhMMss_sss(1~9999)
 * 
 * ?‚¬?š©?˜ˆ?‹œ1
 * MultipartRequest m = 
 * 		new MultipartRequest(request,saveDir, maxSize, 
 * 					encoding, new FileRenameTimeIndex());
 * 
 * ?‚¬?š©?˜ˆ?‹œ2
 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
 * file = new FileRenameTimeIndex().rename(file);
 * 
 * @author ê°•ì£¼?˜•
 *
 */
public class FileRenameTimeIndex implements FileRenamePolicy {
   
	//?ŒŒ?¼ëª? ë³?ê²? ë©”ì†Œ?“œ
	/**
	 * ?‚¬?š©?˜ˆ?‹œ
	 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
	 * file = new FileRenameTimeIndex().rename(file);
	 * @param f (?ŒŒ?¼?´ë¦?)
	 * @return f (ë³?ê²½í›„ ?´ë¦?)
	 */
	public File rename(File f) {//File f?Š” ?›ë³? ?ŒŒ?¼
		//if (createNewFile(f)) return f;//?ƒ?„±?œ fê°? ì¤‘ë³µ?˜ì§? ?•Š?œ¼ë©? ë¦¬í„´ -> ?‹œê°„ë?ê²½ìœ¼ë¡? ?‚¬?š© ?•ˆ?•¨
     
		String name = f.getName();
		String body = null;
		String ext = null;
	 
		int dot = name.lastIndexOf(".");
		if (dot != -1) {//?™•?¥?ê°? ?—†?„?•Œ
		  body = name.substring(0, dot);
		  ext = name.substring(dot);
		} else { //?™•?¥?ê°? ?ˆ?„?•Œ
			body = name;
			ext = "";
		}
 
		//?´ë¦„ì— ë¶™ì¼ ?‹œê°? êµ¬í•˜ê¸?
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //?‹œê°? êµ¬í•˜ê¸?(ë°?ë¦¬ì„¸ì»¨ë“œê¹Œì?)
		SimpleDateFormat timeSdf = new SimpleDateFormat ("yyyy-MM-dd_hhMMss_sss"); //?¬ë§·ë?ê²?
		
		if(createNewFile(f)==true) { //ì¤‘ë³µ ?—†?‹¤ë©? ?‹œê°„ë§Œ ë¶™ì´ê¸?
			
			String newNameTime = body + "_" + timeSdf.format(timestamp)+ext; //ê¸°ì¡´?ŒŒ?¼ëª?_?‹œê°?+?™•?¥?
			f = new File(f.getParent(), newNameTime);
			
		}else{ //ì¤‘ë³µ?œ ?ŒŒ?¼?´ ?ˆ?„?•Œ ?ŒŒ?¼?´ë¦„ë’¤?— (1~9999)ê¹Œì? ë¶™ì´ê¸?
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
	 * ì¤‘ë³µ?—¬ë¶? ì²´í¬ ë©”ì†Œ?“œ
	 * @param f
	 * @return ì¤‘ë³µ?—†?„?‹œ ê·¸ë?ë¡? ë¦¬í„´/ì¤‘ë³µ?‹œ falseë¡? ë¦¬í„´
	 */
	private boolean createNewFile(File f) { 
		try {//f.exists() try~
			return f.createNewFile(); //ì¡´ì¬?•˜?Š” ?ŒŒ?¼?´ ?•„?‹ˆë©?
		}catch (IOException ignored) {
			return false;
		}
	
	}
}
