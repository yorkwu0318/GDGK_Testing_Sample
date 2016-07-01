package sample.gdgk.testing_sample.mock;

import sample.gdgk.testing_sample.model.LoginResponse;

public class FakeLoginResponse {
    public static LoginResponse mockSuccessResponse() {
        return new LoginResponse(1);
    }

    public static LoginResponse mockFailedResponse() {
        return new LoginResponse(0);
    }

}
