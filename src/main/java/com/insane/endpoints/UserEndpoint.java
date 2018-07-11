package com.insane.endpoints;

import com.insane.repositories.UserRepository;
import com.insane.users.GetUserRequest;
import com.insane.users.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URL = "http://insane.com/users/";
    private final UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserResponse(@RequestPayload GetUserRequest getUserRequest){
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setUser(userRepository.findUser(getUserRequest.getName()));

        return getUserResponse;
    }
}
