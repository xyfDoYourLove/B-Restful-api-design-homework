package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.common.MockDataBase;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GroupRepository {

  public void save(Group group) {
    MockDataBase.GROUP_LIST.add(group);
  }

  public List<Group> findAllGroup() {
    return MockDataBase.GROUP_LIST;
  }

  public void updateGroupName(Group newGroup) {
    for (int i = 0; i < MockDataBase.GROUP_LIST.size(); i++) {
      if (MockDataBase.GROUP_LIST.get(i).getId() == newGroup.getId()) {
        Group oldGroup = MockDataBase.GROUP_LIST.get(i);
        oldGroup.setName(newGroup.getName());
        MockDataBase.GROUP_LIST.set(i, oldGroup);
      }
    }
  }

}
