/*
 *  Copyright 2019 http://www.hswebframework.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.hswebframework.web.authorization.oauth2.server.support.code;

import org.hswebframework.web.authorization.oauth2.server.exception.GrantTokenException;
import org.hswebframework.web.authorization.oauth2.server.support.HttpTokenRequest;
import org.hswebframework.web.oauth2.core.ErrorType;
import org.hswebframework.web.oauth2.core.OAuth2Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * TODO 完成注释
 *
 * @author zhouhao
 */
public class HttpAuthorizationCodeRequest extends HttpTokenRequest implements AuthorizationCodeRequest {
    private String userId;

    public HttpAuthorizationCodeRequest(String userId, HttpServletRequest request) {
        super(request);
        this.userId = userId;
    }

    @Override
    public String getClientId() {
        return getParameter(OAuth2Constants.client_id)
                .orElseThrow(() -> new GrantTokenException(ErrorType.ILLEGAL_CLIENT_ID));
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    @Override
    public String getRedirectUri() {
        return getParameter(OAuth2Constants.redirect_uri).orElse(null);
    }

}
