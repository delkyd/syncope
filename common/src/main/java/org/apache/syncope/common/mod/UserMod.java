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
package org.apache.syncope.common.mod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.syncope.common.to.PropagationRequestTO;

@XmlRootElement(name = "userMod")
@XmlType
public class UserMod extends AbstractAttributableMod {

    private static final long serialVersionUID = 3081848906558106204L;

    private String password;

    private String username;

    private final Set<MembershipMod> membershipsToBeAdded;

    private final Set<Long> membershipsToBeRemoved;

    private PropagationRequestTO pwdPropRequest;

    public UserMod() {
        super();

        membershipsToBeAdded = new HashSet<MembershipMod>();
        membershipsToBeRemoved = new HashSet<Long>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @XmlElementWrapper(name = "membershipsToBeAdded")
    @XmlElement(name = "membership")
    @JsonProperty("membershipsToBeAdded")
    public Set<MembershipMod> getMembershipsToBeAdded() {
        return membershipsToBeAdded;
    }

    @XmlElementWrapper(name = "membershipsToBeRemoved")
    @XmlElement(name = "membership")
    @JsonProperty("membershipsToBeRemoved")
    public Set<Long> getMembershipsToBeRemoved() {
        return membershipsToBeRemoved;
    }

    public PropagationRequestTO getPwdPropRequest() {
        return pwdPropRequest;
    }

    public void setPwdPropRequest(final PropagationRequestTO pwdPropRequest) {
        this.pwdPropRequest = pwdPropRequest;
    }

    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return super.isEmpty()
                && password == null
                && username == null
                && membershipsToBeAdded.isEmpty()
                && membershipsToBeRemoved.isEmpty()
                && pwdPropRequest == null;
    }
}