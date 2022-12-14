package iss.workshop.livestreamapp.interfaces;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import iss.workshop.livestreamapp.LoginActivity;
import iss.workshop.livestreamapp.models.User;

public interface ISessionUser {

    default boolean isValidated(SharedPreferences sPref, String username, String password){
        //SharedPreferences.Editor editor = sPref.edit();
        if(sPref.contains("username") && sPref.contains("password")){
            String checkUsername = sPref.getString("username", null);
            String checkPassword = sPref.getString("password", null);

            if (username.equals(checkUsername) && password.equals(checkPassword)) return true;
        }

        return false;
    }

    default void logOut(SharedPreferences sPref, Context context){
        SharedPreferences.Editor editor = sPref.edit();
        editor.clear().apply();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

}
