package gul.selim.model;

public class Config {

    private String registrationMethod;

    private String connstring;

    private String url;

    private Integer timeout;

    public String getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(String registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public String getConnstring() {
        return connstring;
    }

    public void setConnstring(String connstring) {
        this.connstring = connstring;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
