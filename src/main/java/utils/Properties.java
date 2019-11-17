package utils;

public class Properties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    public static final String baseUri = propertiesReader.getBaseUri();
    public static final String userRecordEndPoint = propertiesReader.getUserRecordEndPoint();
    public static final String authenticateEndPoint = propertiesReader.getAuthenticateEndPoint();
    public static final String userRecordByPhoneEndPoint = propertiesReader.getUserRecordByPhoneEndPoint();
    public static final String getUserName = propertiesReader.getName();
    public static final String getPassword = propertiesReader.getPassword();


}
