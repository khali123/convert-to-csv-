import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		File outputFile=new File("C:\\Users\\pc\\eclipse-workspace\\ged-export\\boby.json");
		List<String> documents =new ArrayList<String>();
		documents.add("doc1");
		documents.add("doc2");
		
		StringBuffer data = new StringBuffer();

		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outputFile, false), "ISO-8859-1"));

		for (String string : documents) {
			if (string != null)
				data.append(encodeString(string,"ISO-8859-1") + '\n');
		}

		writer.write(data.toString());

		writer.close();
	}
	private static String encodeString(String text, String encode) throws UnsupportedEncodingException {

		byte[] byteText = text.getBytes(Charset.forName(encode));

		String originalString = new String(byteText, encode);

		return originalString;
	}
	
	

}
