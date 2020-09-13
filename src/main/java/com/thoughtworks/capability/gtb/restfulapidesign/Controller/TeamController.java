package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.TeamUpdateNameOnly;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Team> generateTeamList() {
        return this.teamService.generateTeamList();
    }

    @GetMapping
    public List<Team> getTeamList() {
        return this.teamService.getTeamList();
    }

    @PatchMapping("/{id}")
    public List<Team> changeTeamName(@PathVariable int id, @RequestBody TeamUpdateNameOnly teamName) {
        return this.teamService.changeTeamName(id, teamName);
    }
}
