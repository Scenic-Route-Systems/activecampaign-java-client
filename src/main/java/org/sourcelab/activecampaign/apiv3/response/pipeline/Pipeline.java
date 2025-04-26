package org.sourcelab.activecampaign.apiv3.response.pipeline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pipeline {
    private final Long id;
    private final String title;
    private final List<Long> stages;

    private final Map<String, String> links;

    @JsonCreator
    public Pipeline(
        @JsonProperty("id") final Long id,
        @JsonProperty("title") final String title,
        @JsonProperty("stages") final List<Long> stages,
        @JsonProperty("links")  final Map<String, String> links
    ) {
        this.id = id;
        this.title = title;
        this.stages = stages;

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

    public List<Long> getStages() {
        return stages;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Pipeline{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", stages=" + stages +
            ", links=" + links +
            '}';
    }
}
