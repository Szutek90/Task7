package com.app.file_operator;

import java.util.Set;

public interface FileOperator<T> {
    Set<T> read(String filename);
}