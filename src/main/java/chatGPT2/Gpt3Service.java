package chatGPT2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class Gpt3Service {
    private final OpenAI openAI;

    public Gpt3Service(@Value("${openai.apiKey}") String apiKey) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        openAI = retrofit.create(OpenAI.class);
    }
    // create methods to interact with the OpenAI API using the openAI object
}
