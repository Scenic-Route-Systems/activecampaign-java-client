package org.sourcelab.activecampaign.apiv3.request.deal;

import org.sourcelab.activecampaign.apiv3.request.DTOWithQueryString;

public class DealSearch extends DTOWithQueryString {

  public DealSearch withContact(final long contactId) {
    queryParams.put("filters[contact]", contactId + "");
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withCreatedAfter(final String after) {
    queryParams.put("filters[created_after]", after);
    return this;
  }

  public DealSearch withStage(final long stageId) {
    queryParams.put("filters[stage]", stageId + "");
    return this;
  }
}
