package com.smuralee.documents.types;

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan (smuralee)
 */
public abstract class AbstractFileType {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFileType.class);

    protected File file;

    protected AbstractFileType(File file) {
        this.file = file;
    }

    protected FileInfo extractProperties() throws IOException {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(this.file.getName());
        fileInfo.setPath(this.file.getAbsolutePath());
        fileInfo.setType(Utility.getFileType(this.file));
        this.getAdditionalProperties(fileInfo);
        return fileInfo;
    }

    protected abstract void getAdditionalProperties(FileInfo fileInfo) throws IOException;

    protected FileInputStream getFileStream() throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = FileUtils.openInputStream(this.file);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return inputStream;
    }

    public FileInfo getMetadata() {
        FileInfo fileInfo = null;
        try {
            fileInfo = this.extractProperties();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return fileInfo;
    }
}
