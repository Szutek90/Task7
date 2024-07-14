package com.app.model.voter;



import com.app.model.candidate.Candidate;

import java.util.Set;
import java.util.function.Function;

public interface VoterMapper {
    Function<Voter, String> toElectoralDistrict = voter -> voter.electoralDistrict;
    Function<Voter, Set<Candidate>> toCandidates = voter -> voter.candidates;
}
