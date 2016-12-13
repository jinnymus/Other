package test;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import data.ByteRow;

public class ToTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteRow b = new ByteRow();
		byte[] sendBytes = b.buildRequest("1", "1", "007", "676280389963783811", "1502", "000000000500", "0001");
        System.out.println("[ToTest] sendBytes: " + new String(sendBytes));
		//String t = "008731312E3030372E2E30393146303242302E313B2E3B3637363238303338393936333738333831313D31353032313031303034323530323134333F2E2E4149412043422E3030303030303030303530302E33373F3A313032343B3D3F3C3A3234332E2E2E2E32303030313030303030303030303030303030303030303030302E4544323433373838";
	}
}
