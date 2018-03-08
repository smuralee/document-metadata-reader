package com.smuralee.documents.types;

import com.itextpdf.text.pdf.PdfReader;
import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public class PdfFileType extends AbstractFileType {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFileType.class);

    public PdfFileType(File file) {
        super(file);
    }

    @Override
    protected void getAdditionalProperties(FileInfo fileInfo) throws IOException {
        PdfReader pdfReader = new PdfReader(this.getFileStream());
        final HashMap<String, String> pdfInfo = pdfReader.getInfo();
        Utility.populateFileInfo(pdfInfo, fileInfo);
    }
}
