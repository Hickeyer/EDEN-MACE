package com.dist.api.utils.http;

import org.apache.http.conn.ssl.AbstractVerifier;

import javax.net.ssl.SSLException;

public class SkipHostnameVerifier extends AbstractVerifier {

	/**
	 * 跳过hostname的检查
	 */
	@Override
	public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
		return;
	}

}
