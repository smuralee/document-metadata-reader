package com.smuralee.util.exceptions;

/**
 * @author Suraj Muraleedharan (smuralee)
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
