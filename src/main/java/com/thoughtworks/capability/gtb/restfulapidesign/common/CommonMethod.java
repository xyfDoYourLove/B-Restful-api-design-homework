package com.thoughtworks.capability.gtb.restfulapidesign.common;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonMethod {

  public static void initGroups() {
    List<String> groupNames = Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6");
    for (int i = 0; i < groupNames.size(); i++) {
      MockDataBase.GROUP_LIST.add(new Group(i + 1, groupNames.get(i), groupNames.get(i), new ArrayList<>()));
    }
  }

  public static void clearGroups() {
    for (Group group : MockDataBase.GROUP_LIST) {
      group.setGroupTrainees(new ArrayList<>());
    }
  }

}
