/*
  Copyright (C) ${license.git.copyrightYears} Expedia Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.hotels.styx.support.api.matchers;

import static com.google.common.base.Preconditions.checkNotNull;

import com.hotels.styx.api.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public final class HttpStatusMatcher extends TypeSafeMatcher<HttpResponse> {
    public static Matcher<? super HttpResponse> hasStatus(HttpResponseStatus status) {
        return new HttpStatusMatcher(status);
    }

    private final HttpResponseStatus status;

    public HttpStatusMatcher(HttpResponseStatus status) {
        this.status = checkNotNull(status);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(status.code());
        description.appendText(" ");
        description.appendText(status.reasonPhrase());
    }

    @Override
    protected boolean matchesSafely(HttpResponse response) {
        return response.status() == status;
    }
}
