/**
 * Copyright 2018 Suraj Muraleedharan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smuralee.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Suraj Muraleedharan
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
