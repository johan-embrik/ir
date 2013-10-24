Document doc = new Document();
Field pathField = new Field("path", file.getPath(), Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS);
pathField.setIndexOptions(IndexOptions.DOCS_ONLY);
doc.add(pathField);
NumericField modifiedField = new NumericField("modified");
modifiedField.setLongValue(file.lastModified());
doc.add(modifiedField);
doc.add(new Field("contents", new BufferedReader(new InputStreamReader(fis, "UTF-8"))));
if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
           // New index, so we just add the document (no old document can be there):
           System.out.println("adding " + file);
           writer.addDocument(doc);
         } else {
           // Existing index (an old copy of this document may have been indexed) so 
           // we use updateDocument instead to replace the old one matching the exact 
           // path, if present:
           System.out.println("updating " + file);
           writer.updateDocument(new Term("path", file.getPath()), doc);
         }

