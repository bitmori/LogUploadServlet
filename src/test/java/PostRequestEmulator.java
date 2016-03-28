import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;

/**
 * Created by kirk on 3/27/16.
 */
public class PostRequestEmulator {
    private static final String BOUNDARY ="---_SYMPHONY16_--/--U1lNUEhPTlkxNg==---";

    public static void main(String[] args) throws Exception {
        doUploadFile("/Users/kirk/Developer/utils/upload_test/file1.txt");
        doUploadFile("/Users/kirk/Developer/utils/upload_test/file2.txt");
        doUploadFile("/Users/kirk/Developer/utils/upload_test/file3.txt");
    }

    private static void doUploadFile(String fileName) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost.symphony.com:8080/logshredder/upload");
        httpPost.addHeader("Accept", "text/plain");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setBoundary(BOUNDARY);
        FileBody bin = new FileBody(new File(fileName));
        builder.addPart("data", bin);
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
//        HttpResponse response = client.execute(httpPost);
//        String responseString = new BasicResponseHandler().handleResponse(response);
//        System.out.println(responseString);
    }
}
