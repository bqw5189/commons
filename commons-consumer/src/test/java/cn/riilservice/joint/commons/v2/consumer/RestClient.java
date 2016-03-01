
package cn.riilservice.joint.commons.v2.consumer;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author baiqw
 */
public class RestClient {

  public static void main(String[] args) {
      final String port = "8898";
      String REST_SERVICE_URL = "http://localhost:" + port + "/api/v2/messages/send";
      push(REST_SERVICE_URL, MediaType.APPLICATION_JSON_TYPE);
  }

  private static void push(String url, MediaType mediaType) {
      System.out.println("send : " + url);

      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(url).path("/{phoneNumber}").queryParam("content", "您的验证码:1234");
      Response response = target.resolveTemplate("phoneNumber", "15801632955").request(mediaType).get();

      try {
          if (response.getStatus() != 200) {
              throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
          }
          System.out.println("Successfully got result: " + response.readEntity(String.class));
      } finally {
          response.close();
          client.close();
      }
  }
}
