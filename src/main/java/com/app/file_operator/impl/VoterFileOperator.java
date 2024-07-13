package com.app.file_operator.impl;

import com.app.file_operator.generic.AbstractFileOperator;
import com.app.model.voter.Voter;

public class VoterFileOperator extends AbstractFileOperator<Voter> {
    @Override
    protected Voter parseLine(String line) {
        return new Voter();
    }
}
