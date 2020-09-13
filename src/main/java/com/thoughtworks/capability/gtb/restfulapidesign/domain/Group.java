package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Trainee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

  private int id;

  private String name;

  private String note;

  private List<Trainee> groupTrainees;
}
