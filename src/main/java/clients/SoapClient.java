package clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import users.GetUserRequest;
import users.GetUserResponse;

public class SoapClient extends WebServiceGatewaySupport {

    public GetUserResponse getUserResponse(String name) {
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setName(name);

        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(getUserRequest);
    }

}
