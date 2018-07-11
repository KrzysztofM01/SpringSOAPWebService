package clients;

import countries.GetCountryRequest;
import countries.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountryResponse (String name) {
        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setName(name);
        GetCountryResponse getCountryResponse = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(getCountryRequest);

        return getCountryResponse;
    }

}
