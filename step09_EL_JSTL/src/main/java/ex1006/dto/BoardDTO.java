package ex1006.dto;
/**�۹�ȣ ,����, ���� �Ӽ� ����*/
/*
 *  application������ List<BoardDTO>�����Ѵ�.

 * BoardDTO�� �Ӽ�(no, subject, content)

 * application���� 
      application.setAttibute("boarList", �����list);  

          //:center.jsp����k` ${boardList}
         // <c:forEach items="${applicationScope.boardList}"

  -application�� �����ϴ� ����!!! �߿�
    BoardServlet.java  -> �Խù� ����ϱ�
    BoardServlet.java���� init �������� �غ��Ѵ�.
     �׸��� ������ ����Ҷ� <load-on-startup>�����Ѵ�.

     ex)
     public void init(){
       List<BoardDTO> list =new ArrayList<BoardDTO>();
       //���� 3�� �Խù� �ʱ�ġ �����
       list.add(new BoardDTO(....));
       list.add(new BoardDTO(....));
       list.add(new BoardDTO(....));

         * �Խù��� �ʱ�ġ ������ 3���� context-param�� �̿��ؼ� �����Ѵ�. 
        
        ���⼭ application��ü�� ��� ����??? 
         ServletContext application = super.getServletContext();
        list�� application�� �����Ѵ�.
     }

     public void  service(request, response){
         //�Ѿ���� ���޾Ƽ�... -> DTO�������� 
         application�� �ִ� list�� �߰��Ѵ�.

         //�̵��Ѵ�. (index.jsp�̵��Ѵ�)
         <script>
            top.location.href="index.jsp";
         </script>
     }


 */
public class BoardDTO {
	private int no;
	private String subject;
	
	public BoardDTO() {}
	
	public BoardDTO(int no, String subject) {
		super();
		this.no = no;
		this.subject = subject;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
