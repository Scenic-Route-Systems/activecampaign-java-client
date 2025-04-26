package org.sourcelab.activecampaign.apiv3.request.deal;

import org.sourcelab.activecampaign.apiv3.request.DTOWithQueryString;

public class DealSearch extends DTOWithQueryString {

  public DealSearch withContact(final long contactId) {
    queryParams.put("filters[contact]", contactId + "");
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withCreatedBefore(final String createdBefore) {
    queryParams.put("filters[created_before]", createdBefore);
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withCreatedAfter(final String createdAfter) {
    queryParams.put("filters[created_after]", createdAfter);
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withUpdatedBefore(final String updatedBefore) {
    queryParams.put("filters[updated_before]", updatedBefore);
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withUpdatedAfter(final String updatedAfter) {
    queryParams.put("filters[updated_after]", updatedAfter);
    return this;
  }

  public DealSearch withStage(final long stageId) {
    queryParams.put("filters[stage]", stageId + "");
    return this;
  }
}
