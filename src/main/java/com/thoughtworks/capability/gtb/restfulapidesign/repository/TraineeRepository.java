package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.common.MockDataBase;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Trainee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TraineeRepository {

  public Trainee save(Trainee trainee) {
    for (int i = 0; i < MockDataBase.TRAINEE_LIST.size(); i++) {
      if (MockDataBase.TRAINEE_LIST.get(i).getId() == trainee.getId()) {
        MockDataBase.TRAINEE_LIST.remove(i);
        i--;
      }
    }
    MockDataBase.TRAINEE_LIST.add(trainee);
    return trainee;
  }

  public Trainee findTraineeById(int traineeId) {
    for (Trainee trainee : MockDataBase.TRAINEE_LIST) {
      if (trainee.getId() == traineeId) {
        return trainee;
      }
    }
    return null;
  }

  public List<Trainee> findTraineeByGender(Gender gender) {
    return MockDataBase.TRAINEE_LIST
            .stream()
            .filter(item -> item.getGender().equals(gender))
            .collect(Collectors.toList());
  }

  public void delete(int id) {
    for (int i = 0; i < MockDataBase.TRAINEE_LIST.size(); i++) {
      if (MockDataBase.TRAINEE_LIST.get(i).getId() == id) {
        MockDataBase.TRAINEE_LIST.remove(i);
      }
    }
  }

  public List<Trainee> findAll() {
    return MockDataBase.TRAINEE_LIST;
  }
}
