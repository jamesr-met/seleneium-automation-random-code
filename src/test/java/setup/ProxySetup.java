package setup;

public class ProxySetup {
    private static final String USERNAME = "jamesroberts19";
    private static final String AUTOMATE_KEY = "siHfzRmmrVJhPd1vS9yn";

    public ProxySetup(){
        System.getProperties().put("https.proxyHost", "webproxy.metoffice.gov.uk");
        System.getProperties().put("https.proxyPort", "8080");
        System.getProperties().put("https.proxyUser", USERNAME);
        System.getProperties().put("https.proxyPassword", AUTOMATE_KEY);
    }
}

