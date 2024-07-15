package com.app.model.voter;

import com.app.model.candidate.Candidate;
import com.app.model.candidate.CandidateMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@EqualsAndHashCode
@ToString
public class Voter {
    private final int id;
    final String electoralDistrict;
    final Set<Candidate> candidates;

    public Voter(int id, String electoralDistrict) {
        this.id = id;
        this.electoralDistrict = electoralDistrict;
        candidates = new TreeSet<>(Comparator.comparing(CandidateMapper.toName)
                .thenComparing(CandidateMapper.toSurname)
                .thenComparing(CandidateMapper.toElectoralDistrict));
    }

    public static Voter parse(String line) {
        var splitted = line.split(";");
        return new Voter(Integer.parseInt(splitted[0]), splitted[1]);
    }

    public boolean hasTheSameElectoralDistrict(String electoralDistrict) {
        return this.electoralDistrict.equals(electoralDistrict);
    }

    public void clearCandidates() {
        candidates.clear();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }
}
