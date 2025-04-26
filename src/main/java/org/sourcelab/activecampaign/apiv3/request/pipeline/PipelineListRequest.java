package org.sourcelab.activecampaign.apiv3.request.pipeline;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.pipeline.PipelineListResponse;
import org.sourcelab.http.rest.request.GetRequest;

import java.io.IOException;

public class PipelineListRequest implements GetRequest<PipelineListResponse> {

    private final long offset;

    public PipelineListRequest(long offset) {
        this.offset = offset;
    }

    @Override
    public String getApiEndpoint() {
        return "api/3/dealGroups?offset=" + offset;
    }

    @Override
    public PipelineListResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, PipelineListResponse.class);
    }
}
