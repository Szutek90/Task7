package com.app.model.candidate;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface CandidateMapper {
    Function<Candidate, String> toName = candidate -> candidate.name;
    Function<Candidate, String> toSurname = candidate -> candidate.surname;
    Function<Candidate, String> toElectoralDistrict = candidate -> candidate.electoralDistrict;
    ToIntFunction<Candidate> toId = candidate -> candidate.id;
    Function<Candidate, Integer> toNumOfVotes = candidate -> candidate.numOfVotes;
}
