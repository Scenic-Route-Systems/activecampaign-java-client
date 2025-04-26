/**
 * Copyright 2019, 2020, 2021 SourceLab.org https://github.com/SourceLabOrg/activecampaign-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.sourcelab.activecampaign.apiv3.response.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealField {
    private final Long id;
    private final String fieldLabel;
    private final String fieldType;
    private final String fieldDefault;

    // Related links
    private final Map<String, String> links;

    @JsonCreator
    public DealField(
        @JsonProperty("id") final Long id,
        @JsonProperty("fieldLabel") final String fieldLabel,
        @JsonProperty("fieldType") final String fieldType,
        @JsonProperty("fieldDefault")  final String fieldDefault,
        @JsonProperty("links")  final Map<String,String> links
    ) {
        this.id = id;
        this.fieldLabel = fieldLabel;
        this.fieldType = fieldType;
        this.fieldDefault = fieldDefault;

        if (links == null) {
            this.links = Collections.emptyMap();
        } else {
            this.links = Collections.unmodifiableMap(new HashMap<>(links));
        }
    }

    public Long getId() {
        return id;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getFieldDefault() {
        return fieldDefault;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Field{"
            + "id=" + id
            + ", fieldLabel='" + fieldLabel + '\''
            + ", fieldType='" + fieldType + '\''
            + ", fieldDefault='" + fieldDefault + '\''
            + ", links=" + links
            + '}';
    }
}
