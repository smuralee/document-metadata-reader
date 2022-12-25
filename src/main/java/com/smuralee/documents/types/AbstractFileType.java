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

import com.smuralee.documents.dto.FileInfo;
import com.smuralee.util.Utility;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan
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
