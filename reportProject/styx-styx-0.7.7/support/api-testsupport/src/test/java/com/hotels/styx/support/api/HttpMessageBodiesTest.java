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
package com.hotels.styx.support.api;

import com.hotels.styx.api.HttpRequest;
import com.hotels.styx.api.HttpResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.testng.annotations.Test;
import rx.Observable;

import static com.hotels.styx.api.HttpRequest.Builder.post;
import static com.hotels.styx.api.HttpResponse.Builder.response;
import static com.hotels.styx.support.api.HttpMessageBodies.bodyAsString;
import static io.netty.util.CharsetUtil.UTF_8;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HttpMessageBodiesTest {
    @Test
    public void createsRequestBodyString() {
        HttpRequest request = post("/").body("Hello, World!").build();

        assertThat(bodyAsString(request), is("Hello, World!"));
    }

    @Test
    public void createsRequestBodyStringFromObservable() {
        HttpRequest request = post("/").body(byteBufObservable("Hello,", " Wor", "ld!")).build();

        assertThat(bodyAsString(request), is("Hello, World!"));
    }

    @Test
    public void createsResponseBodyString() {
        HttpResponse response = response().body("Hello, World!").build();

        assertThat(bodyAsString(response), is("Hello, World!"));
    }

    @Test
    public void createsResponseBodyStringFromObservable() {
        HttpResponse response = response().body(byteBufObservable("Hello,", " Wor", "ld!")).build();

        assertThat(bodyAsString(response), is("Hello, World!"));
    }


    private static Observable<ByteBuf> byteBufObservable(String... strings) {
        return Observable.from(stream(strings)
                .map(HttpMessageBodiesTest::buf)
                .collect(toList()));
    }

    private static ByteBuf buf(CharSequence charSequence) {
        return Unpooled.copiedBuffer(charSequence, UTF_8);
    }
}