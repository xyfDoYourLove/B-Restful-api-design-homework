package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

  MALE, FEMALE;

  @JsonValue
  public int getOrdinal() {
    return ordinal();
  }
}
