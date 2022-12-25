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

import com.itextpdf.text.pdf.PdfDate;
import com.smuralee.documents.dto.FileInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ooxml.POIXMLProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Suraj Muraleedharan
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
