package id.web.crudretrofit.activity.main;

import java.util.List;

import id.web.crudretrofit.model.Note;

public interface MainView {
    void showLoading ();
    void hideLoading ();
    void onGetResult (List<Note> notes);
    void onErrorLoading (String message);
}
