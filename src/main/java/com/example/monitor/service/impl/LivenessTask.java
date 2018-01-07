package com.example.monitor.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.example.monitor.model.Results;
import com.example.monitor.service.api.Task;

public class LivenessTask implements Task {

  private String path;
  private Results results;
  private Long time;
  private HttpURLConnection connection;

  public LivenessTask(String path, Long time) {
    this.path = path;
    this.results = new Results();
    this.time = time;
  }

  @Override
  public void execute() throws IOException {
    createConnection();
    if (connection.getResponseCode() != 200) {
      this.results.fails();
    } else {
      this.results.success();
    }
    showHealth();
  }

  private void showHealth() {
    Double healthy =
        (double) ((double) this.results.getSuccess() / (double) (this.results.getSuccess() + this.results
            .getFails()));
    System.out.println("Healthy: " + Math.round(healthy * 100) + "%");
  }

  private void createConnection() throws IOException {
    URL url = new URL(path);
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Accept", "application/json");
  }

  @Override
  public void sleep() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(time);
  }

}
