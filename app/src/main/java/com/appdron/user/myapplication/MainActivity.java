package com.appdron.user.myapplication;


        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
        import android.widget.Toast;

        import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText passEditText;
    private EditText pass2EditText;
    private EditText address;
    private EditText emailEditText;
    private EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Address the email and password field
        name = (EditText) findViewById(R.id.username);
        passEditText = (EditText) findViewById(R.id.password);
        pass2EditText= (EditText) findViewById(R.id.password1);
        address = (EditText) findViewById(R.id.address);
        emailEditText = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);

    }

    public void checkLogin(View arg0) {




        final String nme = name.getText().toString();
        if (nme.matches("")) {
            //Set error message for password field
            name.setError("Name cannot be empty");
        }



        final String addr = address.getText().toString();
        if (addr.matches("")) {
            //Set error message for password field
            address.setError("Address cannot be empty");
        }


        final String phn = phone.getText().toString();
        if (!isValidPhone(phn)) {
            //Set error message for password field
            phone.setError("Invalid Phone no");
        }



        final String email = emailEditText.getText().toString();
        if (!isValidEmail(email)) {
            //Set error message for email field
            emailEditText.setError("Invalid Email");
        }

        final String pass = passEditText.getText().toString();
        final String pass1 = pass2EditText.getText().toString();
        if(!pass.matches(pass1))
        {

            Toast.makeText(getApplicationContext(),"Enter same password in both fields",Toast.LENGTH_SHORT).show();
        }
        if (!isValidPassword(pass)) {
            //Set error message for password field
            passEditText.setError("Enter at least 4 characters");
        }
        if (!isValidPassword(pass1)) {
            //Set error message for password field
            pass2EditText.setError("Enter at least 4 characters");
        }




        if(isValidEmail(email) && isValidPassword(pass))
        {
            // Validation Completed
        }

    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private  boolean isValidPhone(String phone)
    {
        String phoneno = "^[7-9][0-9]{9}$";

        Pattern pattern = Pattern.compile(phoneno);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();



    }

    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }
}
