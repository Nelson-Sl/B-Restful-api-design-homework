package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.TeamUpdateNameOnly;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> generateTeamList() {
        return this.teamRepository.generateTeamList();
    }

    public List<Team> getTeamList() {
        return this.teamRepository.getTeamList();
    }

    public List<Team> changeTeamName(int id, TeamUpdateNameOnly teamName) {
        return this.teamRepository.changeTeamName(id, teamName);
    }
}
