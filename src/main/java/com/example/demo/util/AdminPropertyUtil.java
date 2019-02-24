package com.example.demo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * プロパティから値を取得してMapへ格納する.
 * @author eharada
 *
 */
public class AdminPropertyUtil {

	public Map getProperty(Map propertiesMap) {

		String PROP_FILE = "src/main/resources/ValidationMessages.properties";

		Properties prop = new Properties();

		// プロパティファイル読み込み
		try {
			prop.load(new FileInputStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Mapへ取得したProperty値をセット
		for (Entry<Object, Object> e : prop.entrySet()) {
			propertiesMap.put(e.getKey(),e.getValue());
		}

		return propertiesMap;
	}
}
