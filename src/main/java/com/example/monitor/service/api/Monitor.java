package com.example.monitor.service.api;


public interface Monitor {

  public void run() throws Exception;

  public void stop();

  public boolean isAlive();
}
