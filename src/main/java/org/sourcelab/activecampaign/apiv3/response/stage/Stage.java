package org.sourcelab.activecampaign.apiv3.response.stage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
    private final Long id;
    private final String title;

    private final Map<String, String> links;

    @JsonCreator
    public Stage(
        @JsonProperty("id") final Long id,
        @JsonProperty("title") final String title,
        @JsonProperty("links")  final Map<String, String> links
    ) {
        this.id = id;
        this.title = title;

        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Stage{"
            + "id=" + id
            + ", title='" + title + '\''
            + ", links=" + links
            + '}';
    }
}
