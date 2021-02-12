package com.demo.shell;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.shell.ShellService;
import io.vertx.ext.shell.ShellServiceOptions;

public class TelnetVerticle3 extends AbstractVerticle {
  private static ShellServiceOptions options = Utils.getTelnetOptions(4003);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    ShellService.create(vertx, options).start(Utils.getStartingHandler(startPromise));
  }
}
