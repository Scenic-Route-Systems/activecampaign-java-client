package org.sourcelab.activecampaign.apiv3.request.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@JsonRootName(value = "deal")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deal {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Long id;
    private final Long contact;
    private final Long organization;
    private final String title;
    private final String description;
    private final Long stage;
    private final Long status; // Open, Won, Lost
    private final String createdDate;
    private final String updatedDate;

    // Related links
    private final Map<String, String> links;

    @JsonCreator
    public Deal(
        @JsonProperty("id") final Long id,
        @JsonProperty("contact") final Long contact,
        @JsonProperty("organization") final Long organization,
        @JsonProperty("title") final String title,
        @JsonProperty("description") final String description,
        @JsonProperty("stage") final Long stage,
        @JsonProperty("status") final Long status,
        @JsonProperty("cdate") final String createdDate,
        @JsonProperty("mdate") final String updatedDate,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.id = id;
        this.contact = contact;
        this.organization = organization;
        this.title = title;
        this.description = description;
        this.stage = stage;
        this.status = status;
      this.createdDate = createdDate;
      this.updatedDate = updatedDate;

      if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public Long getContact() {
        return contact;
    }

    public Long getOrganization() {
        return organization;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getStage() {
        return stage;
    }

    public Long getStatus() {
        return status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Deal{" +
            "id=" + id +
            ", contact='" + contact + '\'' +
            ", organization='" + organization + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", stage='" + stage + '\'' +
            ", status='" + status + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", updatedDate='" + updatedDate + '\'' +
            ", links=" + links +
            '}';
    }
}
