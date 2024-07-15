package com.app.service;

import com.app.model.candidate.Candidate;
import com.app.model.candidate.CandidateMapper;
import com.app.model.voter.Voter;
import com.app.model.voter.VoterMapper;
import com.app.provider.UserInputProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j

public class Election {
    public static Set<Candidate> candidates = new TreeSet<>(
            Comparator.comparing(CandidateMapper.toName)
                    .thenComparing(CandidateMapper.toSurname)
                    .thenComparing(CandidateMapper.toElectoralDistrict));
    public static Set<Voter> voters = new HashSet<>();

    public void addCandidates(Set<Candidate> candidates) {
        Election.candidates.addAll(candidates);
        fillVotersByAllCandidates();
    }

    public void addVoters(Set<Voter> voters) {
        Election.voters.addAll(voters);
    }


    public Candidate voting() {
        var option = 0;
        for (var voter : voters) {
            log.info("Glosowanie dla okregu: " + VoterMapper.toElectoralDistrict.apply(voter));
            log.info("Lista kandydatow");
            var currentCandidates = new ArrayList<>(VoterMapper.toCandidates.apply(voter));
            for (int i = 0; i < currentCandidates.size(); i++) {
                log.info(i + " : " + currentCandidates.get(i));
            }
            do {
                option = UserInputProvider.getInteger();
            } while (option < 0 || option > currentCandidates.size());
            currentCandidates.get(option).increaseVotes();
        }
        return votingResults();
    }

    private Candidate votingResults() {
        var winners = getWinners();
        if (winners.size() != 1) {
            log.info("Dogrywka!");
            do {
                fillVotersByWinners(winners);
                voting();
                winners = getWinners();
            } while (winners.size() != 1);
        }
        log.info("Wygrał: " + winners.getFirst());
        return winners.getFirst();
    }

    private void clearAllCandidates() {
        voters.forEach(Voter::clearCandidates);
    }


    private List<Candidate> getWinners() {
        return candidates.stream()
                .collect(Collectors.groupingBy(CandidateMapper.toNumOfVotes,
                        Collectors.mapping(e -> e, Collectors.toList())))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow(IllegalStateException::new);
    }

    private void fillVotersByWinners(List<Candidate> winners) {
        clearAllCandidates();
        for (var winner : winners) {
            voters.forEach(currentVoter -> currentVoter.addCandidate(winner));
        }

    }

    private void fillVotersByAllCandidates() {
        for (var candidate : candidates) {
            voters.stream()
                    .filter(voter -> voter.hasTheSameElectoralDistrict(
                            CandidateMapper.toElectoralDistrict.apply(candidate)))
                    .forEach(currentVoter -> currentVoter.addCandidate(candidate));
        }
    }
}
