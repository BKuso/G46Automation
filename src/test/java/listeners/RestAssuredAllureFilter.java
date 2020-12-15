package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestAssuredAllureFilter extends AllureRestAssured {

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext filterContext) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        StepResult stepResult = (new StepResult()).setStatus(Status.PASSED)
                .setName(String.format("Запрос %s по ссылке: %s", requestSpec.getMethod(), requestSpec.getURI()));
        List<Parameter> params = new ArrayList<>();
        requestSpec.getRequestParams()
                .forEach((key, value) ->
                        params.add(new Parameter().setName(key)
                                .setValue(value)));
        requestSpec.getFormParams()
                .forEach((key, value) ->
                        params.add(new Parameter().setName(key)
                                .setValue(value)));
        stepResult.setParameters(params);
        lifecycle.startStep(UUID.randomUUID()
                .toString(), stepResult);

        Response response;
        try {
            response = super.filter(requestSpec, responseSpec, filterContext);
        } finally {
            lifecycle.stopStep();
        }
        return response;
    }

}
