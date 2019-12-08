package com.example.demo.util;



import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;


public class AdminLog {

	private Logger log = Logger.getLogger(AdminLog.class.getName());

	public void logError(String message) {
		log.error(message); //2016/07/21 22:50:24.976 [main] ERROR  テスト
	}
	public void runSample(){

		URL fileXmlUrl = Loader.getResource("log4j.xml");
		// 設定ファイルを読み込む
	    DOMConfigurator.configure(fileXmlUrl);

		String a = "テスト";

		log.trace(a); // 出力なし
        log.debug(a); //2016/07/21 22:50:24.975 [main] DEBUG  テスト
        log.info(a); //2016/07/21 22:50:24.975 [main] INFO   テスト
        log.warn(a); //2016/07/21 22:50:24.976 [main] WARN   テスト
        log.error(a); //2016/07/21 22:50:24.976 [main] ERROR  テスト
        log.fatal(a); //2016/07/21 22:50:24.976 [main] FATAL  テスト
	}


//	public static void main(String[] args) {
//		runSample();
// 	}
}
