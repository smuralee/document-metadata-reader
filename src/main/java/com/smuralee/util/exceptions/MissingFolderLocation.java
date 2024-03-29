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

package com.smuralee.util.exceptions;

/**
 * @author Suraj Muraleedharan
 */
public class MissingFolderLocation extends RuntimeException {

    public MissingFolderLocation() {
        super();
    }

    public MissingFolderLocation(String s) {
        super(s);
    }

    public MissingFolderLocation(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MissingFolderLocation(Throwable throwable) {
        super(throwable);
    }
}
