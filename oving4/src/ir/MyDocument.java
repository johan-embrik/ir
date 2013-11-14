package ir;

import java.io.File;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;

public class MyDocument {

	public static Document Document(File f)
			throws java.io.FileNotFoundException {

		// make a new, empty document
		Document doc = new Document();

		// use the news document wrapper
		NewsDocument newsDocument = new NewsDocument(f);

		//TODO create structured lucene document
		
		// return the document
		return doc;
	}

}
