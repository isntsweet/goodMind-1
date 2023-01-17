package chatGPT2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

	public interface OpenAI {
	    @Headers("Content-Type: application/json")
	    @POST("engines/davinci/completions")
	    Call<CompletionResponse> completions(
	            @Header("Authorization") String apiKey,
	            @Body CompletionRequest request
	    );
	}
