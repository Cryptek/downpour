package com.github.Cryptek;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;

public class Downpour {

  private static final Logger log = Logger.getLogger(Downpour.class.getName());

  public static void main(String[] args) {
    String urlString = args[0];
    final URL url;
    var fileName = "output";
    try {
      url = URI.create(urlString).toURL();
      if (urlString.contains("//")) {
        fileName = urlString.substring(urlString.lastIndexOf('/') + 1).trim();
      }
    } catch (Exception e) {
      log.severe("Invalid url provided! : " + e.getMessage());
      return;
    }
    if (!url.getProtocol().toLowerCase().contains("http")) {
      log.severe("Cannot proceeed, only http protocols are supported.");
      return;
    }

    try {
      final InputStream is = url.openStream();
      final OutputStream os = new FileOutputStream(new File(fileName));
      is.transferTo(os);
      is.close();
      os.close();
    } catch (IOException e) {
      log.severe("Cannot connect to " + url);
    }
  }
}
