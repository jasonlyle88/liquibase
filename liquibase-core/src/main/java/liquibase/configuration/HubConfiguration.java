package liquibase.configuration;

import liquibase.util.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration container for global properties.
 */
public class HubConfiguration extends AbstractConfigurationContainer {

    public static final String LIQUIBASE_HUB_API_KEY = "apiKey";
    public static final String LIQUIBASE_HUB_URL = "url";
    public static final String LIQUIBASE_HUB_PROJECT = "project";
    public static final String LIQUIBASE_HUB_MODE = "mode";

    public HubConfiguration() {
        super("liquibase.hub");

        getContainer().addProperty(LIQUIBASE_HUB_API_KEY, String.class)
                .setDescription("Liquibase Hub API key for operations");
        getContainer().addProperty(LIQUIBASE_HUB_URL, String.class)
                .setDescription("Liquibase Hub URL for operations");
        getContainer().addProperty(LIQUIBASE_HUB_PROJECT, String.class)
                .setDescription("Liquibase Hub Project for operations");
        getContainer().addProperty(LIQUIBASE_HUB_MODE, String.class)
                .setDescription("Liquibase Hub mode for operations. Values can be 'realtime' or 'off'")
                .setDefaultValue("REALTIME");
    }

    @Override
    public void setValue(String propertyName, Object value) {
        super.setValue(propertyName, value);
    }

    public String getLiquibaseHubApiKey() {
        return getContainer().getValue(LIQUIBASE_HUB_API_KEY, String.class);
    }

    public HubConfiguration setLiquibaseHubApiKey(String liquibaseHubApiKey) {
        getContainer().setValue(LIQUIBASE_HUB_API_KEY, liquibaseHubApiKey);
        return this;
    }

    public HubConfiguration setLiquibaseHubUrl(String liquibaseHubUrl) {
        getContainer().setValue(LIQUIBASE_HUB_URL, liquibaseHubUrl);
        return this;
    }

    public String getLiquibaseHubUrl() {
        String hubUrl = getContainer().getValue(LIQUIBASE_HUB_URL, String.class);
        if (hubUrl == null || hubUrl.isEmpty()) {
            return "https://hub.liquibase.com/api/v1/";
        }
        return hubUrl;
    }

    public HubConfiguration setLiquibaseHubProject(String liquibaseHubProject) {
        getContainer().setValue(LIQUIBASE_HUB_PROJECT, liquibaseHubProject);
        return this;
    }

    public String getLiquibaseHubProject() {
        String project = getContainer().getValue(LIQUIBASE_HUB_PROJECT, String.class);
        return project;
    }

    public HubConfiguration setLiquibaseHubMode(String liquibaseHubMode) {
        getContainer().setValue(LIQUIBASE_HUB_MODE, liquibaseHubMode);
        return this;
    }

    public String getLiquibaseHubMode() {
        final String value = getContainer().getValue(LIQUIBASE_HUB_MODE, String.class);

        final List<String> validValues = Arrays.asList("realtime", "off");
        if (!validValues.contains(value.toLowerCase())) {
            throw new RuntimeException("Unknown liquibase.hub.mode: " + value + ". Possible values: " + StringUtil.join(validValues, ", "));
        }
        return value;
    }
}
