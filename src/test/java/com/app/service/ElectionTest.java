package com.app.service;


import com.app.model.candidate.Candidate;
import com.app.model.voter.Voter;
import com.app.provider.UserInputProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ElectionTest {
    private static Candidate candidate1;
    private static Candidate candidate2;
    private static Voter voter1;

    @Mock
    UserInputProvider provider;

    @InjectMocks
    Election election;


    @BeforeAll
    static void beforeAll() {
        candidate1 = new Candidate("CandidateName1", "CandidateSurname1", 0, "District1");
        voter1 = new Voter(0, "District 1");
        candidate2 = new Candidate("CandidateName2", "CandidateSurname2", 1, "District1");
        voter1.addCandidate(candidate1);
        voter1.addCandidate(candidate2);
    }

    @Test
    @DisplayName("When adding candidates")
    void test1() {

        election.addCandidates(new HashSet<>(List.of(candidate1)));
        Assertions.assertThat(Election.candidates)
                .hasSize(1)
                .containsExactly(candidate1);
    }

    @Test
    @DisplayName("When adding voters")
    void test2() {

        election.addVoters(new HashSet<>(List.of(voter1)));
        Assertions.assertThat(Election.voters)
                .hasSize(1)
                .containsExactly(voter1);
    }

    @Test
    @DisplayName("When voting")
    void test3() {
        election.addVoters(new HashSet<>(List.of(voter1)));
        election.addCandidates(new HashSet<>(List.of(candidate1, candidate2)));
        try (MockedStatic<UserInputProvider> mockedStatic = Mockito.mockStatic(UserInputProvider.class)) {
            mockedStatic
                    .when(UserInputProvider::getInteger)
                    .thenReturn(0);
            Assertions.assertThat(election.voting()).isEqualTo(candidate1);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
