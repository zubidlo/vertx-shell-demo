package com.demo.shell;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.ext.shell.ShellService;
import io.vertx.ext.shell.ShellServiceOptions;
import io.vertx.ext.shell.term.TelnetTermOptions;

public class Utils {
  public static ShellServiceOptions getTelnetOptions(int port) {
    return new ShellServiceOptions().setTelnetOptions(
      new TelnetTermOptions()
        .setHost("0.0.0.0")
        .setPort(port)
    );
  }

  public static Handler<AsyncResult<Void>> getStartingHandler(Promise<Void> startPromise) {
    return ar -> {
      if (ar.succeeded()) startPromise.complete();
      else startPromise.fail(ar.cause());
    };
  }
}
