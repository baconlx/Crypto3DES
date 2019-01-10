package main;

import crypto.Crypto3DES;
import util.HexUtil;

public class Main {

	public static void main(String[] args) {
		// define data
		String myDataString = "Secret Message!";
		byte[] myData = myDataString.getBytes();
		byte[] myKey = new byte[] {(byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A, (byte)0x0A};
		byte[] myIV = new byte[] {(byte)0x0B, (byte)0x0B, (byte)0x0B, (byte)0x0B, (byte)0x0B, (byte)0x0B, (byte)0x0B, (byte)0x0B};
		
		System.out.println("myData: " + new String(myData) + " (" + HexUtil.bytesToHex(myData) + ")");
		System.out.println("myKey: " + HexUtil.bytesToHex(myKey));
		System.out.println("myIV: " + HexUtil.bytesToHex(myIV));
		
		// create crypto object
		Crypto3DES crypto = new Crypto3DES(myKey, myIV);
		
		// encrypt data
		byte[] encrypted = crypto.encrypt(myData);
		System.out.println("encrypted: " + new String(encrypted) + " (" + HexUtil.bytesToHex(encrypted) + ")");
		
		// decrypt data
		byte[] decrypted = crypto.decrypt(encrypted);
		System.out.println("decrypted: " + new String(decrypted) + " (" + HexUtil.bytesToHex(decrypted) + ")");
	}
}
