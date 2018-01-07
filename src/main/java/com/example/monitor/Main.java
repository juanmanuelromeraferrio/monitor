package com.example.monitor;

import com.example.monitor.service.api.Monitor;
import com.example.monitor.service.api.Task;
import com.example.monitor.service.impl.LivenessTask;
import com.example.monitor.service.impl.SimpleMonitor;


public class Main {

  private static final String PATH = "http://localhost:12345/";
  private static final long TIME = 2000;

  public static void main(String[] args) {
    try {
      Task task = new LivenessTask(PATH, TIME);
      Monitor monitor = new SimpleMonitor(task);
      monitor.run();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  }
}
