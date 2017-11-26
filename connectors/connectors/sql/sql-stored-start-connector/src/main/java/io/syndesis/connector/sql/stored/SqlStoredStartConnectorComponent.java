/*
 * Copyright (C) 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.connector.sql.stored;

import java.util.Map;

import org.apache.camel.Processor;
import org.apache.camel.component.connector.DefaultConnectorComponent;

import static io.syndesis.connector.sql.stored.JSONBeanUtil.mapToJSONBean;

/**
 * Camel SqlStoredStartConnector connector
 */
public class SqlStoredStartConnectorComponent extends DefaultConnectorComponent {

    public SqlStoredStartConnectorComponent() {
        this(null);
    }

    public SqlStoredStartConnectorComponent(String componentSchema) {
        super("start-connector", componentSchema, "io.syndesis.connector.sql.stored.SqlStoredStartConnectorComponent");

        registerExtension(SqlStoredConnectorVerifierExtension::new);
        registerExtension(SqlStoredConnectorMetaDataExtension::new);
    }

    @Override
    public Processor getAfterProducer() {
        final Processor processor = exchange -> {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) exchange.getIn().getBody();
            String jsonBean = mapToJSONBean(map);
            exchange.getIn().setBody(jsonBean);
        };
        return processor;
    }
}
