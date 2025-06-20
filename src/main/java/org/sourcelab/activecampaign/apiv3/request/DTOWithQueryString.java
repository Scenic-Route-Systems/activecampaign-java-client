package org.sourcelab.activecampaign.apiv3.request;

import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiValuedMap;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class DTOWithQueryString {

  protected final MultiValuedMap<String, String> queryParams = MultiMapUtils.newSetValuedHashMap();

  public String buildQueryString() {
    List<String> queryString = new ArrayList<>();

    Set<String> keys = queryParams.keySet();
    for (String key : keys) {
      Collection<String> values = queryParams.get(key);
      for (String value : values) {
        queryString.add(key + "=" + URLEncoder.encode(value, StandardCharsets.UTF_8));
      }
    }

    return String.join("&", queryString);
  }
}
