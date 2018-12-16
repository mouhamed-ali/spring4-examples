package org.spring.tutorial.examples.core.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;


@Configuration
@PropertySource("mail.properties")
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    /*
     * get simple properties
     */
    private String host;
    private Integer port;
    @Value("${mail.from}")//map the value if the attribute does not match
    private String fromSender;

    /*
     * list
     */
    private List<String> defaultRecipients;

    /*
     * Map
     */
    private Map<String, String> additionalHeaders;

    /*
     * Objet
     */
    private Credentials credentials;

    public String getHost() {
        return host;
    }

    public MailConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public MailConfig setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getFromSender() {
        return fromSender;
    }

    public MailConfig setFromSender(String fromSender) {
        this.fromSender = fromSender;
        return this;
    }

    public List<String> getDefaultRecipients() {
        return defaultRecipients;
    }

    public MailConfig setDefaultRecipients(List<String> defaultRecipients) {
        this.defaultRecipients = defaultRecipients;
        return this;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public MailConfig setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
        return this;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public MailConfig setCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    @Override
    public String toString() {
        return "MailConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", fromSender='" + fromSender + '\'' +
                '}';
    }
}
