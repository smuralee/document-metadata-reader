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
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.File;
import java.io.IOException;

/**
 * @author Suraj Muraleedharan
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
