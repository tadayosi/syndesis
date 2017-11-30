package io.syndesis.connector.sql.springboot;

import javax.annotation.Generated;
import javax.sql.DataSource;

/**
 * SQL Connector perform CRUD operations on a database
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.connector.SpringBootAutoConfigurationMojo")
public class SqlStartConnectorConnectorConfigurationCommon {

    /**
     * Sets the DataSource to use to communicate with the database.
     */
    private DataSource dataSource;
    /**
     * Sets the SQL query to perform. You can externalize the query by using
     * file: or classpath: as prefix and specify the location of the file.
     */
    private String query;
    /**
     * Delay in milli seconds between scheduling (executing)
     */
    private long schedulerPeriod = 1000L;
    /**
     * DB User Name
     */
    private String user;
    /**
     * DB User Password
     */
    private String password;
    /**
     * DB URL
     */
    private String url;
    /**
     * DB Schema
     */
    private String schema;
    /**
     * DB Catalog
     */
    private String catalog;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public long getSchedulerPeriod() {
        return schedulerPeriod;
    }

    public void setSchedulerPeriod(long schedulerPeriod) {
        this.schedulerPeriod = schedulerPeriod;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}