package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.common.CommonMethod;
import com.thoughtworks.capability.gtb.restfulapidesign.common.MockDataBase;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Trainee;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TraineeService {

  private TraineeRepository traineeRepository;

  public TraineeService(TraineeRepository traineeRepository) {
    this.traineeRepository = traineeRepository;
  }

  public Trainee addTrainee(Trainee trainee) {
    trainee.setId(MockDataBase.TRAINEE_LIST.size() + 1);
    return traineeRepository.save(trainee);
  }

  public void deleteTrainee(int id) {
    traineeRepository.delete(id);
  }

  public List<Group> editGroupName(int id, String name) {
    for(Group group : MockDataBase.GROUP_LIST) {
      if (group.getId() == id){
        group.setName(name);
      }
    }
    return MockDataBase.GROUP_LIST;
  }


  public List<Trainee> getTraineeList(Gender gender) {
    if (gender == null) {
      return traineeRepository.findAll();
    }
    return traineeRepository.findTraineeByGender(gender);
  }

  public Trainee getTraineeById(int id) {
    return traineeRepository.findTraineeById(id);
  }

  public void updateTraineeById(int id, Trainee trainee) {
    trainee.setId(id);
    traineeRepository.save(trainee);
  }

  public List<Group> groupTrainees() {
    if (MockDataBase.GROUP_LIST.isEmpty()) {
      CommonMethod.initGroups();
    }else {
      CommonMethod.clearGroups();
    }

    List<Trainee> newTraineeList = new ArrayList<>(MockDataBase.TRAINEE_LIST);
    Collections.shuffle(newTraineeList);

    int size;
    int moreGroupCount = MockDataBase.TRAINEE_LIST.size() % 6;
    for (int i = 0, startIndex = 0; i < MockDataBase.GROUP_LIST.size(); i++, startIndex += size) {
      if (i < moreGroupCount) {
        size = MockDataBase.TRAINEE_LIST.size() / 6 + 1;
      }else {
        size = MockDataBase.TRAINEE_LIST.size() / 6;
      }
      addGroup(startIndex, size, i, newTraineeList);
    }
    return MockDataBase.GROUP_LIST;
  }

  private void addGroup(int startIndex, int size, int index, List<Trainee> newTraineeList) {
    MockDataBase.GROUP_LIST.get(index)
            .setGroupTrainees(newTraineeList.subList(startIndex, startIndex + size));
  }


}
