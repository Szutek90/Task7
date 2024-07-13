package com.app.model.candidate;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class Candidate {
    final String name;
    final String surname;
    final int id;
    int numOfVotes;
    final String electoralDistrict;

    public static Candidate parse(String line) {
        var splitted = line.split(";");
        return new Candidate(splitted[0], splitted[1], Integer.parseInt(splitted[2]),
                splitted[3]);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", numOfVotes=" + numOfVotes +
                ", electoralDistrict='" + electoralDistrict + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;
        return id == candidate.id && numOfVotes == candidate.numOfVotes && Objects.equals(name, candidate.name) && Objects.equals(surname, candidate.surname) && Objects.equals(electoralDistrict, candidate.electoralDistrict);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + id;
        result = 31 * result + numOfVotes;
        result = 31 * result + Objects.hashCode(electoralDistrict);
        return result;
    }
}
