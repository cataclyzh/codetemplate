package com.dtdream.ecd.codeGen.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @description 得到当前应用的系统路径
 */
public class SystemPath {

	public static String getSysPath()  {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		String temp = path.replaceFirst("file:/", "").replaceFirst(
				"WEB-INF/classes/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		try {
			resultPath= URLDecoder.decode(resultPath,"utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return resultPath;
	}

	public static String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	public static String getSystempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public static String getSeparator() {
		return System.getProperty("file.separator");
	}

	public static void main(String[] args) {
		System.out.println(getSysPath());
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.println(getSeparator());
		System.out.println(getClassPath());
	}
}
