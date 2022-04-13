public class ServiceProvider {

  private static final String APIKey2 = "WCMO7A7k73z9uonOvoTu8HPuuz5An0e2gSIjrJBh";
  // This is hardcoded at the moment, will change once we make the user interface and allow the user to add its own key.
  // You should change that with your own private key for testing purposes.
  private static final String APIKey = "WCMO7A7k73z9uonOvoTu8HPuuz5An0e2gSIjrJBh";
  private static final String APIKey3 = "WCMO7A7k73z9uonOvoTu8HPuuz5An0e2gSIjrJBh";

  public static String getApiKey3() {
    return APIKey3;
  }
  public static String getAPIKey() {
    return APIKey;
  }

  public static String getAPIKey2() {
    return APIKey2;
  }
}
