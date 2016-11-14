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

package org.onosproject.yang.gen.v1.http.acme.example.com.system.rev20070609.acmesystem;

import java.util.Map;
import org.onosproject.yang.gen.v1.http.acme.example.com.system.rev20070609.acmesystem.system.Login;

/**
 * Abstraction of an entity which represents the functionality of system.
 */
public interface System {

    /**
     * Returns the attribute login.
     *
     * @return value of login
     */
    Login login();

    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of Augmentedclass
     * @return value of YangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Checks if the passed System maps the content match query condition.
     *
     * @param system system being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    System processSubtreeFiltering(System system, boolean isSelectAllSchemaChild);

    /**
     * Builder for system.
     */
    interface SystemBuilder {

        /**
         * Returns the attribute login.
         *
         * @return value of login
         */
        Login login();

        /**
         * Returns the builder object of login.
         *
         * @param login value of login
         * @return builder object of login
         */
        SystemBuilder login(Login login);


        /**
         * Sets the value of yangAugmentedInfoMap.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of Augmentedclass
         */
        void addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of Augmentedclass
         * @return value of YangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Builds object of system.
         *
         * @return object of system.
         */
        System build();
    }
}
