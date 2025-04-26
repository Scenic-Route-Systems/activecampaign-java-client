package org.sourcelab.activecampaign.apiv3.response.stage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.response.Meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StageListResponse {
    private final List<Stage> stages;
    private final Meta meta;

    @JsonCreator
    public StageListResponse(
        @JsonProperty("dealStages") final List<Stage> stages,
        @JsonProperty("meta") final Meta meta
    ) {
        if (stages == null) {
            this.stages = Collections.emptyList();
        } else {
            this.stages = Collections.unmodifiableList(new ArrayList<>(stages));
        }
        this.meta = meta;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "StageListResponse{" +
            "stages=" + stages +
            ", meta=" + meta +
            '}';
    }
}
