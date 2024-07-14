package com.app.model.voter;

import com.app.model.candidate.Candidate;
import com.app.model.candidate.CandidateMapper;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;
        return id == voter.id && Objects.equals(electoralDistrict, voter.electoralDistrict) && candidates.equals(voter.candidates);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(electoralDistrict);
        result = 31 * result + candidates.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", electoralDistrict='" + electoralDistrict + '\'' +
                ", candidates=" + candidates +
                '}';
    }
}
