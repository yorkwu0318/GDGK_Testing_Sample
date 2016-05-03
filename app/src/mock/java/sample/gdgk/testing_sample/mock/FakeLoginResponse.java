package sample.gdgk.testing_sample.mock;

import sample.gdgk.testing_sample.model.LoginResponse;

public class FakeLoginResponse {
    public static LoginResponse mockSuccessResponse() {
        LoginResponse response = new LoginResponse();
        response.status = 1;
        return response;
    }

    public static LoginResponse mockFailedResponse() {
        LoginResponse response = new LoginResponse();
        response.status = 0;
        return response;
    }

}
