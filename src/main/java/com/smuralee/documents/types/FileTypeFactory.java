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

package com.smuralee.documents.types;

import com.smuralee.util.StringConstants;
import com.smuralee.util.Utility;

import java.io.File;

/**
 * @author Suraj Muraleedharan
 */
public class FileTypeFactory {

    public static AbstractFileType getFileType(File file) {
        final String fileExtension = Utility.getFileExtension(file);
        AbstractFileType fileType = null;

        if (isDocument(fileExtension)) {
            fileType = new DocumentFileType(file);
        } else if (isWorkbook(fileExtension)) {
            fileType = new WorkbookFileType(file);
        } else if (isPresentation(fileExtension)) {
            fileType = new PowerpointFileType(file);
        } else if (isPDF(fileExtension)) {
            fileType = new PdfFileType(file);
        }

        return fileType;
    }

    private static boolean isDocument(String fileExtension) {
        return StringConstants.DOC_EXTN.equalsIgnoreCase(fileExtension);
    }

    private static boolean isWorkbook(String fileExtension) {
        return StringConstants.XLSX_EXTN.equalsIgnoreCase(fileExtension);
    }

    private static boolean isPresentation(String fileExtension) {
        return StringConstants.PPTX_EXTN.equalsIgnoreCase(fileExtension);
    }

    private static boolean isPDF(String fileExtension) {
        return StringConstants.PDF_EXTN.equalsIgnoreCase(fileExtension);
    }
}
