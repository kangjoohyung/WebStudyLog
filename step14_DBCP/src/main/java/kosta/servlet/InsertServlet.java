package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//���� ����
		String url="error.jsp";
		String errMsg="��ϵ��� �ʾҽ��ϴ�";//�����޼���
		boolean isRedirect=false; //true�̸� redirect���, false�̸� forward������� �� ����
		
		
		// �Է��ؼ� �Ѿ���� ������ �ޱ�
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String age=request.getParameter("age"); //�ִ��� �ߺ�üũ�Ŀ� ���ں�ȯ
		String addr=request.getParameter("addr");
		String phone=request.getParameter("phone");
		//��ȿ�� üũ-�������
		if(id==null||id.equals("")||pwd==null||pwd.equals("")||name==null||
				name.equals("")||age==""||age.equals("")||addr==null||age.equals("")||
				phone==null||phone.equals("")) {
			//if�� ���´ٸ� ���� ������ �ִ�.
			errMsg="�Է°��� ������� �ʽ��ϴ�. \\n�ٽ� Ȯ�����ּ���."; // \n ������ script������
		}else {
			//�ߺ�üũ
			MemberDAO dao=new MemberDAOImpl();
			if(dao.duplicateCheckById(id)) {
				errMsg=id+"�� �̹� ������Դϴ�";
			}else {
				//����ϱ�
				Member member=new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);
				if(dao.insert(member)>0) {//��� ����������
					url="selectAll";//����
					isRedirect=true; //�ʱⰪfalse���� ������ true�� ����
				}//if�� - ��� ���������� ���۰���
			}
		}//��ȿ��-����,�ߺ� üũ ��
		
		
		//������ �����ϸ� selectAll �������� �̵� - redirect��� (scope���� ���ϴϱ� redirect)
		//������ ������ �����޼����� scope�� �����ϰ� error.jsp �̵� - forward���
		if(isRedirect) { //������ redirect����
			response.sendRedirect(url);
		}else { //���н�(�⺻ �ʱⰪ) forward����
			request.setAttribute("errMsg",errMsg);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
