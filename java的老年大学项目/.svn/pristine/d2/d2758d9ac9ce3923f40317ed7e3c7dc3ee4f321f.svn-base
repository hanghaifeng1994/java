package com.learnyeai.tools.security;


public class DERCoder {
	
	private static final String Index = "03";
	private static final String pre = "00";
    private static final String flag = "02";//开始结束标志
	private static final String bitMode = "81";
	
	public static DERCoder getInstance(){
		return new DERCoder();
	}
	
	    /**
     * DER转码
     * 
     * @param pubkey
     *            裸公钥
     * @return
     */
	public static String generateDerCoder(String pubkey){
		pubkey = pre+pubkey;
		int pubKeyLen = pubkey.length()/2;
		String result = (Integer.toHexString(pubKeyLen)).length()==1?("0"+Integer.toHexString(pubKeyLen)):Integer.toHexString(pubKeyLen);
		pubkey = flag+bitMode+result+pubkey+generateSuffix();
		pubKeyLen = pubkey.length()/2;
		result = (Integer.toHexString(pubKeyLen)).length()==1?("0"+Integer.toHexString(pubKeyLen)):Integer.toHexString(pubKeyLen);
		return "30"+bitMode+result+pubkey;
	}

	private static String generateSuffix(){
		int len = Index.length()/2;
		String result = (Integer.toHexString(len)).length()==1?("0"+Integer.toHexString(len)):Integer.toHexString(len);
		return flag+result+Index;
	}
	
	public static void main(String[] args){
		String pubKey = "9B0096A9B4BDEF5B6EC1F01DFB2A51F1F4AC3AA2836EAE632AEC1E79E26F0F191A00DB5CA1B831D95DE85D4794D521E9EC96E85E29B6340ADD9D3DFC1EF6B5B1C2E3D3841367AC48087DEA1DFD92130E34804F38685E78EFC1308BEF05F998C7374E38F6B5591BE66D4465231EEA52421972F3C61411C43A3CBEA5158943D879";
		System.out.println(generateDerCoder(pubKey));
	}
}
