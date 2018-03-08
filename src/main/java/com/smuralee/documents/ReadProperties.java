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

package com.smuralee.documents;

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.documents.types.AbstractFileType;
import com.smuralee.documents.types.FileTypeFactory;
import com.smuralee.util.PrimitiveConstants;
import com.smuralee.util.StringConstants;
import com.smuralee.util.exceptions.MissingFolderLocation;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Suraj Muraleedharan
 */
public class ReadProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadProperties.class);

    public static void main(String[] args) throws IOException {

        // Check if the root folder location is provided
        if (args.length != PrimitiveConstants.ONE) {
            throw new MissingFolderLocation("The location for the root directory is missing");
        }

        // Fetch the location
        final String rootFolder = args[PrimitiveConstants.ZERO];
        final File rootDir = new File(rootFolder);

        // Defining the file AbstractFileType
        String[] types = {
                StringConstants.DOC_EXTN,
                StringConstants.PDF_EXTN,
                StringConstants.PPTX_EXTN,
                StringConstants.XLSX_EXTN
        };

        // Get the files from the root location
        final Collection<File> files = FileUtils.listFiles(rootDir, types, true);
        final List<FileInfo> details = new LinkedList<>();

        for (File file : files) {
            final AbstractFileType fileType = FileTypeFactory.getFileType(file);
            final FileInfo fileInfo = fileType.getMetadata();
            details.add(fileInfo);
        }

        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(StringConstants.TAB_NAME);
        int rowCount = PrimitiveConstants.ZERO;

        // Headers
        Row headerRow = sheet.createRow(rowCount);
        headerRow.createCell(0).setCellValue(StringConstants.FILE_NAME);
        headerRow.createCell(1).setCellValue(StringConstants.FILE_TYPE);
        headerRow.createCell(2).setCellValue(StringConstants.FILE_PATH);
        headerRow.createCell(3).setCellValue(StringConstants.FILE_AUTHOR);
        headerRow.createCell(4).setCellValue(StringConstants.CREATED_BY);
        headerRow.createCell(5).setCellValue(StringConstants.CREATED_DATE);
        headerRow.createCell(6).setCellValue(StringConstants.MODIFIED_BY);
        headerRow.createCell(7).setCellValue(StringConstants.MODIFIED_DATE);

        CellStyle contentStyle = workbook.createCellStyle();
        contentStyle.setBorderBottom(BorderStyle.THIN);
        contentStyle.setBorderLeft(BorderStyle.THIN);
        contentStyle.setBorderRight(BorderStyle.THIN);
        contentStyle.setBorderTop(BorderStyle.THIN);

        CellStyle dateStyle = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        dateStyle.setBorderBottom(BorderStyle.THIN);
        dateStyle.setBorderLeft(BorderStyle.THIN);
        dateStyle.setBorderRight(BorderStyle.THIN);
        dateStyle.setBorderTop(BorderStyle.THIN);
        dateStyle.setDataFormat(format.getFormat("m/d/yy h:mm"));

        Cell cell = null;
        for (FileInfo fileInfo : details) {

            Row dataRow = sheet.createRow(++rowCount);

            // Document name
            cell = dataRow.createCell(0);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getName()));
            cell.setCellStyle(contentStyle);

            // Document type
            cell = dataRow.createCell(1);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getType()));
            cell.setCellStyle(contentStyle);

            // Location
            cell = dataRow.createCell(2);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getPath()));
            cell.setCellStyle(contentStyle);

            // Author
            cell = dataRow.createCell(3);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getAuthor()));
            cell.setCellStyle(contentStyle);

            // Created by
            cell = dataRow.createCell(4);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getCreatedBy()));
            cell.setCellStyle(contentStyle);

            // Created date
            cell = dataRow.createCell(5);
            cell.setCellValue(fileInfo.getCreatedDate());
            cell.setCellStyle(dateStyle);

            // Modified by
            cell = dataRow.createCell(6);
            cell.setCellValue(new XSSFRichTextString(fileInfo.getModifiedBy()));
            cell.setCellStyle(contentStyle);

            // Modified date
            cell = dataRow.createCell(7);
            cell.setCellValue(fileInfo.getModifiedDate());
            cell.setCellStyle(dateStyle);
        }

        FileOutputStream out = new FileOutputStream(new File(
                StringConstants.DOT +
                        File.separator +
                        StringConstants.GENERATED_FILE_NAME));
        workbook.write(out);
        out.close();
        workbook.close();
    }
}
