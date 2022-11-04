package ru.rsreu.businesssoftdevcourse.dao.config;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Override
    protected @NonNull String getKeyspaceName() {
        return "autoservice";
    }

    @Override
    public @NonNull SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"ru.rsreu.businesssoftdevcourse.model"};
    }
}
