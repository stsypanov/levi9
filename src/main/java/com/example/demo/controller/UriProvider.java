package com.example.demo.controller;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
class UriProvider {

  @SneakyThrows
  String newGameUri(HttpServletRequest request) {
    return request.getRequestURL().toString();
  }
  @SneakyThrows
  String existingGameUri(HttpServletRequest request, long gameId) {
    final String requestURI = request.getRequestURI();
    final String baseUri = getBaseUri(request);

    return baseUri + requestURI.substring(0, requestURI.indexOf("/" + gameId)) + "/" + gameId;
  }

  String getBaseUri(HttpServletRequest request) {
    final String scheme = request.getScheme();
    final String serverName = request.getServerName();
    final int serverPort = request.getServerPort();

    return scheme + "://" + serverName + ":" + serverPort;
  }
}