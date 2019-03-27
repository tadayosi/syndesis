/*
 * Copyright (C) 2016 Red Hat, Inc.
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
package io.syndesis.connector.box;

import java.util.Map;

import io.syndesis.integration.component.proxy.ComponentDefinition;
import io.syndesis.integration.component.proxy.ComponentProxyComponent;
import org.apache.camel.Component;
import org.apache.camel.component.box.BoxComponent;
import org.apache.camel.component.box.BoxConfiguration;
import org.apache.camel.component.box.internal.BoxApiName;
import org.apache.camel.util.IntrospectionSupport;

public class BoxConnector extends ComponentProxyComponent {

    public BoxConnector(String componentId, String componentScheme) {
        super(componentId, componentScheme);
    }

    @Override
    protected void configureDelegateComponent(ComponentDefinition definition, Component component, Map<String, Object> options) throws Exception {
        super.configureDelegateComponent(definition, component, options);

        if (component instanceof BoxComponent) {
            options.put("apiName", BoxApiName.fromValue(options.get("apiName").toString()));
            BoxConfiguration configuration = new BoxConfiguration();
            IntrospectionSupport.setProperties(configuration, options);
            BoxComponent boxComponent = (BoxComponent) component;
            boxComponent.setConfiguration(configuration);
        }
    }
}
