package org.sourcelab.activecampaign.apiv3.request.pipeline;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.pipeline.PipelineListResponse;
import org.sourcelab.http.rest.request.GetRequest;

import java.io.IOException;

public class PipelineListRequest implements GetRequest<PipelineListResponse> {

    @Override
    public String getApiEndpoint() {
        return "api/3/dealGroups";
    }

    @Override
    public PipelineListResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, PipelineListResponse.class);
    }
}
