package ex1011.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log=LogFactory.getLog(super.getClass());

	public static void main(String[] args) {
		System.out.println("----���� ����----");
		
		LogTest t=new LogTest();
		t.test();
		
		System.out.println("----���� ��----");
	}

	public void test() {
		//�α� ��� (�� �� �ʿ����, info������ info�� �ϸ� ��)
		//log.trace("trace�� ���õ� �α�");
		//log.debug("debug�� ���õ� �α�");
		log.info("info�� ���õ� �α�");
		//log.warn("warn�� ���õ� �α�");
		//log.error("error�� ���õ� �α�");
		//log.fatal("fatal�� ���õ� �α�");
	}
}
