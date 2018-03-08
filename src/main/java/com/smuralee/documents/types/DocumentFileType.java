package com.smuralee.documents.types;

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public class DocumentFileType extends AbstractFileType {

    public DocumentFileType(File file) {
        super(file);
    }

    @Override
    protected void getAdditionalProperties(FileInfo fileInfo) throws IOException {
        XWPFDocument document = new XWPFDocument(this.getFileStream());
        final POIXMLProperties documentProps = document.getProperties();
        Utility.populateFileInfo(documentProps, fileInfo);
    }
}
