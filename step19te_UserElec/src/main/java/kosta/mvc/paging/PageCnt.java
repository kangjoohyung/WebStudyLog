package kosta.mvc.paging;

/**
 * ����¡ó�� Ŭ����
 * int pageCnt : �� ��������
 * int pageSize : (�ʱⰪ:20) �� �������� ��� ������ ��(�Խñ�)
 * int pageNo : (�ʱⰪ:1) ���������� ��ȣ
 * int blockCount : (�ʱⰪ:10) ���� ������ ��(��: ���� 1 2 3 4 5 ����)
 * @author Buck
 *
 */
public class PageCnt {
	private static int pageCnt ; //�������� ��Math.ceil(��ü���ڵ�� /pageSize) 
	public static int pageSize =20;// �� ������ �� 20�� ��¹�
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
