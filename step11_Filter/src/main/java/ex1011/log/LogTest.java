package ex1011.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log=LogFactory.getLog(super.getClass());

	public static void main(String[] args) {
		System.out.println("----메인 시작----");
		
		LogTest t=new LogTest();
		t.test();
		
		System.out.println("----메인 끝----");
	}

	public void test() {
		//로그 기록 (다 할 필요없이, info했으니 info만 하면 됨)
		//log.trace("trace에 관련된 로그");
		//log.debug("debug에 관련된 로그");
		log.info("info에 관련된 로그");
		//log.warn("warn에 관련된 로그");
		//log.error("error에 관련된 로그");
		//log.fatal("fatal에 관련된 로그");
	}
}
