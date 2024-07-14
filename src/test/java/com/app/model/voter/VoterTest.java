package com.app.model.voter;

import com.app.model.candidate.Candidate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class VoterTest {
    static Voter voter;
    static Candidate candidate;

    @BeforeAll
    static void beforeAll() {
        voter = new Voter(1, "District1");
        candidate = new Candidate("CandidateName", "CandidateSurname", 1, "District1");
    }

    @Test
    @DisplayName("When increasing votes")
    void test1() {
        assertThat(voter.hasTheSameElectoralDistrict("District1")).isTrue();
    }

    @Test
    @DisplayName("When parsing")
    void test2() {
        assertThatCode(() -> Voter.parse("18;district"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When adding candidate")
    void test3() {
        voter.addCandidate(candidate);
        assertThat(voter.candidates).containsExactly(candidate);
    }

    @Test
    @DisplayName("When clearing candidates")
    void test4() {
        voter.addCandidate(candidate);
        voter.clearCandidates();
        assertThat(voter.candidates).isEmpty();
    }
}
