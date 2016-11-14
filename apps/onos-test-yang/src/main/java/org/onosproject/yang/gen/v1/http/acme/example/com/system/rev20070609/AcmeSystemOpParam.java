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

import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.onosproject.yang.gen.v1.http.acme.example.com.system.rev20070609.acmesystem.System;

/**
 * Represents the implementation of acmeSystem.
 */
public class AcmeSystemOpParam implements AcmeSystem {

    protected System system;

    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public enum OnosYangNodeOperationType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, will be ignored in query operation
     */
    private OnosYangNodeOperationType onosYangNodeOperationType;

    public System system() {
        return system;
    }
    /**
     * Returns the onosYangNodeOperationType.
     *
     * @return value of onosYangNodeOperationType
     */
    public OnosYangNodeOperationType onosYangNodeOperationType() {
        return onosYangNodeOperationType;
    }


    @Override
    public int hashCode() {
        return Objects.hash(system);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AcmeSystemOpParam) {
            AcmeSystemOpParam other = (AcmeSystemOpParam) obj;
            return
                 Objects.equals(system, other.system);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .add("system", system)
            .toString();
    }

    /**
     * Creates an instance of acmeSystem.
     *
     * @param builderObject builder object of acmeSystem
     */
    protected AcmeSystemOpParam(AcmeSystemBuilder builderObject) {
        this.system = builderObject.system();
        this.onosYangNodeOperationType = builderObject.onosYangNodeOperationType();
    }

    @Override
    public AcmeSystem processSubtreeFiltering(AcmeSystem appInstance, boolean isSelectAllSchemaChild) {
        AcmeSystemBuilder subTreeFilteringResultBuilder = new AcmeSystemBuilder();
        Boolean isAnySelectOrContainmentNode = false;
        if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
            isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode) {
            return processSubtreeFiltering(appInstance, true);
        }
        return subTreeFilteringResultBuilder.build();
    }
    private boolean processChildNodesSubTreeFiltering(AcmeSystem appInstance, AcmeSystemBuilder
            subTreeFilteringResultBuilder,
            Boolean isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (system()  != null) {
            isAnySelectOrContainmentNode = true;
            if (appInstance.system() != null) {
                System result = system.processSubtreeFiltering(appInstance.system(), false);
                if (result != null) {
                    subTreeFilteringResultBuilder.system(result);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of acmeSystemOpParam.
     */
    protected AcmeSystemOpParam() {
    }

    /**
     * Returns the attribute AcmeSystemBuilder.
     *
     * @return value of AcmeSystemBuilder
     */
    public static AcmeSystemBuilder builder() {
        return new AcmeSystemBuilder();
    }


    /**
     * Represents the builder implementation of acmeSystem.
     */
    public static class AcmeSystemBuilder {

        protected System system;

        /**
         * Specify the node specific operation in protocols like NETCONF.
         * Applicable in protocol edit operation, will be ignored in query operation
         */
        private OnosYangNodeOperationType onosYangNodeOperationType;


        public System system() {
            return system;
        }

        /**
         * Returns the builder object of system.
         *
         * @param system value of system
         * @return builder object of system
         */
        public AcmeSystemBuilder system(System system) {
            this.system = system;
            return this;
        }
        /**
         * Returns the onosYangNodeOperationType.
         *
         * @return value of onosYangNodeOperationType
         */
        public OnosYangNodeOperationType onosYangNodeOperationType() {
            return onosYangNodeOperationType;
        }

        /**
         * Set node operation type.
         *
         * @param onosYangNodeOperationType node operation type
         * @return builder object for node operation type
         */
        public AcmeSystemBuilder onosYangNodeOperationType(OnosYangNodeOperationType onosYangNodeOperationType) {
           this.onosYangNodeOperationType = onosYangNodeOperationType;
           return this;
        }


        public AcmeSystem build() {
            return new AcmeSystemOpParam(this);
        }

        /**
         * Creates an instance of acmeSystemBuilder.
         */
        public AcmeSystemBuilder() {
        }
    }
}
