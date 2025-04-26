package org.sourcelab.activecampaign.apiv3.request;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class DTOWithQueryString {

  protected final Map<String, String> queryParams = new HashMap<>();

  public String buildQueryString() {
    return queryParams.entrySet().stream()
        .map(p -> p.getKey() + "=" + URLEncoder.encode(p.getValue(), StandardCharsets.UTF_8))
        .reduce((p1, p2) -> p1 + "&" + p2)
        .orElse("");
  }
}
