/*
 * Copyright 2012-2015 Brian Campbell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;

/**
 *
 */
public class JtiValidator implements Validator
{
    private boolean requireJti;


    public JtiValidator(boolean requireJti)
    {
        this.requireJti = requireJti;
    }

    @Override
    public String validate(JwtContext jwtContext) throws MalformedClaimException
    {
        String subject = jwtContext.getJwtClaims().getJwtId();
        return (subject == null && requireJti) ?  "The JWT ID (jti) claim is not present." : null;
    }
}
