package com.example.monitor.model;

public class Results {

  private long success;
  private long fails;

  public Results() {
    this.success = 0;
    this.fails = 0;

  }
  public void success() {
    this.success++;
  }

  public void fails() {
    this.fails++;
  }

  public long getSuccess() {
    return success;
  }

  public long getFails() {
    return fails;
  }



}
