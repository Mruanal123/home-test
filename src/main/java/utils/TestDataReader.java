package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
	private Properties properties;

	public TestDataReader(String fileName) {
		try {
			String filePath = System.getProperty("user.dir") + File.separator + "testdata/" + fileName;
			FileInputStream fileInputStream = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load test data file: " + fileName);
		}
	}

	public String getData(String key) {
		return properties.getProperty(key);
	}
}
