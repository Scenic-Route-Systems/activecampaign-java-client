package org.sourcelab.activecampaign.apiv3.response.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.deal.DealCustomField;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealCustomFieldListResponse {
//    private final List<DealCustomField> dealCustomFieldData;
    private final List<DealCustomField> dealCustomFields = new ArrayList<>();

    @JsonCreator
    public DealCustomFieldListResponse(
//        @JsonProperty("dealCustomFieldData") final List<DealCustomField> dealCustomFieldData
        // TODO: temporarily keeping this so I can see all the values for debugging
        @JsonProperty("dealCustomFieldData") final List<Map<String, Object>> dealCustomFieldData
    ) {
//        this.deals = deals;

        for (Map<String, Object> dealCustomFieldMap : dealCustomFieldData) {
            final DealCustomField dealCustomField = new DealCustomField(
                Long.parseLong(dealCustomFieldMap.get("id").toString()),
                Long.parseLong(dealCustomFieldMap.get("dealId").toString()),
                Long.parseLong(dealCustomFieldMap.get("customFieldId").toString()),
                dealCustomFieldMap.get("fieldValue").toString()
            );

            dealCustomFields.add(dealCustomField);
        }
    }

    public List<DealCustomField> getDealCustomFields() {
        return dealCustomFields;
    }
}
