package com.example.monitor.service.api;

import java.io.IOException;

public interface Task {
  
  public void execute() throws IOException;
  
  public void sleep() throws InterruptedException;
  
}
