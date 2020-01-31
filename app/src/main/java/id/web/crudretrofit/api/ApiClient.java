package id.web.crudretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/** link download sql database https://pastebin.com/GyCpfUkd*/
/** link download api connect https://pastebin.com/448ijkXx*/
/** link download api delete https://pastebin.com/i8Aed7jf*/
/** link download api notes https://pastebin.com/DxrDTQPm*/
/** link download api save https://pastebin.com/Ykinbfcr*/
/** link download api update https://pastebin.com/LVXG4Lu8*/


public class ApiClient {

//    private static final String BASE_URL = "http://206.189.6.93:8087/oki/";
    private static final String BASE_URL = "https://insufficient-roads.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
