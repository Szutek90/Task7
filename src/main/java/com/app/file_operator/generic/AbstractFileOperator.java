package com.app.file_operator.generic;

import com.app.file_operator.FileOperator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFileOperator <T> implements FileOperator<T> {

    protected abstract T parseLine(String line);
    @Override
    public Set<T> read(String filename) {
        try (var lines = Files.lines(Paths.get(filename))) {
            var objects = new HashSet<T>();
            for (var line : lines.toList()) {
                objects.add(parseLine(line));
            }
            return objects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
