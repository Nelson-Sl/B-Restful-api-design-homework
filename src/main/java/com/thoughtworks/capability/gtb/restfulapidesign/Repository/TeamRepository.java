package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Common.GlobalVariables;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.TeamUpdateNameOnly;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.TeamNameExistedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TeamRepository {
    private List<Team> teamList = new ArrayList<>();
    private List<Student> studentList;
    private final StudentRepository studentRepository;

    public TeamRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public synchronized List<Team> generateTeamList() {
        teamList.clear();
        generateTeams();
        studentList = studentRepository.getStudentList();
        Collections.shuffle(studentList);
        addTeamMembers(studentList);
        return teamList;
    }

    public List<Team> getTeamList() {
        return this.teamList;
    }

    public synchronized List<Team> changeTeamName(int id, TeamUpdateNameOnly teamName) {
        boolean isTeamNameExisted = teamList.stream().anyMatch(team -> team.getName().equals(teamName.getName()));
        if(isTeamNameExisted) {
            throw new TeamNameExistedException(GlobalVariables.TEAM_NAME_EXISTED_EXCEPTION_MESSAGE);
        }
        Team changingTeam = teamList.stream().filter(team -> team.getId() == id).findFirst().get();
        changingTeam.setName(teamName.getName());
        return this.teamList;
    }

    private void generateTeams() {
        for (int teamId = 1; teamId <= GlobalVariables.TEAM_COUNT; teamId++) {
            String teamName = GlobalVariables.TEAM_NAME_PREFIX + teamId;
            List<Student> teamMembers = new ArrayList<>();
            Team newTeam = Team.builder().id(teamId).name(teamName).members(teamMembers).build();
            teamList.add(newTeam);
        }
    }

    private void addTeamMembers(List<Student> studentList) {
        int teamId = 1;
        for(Student stu: studentList) {
            for(Team team: teamList) {
                if(team.getId() == teamId) {
                    team.getMembers().add(stu);
                }
            }
            teamId = teamId % 6 == 0 ? 1 : teamId + 1;
        }
    }
}
