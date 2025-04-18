package org.sourcelab.activecampaign.apiv3.request.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "dealCustomFieldDatum")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealCustomField {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Long id;
    private final Long dealId;
    private final Long customFieldId;
    private final String fieldValue;

    @JsonCreator
    public DealCustomField(
        @JsonProperty("id") final Long id,
        @JsonProperty("dealId") final Long dealId,
        @JsonProperty("customFieldId") final Long customFieldId,
        @JsonProperty("fieldValue") final String fieldValue
    ) {
        this.id = id;
        this.dealId = dealId;
        this.customFieldId = customFieldId;
        this.fieldValue = fieldValue;
    }

    public Long getId() {
        return id;
    }

    public Long getDealId() {
        return dealId;
    }

    public Long getCustomFieldId() {
        return customFieldId;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    @Override
    public String toString() {
        return "DealCustomField{" +
            "id=" + id +
            ", dealId=" + dealId +
            ", customFieldId=" + customFieldId +
            ", fieldValue='" + fieldValue + '\'' +
            '}';
    }
}
