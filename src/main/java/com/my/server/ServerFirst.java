package com.my.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class ServerFirst extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        ServerFirst serverFirst = new ServerFirst();
        vertx.deployVerticle(serverFirst);
    }

    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }
}
