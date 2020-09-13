package com.thoughtworks.capability.gtb.restfulapidesign.common;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Trainee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataBase {

  private MockDataBase() {
  }

  public static final List<Trainee> TRAINEE_LIST = new ArrayList<>();

  public static final Map<Integer, Trainee> TRAINEE_MAP = new HashMap<>();

  public static final List<Group> GROUP_LIST = new ArrayList<>();
}
