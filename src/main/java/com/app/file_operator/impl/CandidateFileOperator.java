package com.app.file_operator.impl;

import com.app.file_operator.generic.AbstractFileOperator;
import com.app.model.candidate.Candidate;

public class CandidateFileOperator extends AbstractFileOperator<Candidate> {

    @Override
    protected Candidate parseLine(String line) {
        return Candidate.parse(line);
    }
}
