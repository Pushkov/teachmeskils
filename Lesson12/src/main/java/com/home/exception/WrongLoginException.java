package com.home.exception;

import java.util.regex.PatternSyntaxException;

public class WrongLoginException extends PatternSyntaxException {
    /**
     * Constructs a new instance of this class.
     *
     * @param desc  A description of the error
     * @param regex The erroneous pattern
     * @param index The approximate index in the pattern of the error,
     *              or {@code -1} if the index is not known
     */
    public WrongLoginException(String desc, String regex, int index) {
        super(desc, regex, index);
    }
}
