package com.smuralee.documents.types;

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public class WorkbookFileType extends AbstractFileType {

    public WorkbookFileType(File file) {
        super(file);
    }

    @Override
    protected void getAdditionalProperties(FileInfo fileInfo) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(this.getFileStream());
        final POIXMLProperties workbookProps = workbook.getProperties();
        Utility.populateFileInfo(workbookProps, fileInfo);
    }
}
