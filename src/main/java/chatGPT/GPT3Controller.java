package chatGPT;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt3")
public class GPT3Controller {

    private final OkHttpClient httpClient = new OkHttpClient();
    private final String apiKey = "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";
    
    @PostMapping
    public String generateResponse(@RequestParam(value = "prompt", required = true) String prompt) throws Exception {
        if(prompt==null){
            return "prompt parameter is missing";
        }
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\":\"" + prompt + "\",\"max_tokens\": 100}");
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci/completions")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String result = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(result);
            return jsonNode.get("choices").get(0).get("text").asText();
        }
    }
}
