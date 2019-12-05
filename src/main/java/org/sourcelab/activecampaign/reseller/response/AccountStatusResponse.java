/**
 * Copyright 2019 SourceLab.org https://github.com/SourceLabOrg/activecampaign-java-client
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

package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account Status Response.
 */
public class AccountStatusResponse {
    private final AccountStatus accountStatus;
    private final String accountStatusString;
    private final int resultCode;
    private final String resultMessage;

    @JsonCreator
    public AccountStatusResponse(
        @JsonProperty("status") final String accountStatusString,
        @JsonProperty("result_code") final int resultCode,
        @JsonProperty("result_message") final String resultMessage
    ) {
        this.accountStatus = AccountStatus.valueOf(accountStatusString.toUpperCase());
        this.accountStatusString = accountStatusString;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public String getAccountStatusString() {
        return accountStatusString;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public String toString() {
        return "AccountStatusResponse{"
            + "accountStatus=" + accountStatus
            + ", accountStatusString='" + accountStatusString + '\''
            + ", resultCode=" + resultCode
            + ", resultMessage='" + resultMessage + '\''
            + '}';
    }
}
