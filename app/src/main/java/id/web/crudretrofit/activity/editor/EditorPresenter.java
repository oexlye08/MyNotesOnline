package id.web.crudretrofit.activity.editor;

import android.widget.Toast;

import androidx.annotation.NonNull;

import id.web.crudretrofit.api.ApiClient;
import id.web.crudretrofit.api.ApiInterface;
import id.web.crudretrofit.model.Note;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private EditorView view;
    public EditorPresenter(EditorView view){
        this.view = view;
    }

     void saveNote(final String title, final String note, final  int color) {

        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Note> call = apiInterface.saveNote(title, note, color);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(@NonNull Call<Note> call, @NonNull Response<Note> response) {
                view.hideProgress();

                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddSuccess(response.body().getMessage());
//                        Toast.makeText(EditorActivity.this, response.body().getMessage(),
//                                Toast.LENGTH_SHORT).show();
//                        finish(); //back to MainActivity
                    } else {

                        view.onAddError(response.body().getMessage());
//                        Toast.makeText(EditorActivity.this, response.body().getMessage(),
//                                Toast.LENGTH_SHORT).show();
//                        //if error still in this act
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<Note> call,@NonNull Throwable t) {
               view.hideProgress();
               view.onAddError(t.getLocalizedMessage());
//                Toast.makeText(EditorActivity.this,
//                        t.getLocalizedMessage(),
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
