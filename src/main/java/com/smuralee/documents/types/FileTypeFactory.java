package com.smuralee.documents.types;

import com.smuralee.util.StringConstants;
import com.smuralee.util.Utility;

import java.io.File;

/**
 * @author Suraj Muraleedharan (smuralee)
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
