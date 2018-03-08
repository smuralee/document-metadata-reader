# Document Metadata Reader

## Introduction
The document metadata reader is used to extract the metadata of the documents. The supported documents are as follows
* .docx - Microsoft Word Document
* .pdf - PDF Document
* .pptx - Microsoft Powerpoint 
* .xlsx - Microsoft Excel

## Execution
The main file is **`com.smuralee.documents.ReadProperties`**. 
We run the executable jar with the argument having the location of the top-level folder containing the documents.

```bash
java -jar target/document-metadata-reader-1.0-jar-with-dependencies.jar documents/
```

## Output
The successful execution will result in creating the excel file - **Document_Inventory.xlsx** in the directory. 
