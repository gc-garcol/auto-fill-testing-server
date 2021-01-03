package gc.garcol.autofilltest.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author thai-van
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTestData {

    private String testCaseFileName;

    private String testCaseContent;

    private String executorContent;

}
