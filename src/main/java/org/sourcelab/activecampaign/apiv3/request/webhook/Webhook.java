/**
 * Copyright 2019, 2020, 2021 SourceLab.org https://github.com/SourceLabOrg/activecampaign-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.sourcelab.activecampaign.apiv3.request.webhook;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.sourcelab.activecampaign.apiv3.request.contact.ContactBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@JsonRootName(value = "webhook")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private final Long id;
  private final String name;
  private final String url;
  private final List<String> events;
  private final List<String> sources;

  @JsonCreator
  public Webhook(
    @JsonProperty("id") final Long id,
    @JsonProperty("name") final String name,
    @JsonProperty("url") final String url,
    @JsonProperty("events") final List<String> events,
    @JsonProperty("sources") final List<String> sources
  ) {
    this.id = id;
    this.name = name;
    this.url = url;

    if (events == null) {
        this.events = Collections.emptyList();
    } else {
        this.events = Collections.unmodifiableList(new ArrayList<>(events));
    }

    if (sources == null) {
      this.sources = Collections.emptyList();
    } else {
      this.sources = Collections.unmodifiableList(new ArrayList<>(sources));
    }
  }

    public Long getId() {
        return id;
    }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public List<String> getEvents() {
    return events;
  }

  public List<String> getSources() {
    return sources;
  }

  @Override
  public String toString() {
    return "Webhook{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", url='" + url + '\'' +
        ", events=" + events +
        ", sources=" + sources +
        '}';
  }
}
