package org.sourcelab.activecampaign.apiv3.response.pipeline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineListResponse {
    private final List<Pipeline> pipelines;

    @JsonCreator
    public PipelineListResponse(
        @JsonProperty("dealGroups") final List<Pipeline> pipelines) {
        if (pipelines == null) {
            this.pipelines = Collections.emptyList();
        } else {
            this.pipelines = Collections.unmodifiableList(new ArrayList<>(pipelines));
        }
    }

    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    @Override
    public String toString() {
        return "PipelineListResponse{" +
            "pipelines=" + pipelines +
            '}';
    }
}
