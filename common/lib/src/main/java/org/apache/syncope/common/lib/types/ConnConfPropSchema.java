/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.common.lib.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.syncope.common.lib.AbstractBaseBean;

@XmlRootElement
@XmlType
public class ConnConfPropSchema extends AbstractBaseBean implements Comparable<ConnConfPropSchema> {

    private static final long serialVersionUID = -1976365781005801296L;

    private String name;

    private String displayName;

    private String helpMessage;

    private String type = String.class.getName();

    private boolean required;

    private int order;

    private boolean confidential;

    private final List<Object> defaultValues = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(final boolean required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(final String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }

    public boolean isConfidential() {
        return confidential;
    }

    public void setConfidential(final boolean confidential) {
        this.confidential = confidential;
    }

    @XmlElementWrapper(name = "defaultValues")
    @XmlElement(name = "defaultValue")
    @JsonProperty("defaultValues")
    public List<Object> getDefaultValues() {
        return defaultValues;
    }

    @Override
    public int compareTo(final ConnConfPropSchema other) {
        return this.getOrder() > other.getOrder()
                ? 1
                : this.getOrder() < other.getOrder()
                        ? -1
                        : 0;
    }
}
