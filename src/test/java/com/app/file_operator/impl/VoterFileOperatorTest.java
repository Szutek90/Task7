package com.app.file_operator.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VoterFileOperatorTest {
    @Test
    @DisplayName("When reading file with voters")
    void test() {
        var fileName = "src/test/resources/voters.csv";
        var fileOperator = new VoterFileOperator();
        var voters = fileOperator.read(fileName);
        Assertions.assertThat(voters).hasSize(3);
    }
}
