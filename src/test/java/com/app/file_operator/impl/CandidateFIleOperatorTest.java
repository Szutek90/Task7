package com.app.file_operator.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CandidateFileOperatorTest {

    @Test
    @DisplayName("When reading file with candidates")
    void test1() {
        var filename = "src/test/resources/candidates.csv";
        var fileOperator = new CandidateFileOperator();
        var candidates = fileOperator.read(filename);
        Assertions.assertThat(candidates).hasSize(2);
    }
}
