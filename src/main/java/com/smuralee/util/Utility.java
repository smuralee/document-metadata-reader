package com.smuralee.util;

import com.itextpdf.text.pdf.PdfDate;
import com.smuralee.documents.dto.FileInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.POIXMLProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public final class Utility {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);

    public static void populateFileInfo(final POIXMLProperties properties, final FileInfo fileInfo) {
        final POIXMLProperties.CoreProperties coreProperties = properties.getCoreProperties();

        // Populating the file information
        fileInfo.setAuthor(coreProperties.getCreator());
        fileInfo.setCreatedBy(coreProperties.getCreator());
        fileInfo.setCreatedDate(coreProperties.getCreated());
        fileInfo.setModifiedBy(coreProperties.getLastModifiedByUser());
        fileInfo.setModifiedDate(coreProperties.getModified());

    }

    public static void populateFileInfo(HashMap<String, String> pdfInfo, FileInfo fileInfo) {

        // Populating the file information
        fileInfo.setAuthor(pdfInfo.get("Author"));
        fileInfo.setCreatedBy(pdfInfo.get("Author"));
        fileInfo.setCreatedDate(getPdfDate(pdfInfo, "CreationDate"));
        fileInfo.setModifiedBy(pdfInfo.get("Author"));
        fileInfo.setModifiedDate(getPdfDate(pdfInfo, "ModDate"));

    }

    public static String getFileExtension(File file) {
        return FilenameUtils.getExtension(file.getName());
    }

    public static String getFileType(File file) {
        return StringConstants.documentTypeMap.get(getFileExtension(file));
    }

    private static Date getPdfDate(final HashMap<String, String> pdfInfo, final String key) {
        final String date = pdfInfo.get(key);
        final Calendar calendar = PdfDate.decode(date);
        return calendar.getTime();
    }

}
