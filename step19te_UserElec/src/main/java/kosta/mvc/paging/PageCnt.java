package kosta.mvc.paging;

/**
 * 페이징처리 클래스
 * int pageCnt : 총 페이지수
 * int pageSize : (초기값:20) 한 페이지당 출력 데이터 수(게시글)
 * int pageNo : (초기값:1) 현재페이지 번호
 * int blockCount : (초기값:10) 블럭당 페이지 수(예: 이전 1 2 3 4 5 이후)
 * @author Buck
 *
 */
public class PageCnt {
	private static int pageCnt ; //총페이지 수Math.ceil(전체레코드수 /pageSize) 
	public static int pageSize =20;// 한 페이지 당 20개 출력물
	public static int pageNo =1;
	
	public  int blockCount=10;
	
	//String keyField;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageCnt) {
		super();
		this.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public static int getpageSize() {
		return pageSize;
	}

	public static void setpageSize(int pageSize) {
		PageCnt.pageSize = pageSize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		PageCnt.pageNo = pageNo;
	}

	public int getblockCount() {
		return blockCount;
	}

	public void setblockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	
}
