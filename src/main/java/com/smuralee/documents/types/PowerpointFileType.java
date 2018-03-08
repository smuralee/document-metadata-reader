package com.smuralee.documents.types;

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.File;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public class PowerpointFileType extends AbstractFileType {

    public PowerpointFileType(File file) {
        super(file);
    }

    @Override
    protected void getAdditionalProperties(FileInfo fileInfo) throws IOException {
        XMLSlideShow pptx = new XMLSlideShow(this.getFileStream());
        final POIXMLProperties pptxProps = pptx.getProperties();
        Utility.populateFileInfo(pptxProps, fileInfo);
    }

}
