package org.sourcelab.activecampaign.apiv3.response.stage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StageListResponse {
    private final List<Stage> stages;

    @JsonCreator
    public StageListResponse(
        @JsonProperty("dealStages") final List<Stage> stages) {
        if (stages == null) {
            this.stages = Collections.emptyList();
        } else {
            this.stages = Collections.unmodifiableList(new ArrayList<>(stages));
        }
    }

    public List<Stage> getStages() {
        return stages;
    }

    @Override
    public String toString() {
        return "StageListResponse{"
            + "stages=" + stages
            + '}';
    }
}
