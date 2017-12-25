package com.ztf.pdfbookmark;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.SimpleBookmark;

public class CopyBookMark {

	public static void main(String[] args) {
		String pdfFile = args[0];
		try {
			PdfReader reader = new PdfReader(pdfFile + ".pdf");
			List<HashMap<String, Object>> list = SimpleBookmark.getBookmark(reader);
			SimpleBookmark.exportToXML(list, new FileOutputStream(pdfFile + ".xml"), "utf-8", true);
			reader.close();

			PdfReader reader2 = new PdfReader(pdfFile + "_ocr.pdf");
			PdfStamper stamper = new PdfStamper(reader2, new FileOutputStream(pdfFile + "_ocr2.pdf"));
			List<HashMap<String, Object>> bookmarks = SimpleBookmark.importFromXML(new FileReader(pdfFile + ".xml"));
			stamper.setOutlines(bookmarks);
			stamper.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
