package com.app.file_operator.generic;

import com.app.file_operator.FileOperator;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFileOperator <T> implements FileOperator<T> {

    protected abstract T parseLine(String line);
    @Override
    public Set<T> read(String filename) {
        return new HashSet<>();
    }
}
