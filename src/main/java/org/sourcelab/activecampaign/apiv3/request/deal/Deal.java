package org.sourcelab.activecampaign.apiv3.request.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonRootName(value = "deal")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deal {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Long id;
    private final String contact;
    private final String organization;
    private final String title;
    private final String description;
    private final String stage;
    private final String status; // Open, Won, Lost
    private final List<FieldValue> fieldValues;

    // Related links
    private final Map<String, String> links;

    @JsonCreator
    public Deal(
        @JsonProperty("id") final Long id,
        @JsonProperty("contact") final String contact,
        @JsonProperty("organization") final String organization,
        @JsonProperty("title") final String title,
        @JsonProperty("description") final String description,
        @JsonProperty("stage") final String stage,
        @JsonProperty("status") final String status,
        final List<FieldValue> fieldValues,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.id = id;
        this.contact = contact;
        this.organization = organization;
        this.title = title;
        this.description = description;
        this.stage = stage;
        this.status = status;
        if (fieldValues == null) {
            this.fieldValues = Collections.emptyList();
        } else {
            this.fieldValues = Collections.unmodifiableList(new ArrayList<>(fieldValues));
        }

        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public List<FieldValue> getFieldValues() {
        return fieldValues;
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
            ", fieldValues=" + fieldValues +
            ", links=" + links +
            '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FieldValue {
        private final long field;
        private final String value;

        @JsonCreator
        public FieldValue(
            @JsonProperty("customFieldId") final long field,
            @JsonProperty("fieldValue") final String value
        ) {
            this.field = field;
            this.value = value;
        }

        public long getField() {
            return field;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "FieldValue{"
                + "field=" + field
                + ", value='" + value + '\''
                + '}';
        }
    }
}
