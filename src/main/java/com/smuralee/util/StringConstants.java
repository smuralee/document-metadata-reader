package com.smuralee.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public final class StringConstants {


    public static final String FILE_NAME = "Name";
    public static final String FILE_TYPE = "Type";
    public static final String FILE_PATH = "Location";
    public static final String FILE_AUTHOR = "Author";
    public static final String CREATED_BY = "Created By";
    public static final String CREATED_DATE = "Created Date";
    public static final String MODIFIED_BY = "Modified By";
    public static final String MODIFIED_DATE = "Last modified date";
    public static final String DOC_EXTN = "docx";
    public static final String XLSX_EXTN = "xlsx";
    public static final String PDF_EXTN = "pdf";
    public static final String PPTX_EXTN = "pptx";
    public static final String DOC_TYPE = "Microsoft Word Document";
    public static final String XLSX_TYPE = "Microsoft Excel";
    public static final String PDF_TYPE = "PDF";
    public static final String PPTX_TYPE = "Microsoft";
    public static final Map<String, String> documentTypeMap = new HashMap<>();
    public static final String TAB_NAME = "Document Inventory";
    public static final String DOT = ".";
    public static final String GENERATED_FILE_NAME = "Document_Inventory.xlsx";

    static {
        documentTypeMap.put(DOC_EXTN, DOC_TYPE);
        documentTypeMap.put(XLSX_EXTN, XLSX_TYPE);
        documentTypeMap.put(PDF_EXTN, PDF_TYPE);
        documentTypeMap.put(PPTX_EXTN, PPTX_TYPE);
    }
    private StringConstants() {
    }


}
