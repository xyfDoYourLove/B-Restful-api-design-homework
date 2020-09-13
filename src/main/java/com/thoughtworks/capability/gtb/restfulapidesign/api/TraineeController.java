package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Trainee;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraineeController {

  private TraineeService traineeService;

  public TraineeController(TraineeService traineeService) {
    this.traineeService = traineeService;
  }

  @PostMapping(path = "/trainees")
  @ResponseStatus(HttpStatus.CREATED)
  public Trainee addNewTrainee(@RequestBody Trainee trainee) {
    return traineeService.addTrainee(trainee);
  }

  @DeleteMapping(path = "/trainees/{id}")
  public ResponseEntity<String> deleteTrainee(@PathVariable int id) {
    traineeService.deleteTrainee(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/trainees")
  public List<Trainee> getTraineeList(@RequestParam(required = false)Gender gender) {
    return traineeService.getTraineeList(gender);
  }

  @GetMapping(path = "/trainees/{id}")
  public Trainee getTraineeById(@PathVariable int id) {
    return traineeService.getTraineeById(id);
  }

  @PatchMapping(path = "/trainees/{id}")
  public ResponseEntity<String> updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
    traineeService.updateTraineeById(id, trainee);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/groups")
  public List<Group> groupTrainees() {
    return traineeService.groupTrainees();
  }

  @PostMapping(path = "/groups/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public List<Group> editGroupName(@PathVariable int id, @RequestParam String name) {
    return traineeService.editGroupName(id, name);
  }

}
