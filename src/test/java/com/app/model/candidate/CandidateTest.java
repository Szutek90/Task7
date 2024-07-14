package com.app.model.candidate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CandidateTest {

    @Test
    @DisplayName("When increasing votes")
    void test1() {
        var candidate = new Candidate("CandidateName", "CandidateSurname", 1, "District1");
        candidate.increaseVotes();
        Assertions.assertThat(candidate.numOfVotes).isEqualTo(1);
    }

    @Test
    @DisplayName("When parsing")
    void test2() {
        Assertions.assertThatCode(() -> Candidate.parse("name;surname;0;district"))
                .doesNotThrowAnyException();
    }
}
