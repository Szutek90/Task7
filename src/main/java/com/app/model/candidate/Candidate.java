package com.app.model.candidate;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Candidate {
    final String name;
    final String surname;
    final int id;
    int numOfVotes;
    final String electoralDistrict;

    public void increaseVotes() {
        numOfVotes++;
    }

    public static Candidate parse(String line) {
        var splitted = line.split(";");
        return new Candidate(splitted[0], splitted[1], Integer.parseInt(splitted[2]),
                splitted[3]);
    }

}

