package org.sourcelab.activecampaign.apiv3.response.pipeline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.response.Meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineListResponse {
    private final List<Pipeline> pipelines;
    private final Meta meta;

    @JsonCreator
    public PipelineListResponse(
        @JsonProperty("dealGroups") final List<Pipeline> pipelines,
        @JsonProperty("meta") final Meta meta
    ) {
        if (pipelines == null) {
            this.pipelines = Collections.emptyList();
        } else {
            this.pipelines = Collections.unmodifiableList(new ArrayList<>(pipelines));
        }
        this.meta = meta;
    }

    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    @Override
    public String toString() {
        return "PipelineListResponse{" +
            "pipelines=" + pipelines +
            ", meta=" + meta +
            '}';
    }

    public Meta getMeta() {
        return meta;
    }
}
