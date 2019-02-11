package com.drcl.traincore.util.alipay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class SignUtils {
	private static Logger logger = LoggerFactory.getLogger(SignUtils.class);

	private static final String ALGORITHM = "RSA";

	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	private static final String DEFAULT_CHARSET = "UTF-8";

	public static String sign(String content, String privateKey) {
		logger.debug(content);
		logger.debug(privateKey);
		logger.debug(String.valueOf(Base64.decode(privateKey) == null) );
		try {
			//String ALGORITHM1="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALZihbCvEDBKwguCpto1L5guvz+0E+FppKStatIQ5v9toQmj1UxtfBIiKEpClDa2VkFZKShGSoTxsjWB8s1YQruSx9z/x1ny+fsnyEVSaTz2Xe1ANcZouD0VAV3gRwWUuexVxXMtDHzDMVGXbFOOE4ix1Np6otB2YKgBBmmN3lTvAgMBAAECgYAfmaRmP37Dj0BdtC5qokpzyK20QOQs6xvuuGlIqksLuJftTqiXTGTx0189tpltfVwmiGc8JimlLSdeY/yInaE6CceHpZEjyCFlkP1xXE73rB79ubrUcHTaTCRE2DoMmBToVmmEnIpTsAwJGd494YG7uS7IlsGSgKeRwoCyjQRM+QJBAN05yBCEBdpjCo53kJbZncfCAijBn9TvpUXFJRb1I/KrocXDfvlsx7VzBbSe9FRgSKncI4PsrtF6RgvPnW8ICDMCQQDTDcSPHOGVTiX/5Tm1n89E0td7z+fT5TVVHjbtMQmDLiNZbdq5bjzyg9splhMNEcyaGQElyDTwCo7pRwGPEfRVAkBO/tUL4LjeVMNuQA+nbinDLOnsd8eFF9XiZhVqbzrY6qSno7lxg4CEsH/3EVOZ1Y/c57je4OND9e+RRB+piCq1AkEAurYBYAJS5v09zMaDaVQ5z08fZt8k3mZ16hlSyj+JhM26ZBE1YLpPnNRdfMrRi8xlTyYzx7L4citFBsbUcDeYCQJBAMdqLKVJgc5BLe+5jJyld4AJHzRfwJ0lEDLeOj3bKgRjGIk7ekXPjFRYNuF/fGEYCyfANT0pEYerqspIQ61kguQ=";
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));

			byte[] signed = signature.sign();

			return Base64.encodeToString(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
