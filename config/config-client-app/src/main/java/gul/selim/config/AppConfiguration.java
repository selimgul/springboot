package gul.selim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class AppConfiguration {

    @Value("${spring.cloud.services.registrationMethod:Not Set}")
    private String registrationMethod;

    @Value("${ConnectionStrings.docyon:Not Set}")
    private String connstring;

    @Value("${ServiceSettings.UserSkillDefinitionServiceSetting.Url:Not Set}")
    private String url;

    @Value("${ServiceSettings.UserSkillDefinitionServiceSetting.Timeout: 0}")
    private Integer timeout;

    public String getRegistrationMethod() {
        return registrationMethod;
    }

    public String getConnstring() {
        return connstring;
    }

    public String getUrl() {
        return url;
    }

    public Integer getTimeout() {
        return timeout;
    }
}
