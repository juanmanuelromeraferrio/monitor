package com.example.monitor.service.impl;

import com.example.monitor.service.api.Monitor;
import com.example.monitor.service.api.Task;

public class SimpleMonitor implements Monitor {

  private volatile boolean isAlive;
  private Task task;

  public SimpleMonitor(Task task) {
    this.task = task;
    this.isAlive = true;
  }

  public void run() throws Exception {
    while (isAlive) {
      task.execute();
      task.sleep();
    }
  }

  public void stop() {
    this.isAlive = false;
  }

  public boolean isAlive() {
    return isAlive;
  }

}
