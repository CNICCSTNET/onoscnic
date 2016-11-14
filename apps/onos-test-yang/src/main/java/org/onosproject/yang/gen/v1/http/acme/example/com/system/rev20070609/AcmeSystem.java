/*
 * Copyright 2016-present Open Networking Laboratory
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

package org.onosproject.yang.gen.v1.http.acme.example.com.system.rev20070609;

import org.onosproject.yang.gen.v1.http.acme.example.com.system.rev20070609.acmesystem.System;

/**
 * Abstraction of an entity which represents the functionality of acmeSystem.
 */
public interface AcmeSystem {

    /**
     * Returns the attribute system.
     *
     * @return value of system
     */
    System system();

    /**
     * Checks if the passed AcmeSystem maps the content match query condition.
     *
     * @param acmeSystem acmeSystem being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    AcmeSystem processSubtreeFiltering(AcmeSystem acmeSystem, boolean isSelectAllSchemaChild);
}
