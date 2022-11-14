package ex1006.dto;
/**글번호 ,제목, 내용 속성 관리*/
/*
 *  application영역에 List<BoardDTO>저장한다.

 * BoardDTO의 속성(no, subject, content)

 * application저장 
      application.setAttibute("boarList", 저장된list);  

          //:center.jsp에서k` ${boardList}
         // <c:forEach items="${applicationScope.boardList}"

  -application에 저장하는 시점!!! 중요
    BoardServlet.java  -> 게시물 등록하기
    BoardServlet.java에서 init 영역에서 준비한다.
     그리고 서블릿을 등록할때 <load-on-startup>설정한다.

     ex)
     public void init(){
       List<BoardDTO> list =new ArrayList<BoardDTO>();
       //샘플 3개 게시물 초기치 만들기
       list.add(new BoardDTO(....));
       list.add(new BoardDTO(....));
       list.add(new BoardDTO(....));

         * 게시물의 초기치 데이터 3개를 context-param을 이용해서 제공한다. 
        
        여기서 application객체를 어떻게 구해??? 
         ServletContext application = super.getServletContext();
        list를 application에 저장한다.
     }

     public void  service(request, response){
         //넘어오는 값받아서... -> DTO생성한후 
         application에 있는 list에 추가한다.

         //이동한다. (index.jsp이동한다)
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
