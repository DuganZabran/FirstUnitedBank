package jlong_games_and_playback_studios.firstunitedbank;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Gameplay extends AppCompatActivity {
    private RelativeLayout check, id, depositSlip, passport, main, checkLarge, idLarge, depositSlipLarge, passportLarge;
    private int _xDelta, _yDelta, timesTouched;
    private TextView check_large_pay_to_the_order_of, check_large_total_number, check_large_total_written, check_large_for, check_large_signature, check_large_routing_number, check_large_acount_number, check_large_date;
    private TextView id_large_name, id_large_date_of_birth, id_large_address, id_large_sex, id_large_height, id_large_issued, id_large_expires, id_large_signature;
    private ImageView id_large_photograph;
    private TextView passport_large_name, passport_large_date_of_birth, passport_large_expires_date, passport_large_signature, passport_large_sex, passport_large_address;
    private ImageView passport_large_image;
    private Person person;
    private TextView check_small_pay_to_the_order_of, check_small_total_numbers, check_small_total_written, check_small_for, check_small_signature, check_small_date, check_small_routing_number, check_small_account_number;
    private ImageView id_small_photograph;
    private TextView id_small_name, id_small_date_of_birth, id_small_address, id_small_sex, id_small_height, id_small_issued, id_small_expires, id_small_signature;
    private ImageView passport_small_image;
    private TextView passport_small_name, passport_small_date_of_birth, passport_small_expires_date, passport_small_signature, passport_small_sex, passport_small_address;
    private ImageView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
            //Create the layout vars

            check = (RelativeLayout) findViewById(R.id.check_small_layout);
            checkLarge = (RelativeLayout) findViewById(R.id.check_large_layout);
            id = (RelativeLayout) findViewById(R.id.id_small_layout);
            idLarge = (RelativeLayout) findViewById(R.id.id_large_layout);
            depositSlip = (RelativeLayout) findViewById(R.id.deposit_slip_small_layout);
            depositSlipLarge = (RelativeLayout) findViewById(R.id.deposit_slip_large_layout);
            passport = (RelativeLayout) findViewById(R.id.passport_small);
            passportLarge = (RelativeLayout) findViewById(R.id.passport_large);
            main = (RelativeLayout) findViewById(R.id.gameplay_layout);

            passport_small_name = (TextView) findViewById(R.id.passport_small_name);
            passport_small_date_of_birth = (TextView) findViewById(R.id.passport_small_date_of_birth);
            passport_small_expires_date = (TextView) findViewById(R.id.passport_small_expires_date);
            passport_small_signature = (TextView) findViewById(R.id.passport_small_signature);
            passport_small_image = (ImageView) findViewById(R.id.passport_small_image);
            passport_small_sex = (TextView) findViewById(R.id.passport_small_sex);
            passport_small_address = (TextView) findViewById(R.id.passport_small_address);

            id_small_name = (TextView) findViewById(R.id.id_small_name);
            id_small_date_of_birth = (TextView) findViewById(R.id.id_small_date_of_birth);
            id_small_address = (TextView) findViewById(R.id.id_small_address);
            id_small_sex = (TextView) findViewById(R.id.id_small_sex);
            id_small_height = (TextView) findViewById(R.id.id_small_height);
            id_small_issued = (TextView) findViewById(R.id.id_small_issued);
            id_small_expires = (TextView) findViewById(R.id.id_small_expires);
            id_small_signature = (TextView) findViewById(R.id.id_small_signature);
            id_small_photograph = (ImageView) findViewById(R.id.id_small_photograph);

            check_small_pay_to_the_order_of = (TextView) findViewById(R.id.check_small_pay_to_the_order_of);
            check_small_total_numbers = (TextView) findViewById(R.id.check_small_total_numbers);
            check_small_total_written = (TextView) findViewById(R.id.check_small_total_written);
            check_small_for = (TextView) findViewById(R.id.check_small_for);
            check_small_signature = (TextView) findViewById(R.id.check_small_signature);
            check_small_date = (TextView) findViewById(R.id.check_small_date);
            check_small_routing_number = (TextView) findViewById(R.id.check_small_routing_number);
            check_small_account_number = (TextView) findViewById(R.id.check_small_account_number);

            check_large_date = (TextView) findViewById(R.id.check_large_date);
            check_large_acount_number = (TextView) findViewById(R.id.check_large_acount_number);
            check_large_routing_number = (TextView) findViewById(R.id.check_large_routing_number);
            check_large_signature = (TextView) findViewById(R.id.check_large_signature);
            check_large_for = (TextView) findViewById(R.id.check_large_for);
            check_large_total_written = (TextView) findViewById(R.id.check_large_total_written);
            check_large_total_number = (TextView) findViewById(R.id.check_large_total_number);
            check_large_pay_to_the_order_of = (TextView) findViewById(R.id.check_large_pay_to_the_order_of);

            id_large_name = (TextView) findViewById(R.id.id_large_name);
            id_large_date_of_birth = (TextView) findViewById(R.id.id_large_date_of_birth);
            id_large_address = (TextView) findViewById(R.id.id_large_address);
            id_large_sex = (TextView) findViewById(R.id.id_large_sex);
            id_large_height = (TextView) findViewById(R.id.id_large_height);
            id_large_issued = (TextView) findViewById(R.id.id_large_issued);
            id_large_expires = (TextView) findViewById(R.id.id_large_expires);
            id_large_signature = (TextView) findViewById(R.id.id_large_signature);
            id_large_photograph = (ImageView) findViewById(R.id.id_large_photograph);

            passport_large_name = (TextView) findViewById(R.id.passport_large_name);
            passport_large_date_of_birth = (TextView) findViewById(R.id.passport_large_date_of_birth);
            passport_large_expires_date = (TextView) findViewById(R.id.passport_large_expires_date);
            passport_large_signature = (TextView) findViewById(R.id.passport_large_signature);
            passport_large_image = (ImageView) findViewById(R.id.passport_large_image);
            passport_large_address = (TextView) findViewById(R.id.passport_large_address);
            passport_large_sex = (TextView) findViewById(R.id.passport_large_sex);

            counterView = (ImageView) findViewById(R.id.counter_view);


            check.setOnTouchListener(new MyTouchListener());
            id.setOnTouchListener(new MyTouchListener());
            depositSlip.setOnTouchListener(new MyTouchListener());
            passport.setOnTouchListener(new MyTouchListener());
            checkLarge.setOnTouchListener(new MyTouchListener());
            idLarge.setOnTouchListener(new MyTouchListener());
            depositSlipLarge.setOnTouchListener(new MyTouchListener());
            passportLarge.setOnTouchListener(new MyTouchListener());


            passport_large_name.setOnClickListener(new TxtClickListener());
            passport_large_date_of_birth.setOnClickListener(new TxtClickListener());
            passport_large_expires_date.setOnClickListener(new TxtClickListener());
            passport_large_signature.setOnClickListener(new TxtClickListener());
            passport_large_image.setOnClickListener(new TxtClickListener());
            passport_large_address.setOnClickListener(new TxtClickListener());
            passport_large_sex.setOnClickListener(new TxtClickListener());

            passport_large_name.setTag(1);
            passport_large_date_of_birth.setTag(1);
            passport_large_expires_date.setTag(1);
            passport_large_signature.setTag(1);
            passport_large_image.setTag(1);
            passport_large_address.setTag(1);
            passport_large_sex.setTag(1);

            id_large_name.setOnClickListener(new TxtClickListener());
            id_large_date_of_birth.setOnClickListener(new TxtClickListener());
            id_large_address.setOnClickListener(new TxtClickListener());
            id_large_sex.setOnClickListener(new TxtClickListener());
            id_large_height.setOnClickListener(new TxtClickListener());
            id_large_issued.setOnClickListener(new TxtClickListener());
            id_large_expires.setOnClickListener(new TxtClickListener());
            id_large_signature.setOnClickListener(new TxtClickListener());
            id_large_photograph.setOnClickListener(new TxtClickListener());

            id_large_name.setTag(1);
            id_large_date_of_birth.setTag(1);
            id_large_address.setTag(1);
            id_large_sex.setTag(1);
            id_large_height.setTag(1);
            id_large_issued.setTag(1);
            id_large_expires.setTag(1);
            id_large_signature.setTag(1);
            id_large_photograph.setTag(1);


            check_large_pay_to_the_order_of.setOnClickListener(new TxtClickListener());
            check_large_total_number.setOnClickListener(new TxtClickListener());
            check_large_total_written.setOnClickListener(new TxtClickListener());
            check_large_for.setOnClickListener(new TxtClickListener());
            check_large_signature.setOnClickListener(new TxtClickListener());
            check_large_routing_number.setOnClickListener(new TxtClickListener());
            check_large_acount_number.setOnClickListener(new TxtClickListener());
            check_large_date.setOnClickListener(new TxtClickListener());

            check_large_pay_to_the_order_of.setTag(1);
            check_large_total_number.setTag(1);
            check_large_total_written.setTag(1);
            check_large_for.setTag(1);
            check_large_signature.setTag(1);
            check_large_routing_number.setTag(1);
            check_large_acount_number.setTag(1);
            check_large_date.setTag(1);

            game();

    }

    private void clearPassport() {
        passport_large_name.setBackgroundColor(Color.TRANSPARENT);
        passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
        passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
        passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
        passport_large_image.setBackgroundColor(Color.TRANSPARENT);
        passport_large_address.setBackgroundColor(Color.TRANSPARENT);
        passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
        passport_large_address.setTag(1);
        passport_large_sex.setTag(1);
        passport_large_name.setTag(1);
        passport_large_date_of_birth.setTag(1);
        passport_large_expires_date.setTag(1);
        passport_large_signature.setTag(1);
        passport_large_image.setTag(1);
    }

    private void clearCheck() {
        findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
        check_large_pay_to_the_order_of.setTag(1);
        check_large_total_number.setTag(1);
        check_large_total_written.setTag(1);
        check_large_for.setTag(1);
        check_large_signature.setTag(1);
        check_large_routing_number.setTag(1);
        check_large_acount_number.setTag(1);
        check_large_date.setTag(1);
    }

    private void clearID() {
        id_large_name.setBackgroundColor(Color.TRANSPARENT);
        id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
        id_large_address.setBackgroundColor(Color.TRANSPARENT);
        id_large_sex.setBackgroundColor(Color.TRANSPARENT);
        id_large_height.setBackgroundColor(Color.TRANSPARENT);
        id_large_issued.setBackgroundColor(Color.TRANSPARENT);
        id_large_expires.setBackgroundColor(Color.TRANSPARENT);
        id_large_signature.setBackgroundColor(Color.TRANSPARENT);
        id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
        id_large_name.setTag(1);
        id_large_date_of_birth.setTag(1);
        id_large_address.setTag(1);
        id_large_sex.setTag(1);
        id_large_height.setTag(1);
        id_large_issued.setTag(1);
        id_large_expires.setTag(1);
        id_large_signature.setTag(1);
        id_large_photograph.setTag(1);
    }

    public void game() {
        createNewPerson();
    }

    public void approveButton(View view){
        if (person.boolError()){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this,"Next Person",Toast.LENGTH_SHORT).show();
        game();
    }

    public void declineButton(View view){
        if (!person.boolError()){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this,"Next Person",Toast.LENGTH_SHORT).show();
        game();
    }

    public void createNewPerson() {
        ImageView temp = new ImageView(this);
        person = new Person(this.getResources(), temp);
        person.error();

        //Check  HAS TO DO FOR AND DATE
        check_large_pay_to_the_order_of.setText("" + person.check.getName()[0]);
        check_large_acount_number.setText("" + person.check.accountNumber[0]);
        check_large_routing_number.setText("" + person.check.routingNumber[0]);
        check_large_signature.setText("" + person.check.getName()[0]);
        check_large_total_written.setText("" + person.check.getWrittenTotal()[0]);
        check_large_total_number.setText("" + person.check.getAmountTotal()[0]);

        check_small_pay_to_the_order_of.setText("" + person.check.getName()[0]);
        check_small_account_number.setText("" + person.check.accountNumber[0]);
        check_small_routing_number.setText("" + person.check.routingNumber[0]);
        check_small_signature.setText("" + person.check.getName()[0]);
        check_small_total_written.setText("" + person.check.getWrittenTotal()[0]);
        check_small_total_numbers.setText("" + person.check.getAmountTotal()[0]);

        //ID
        id_large_address.setText("" + person.id.getAddress()[0]);
        id_large_date_of_birth.setText("" + person.id.getBirthDate()[0]);
        id_large_expires.setText("" + person.id.getExpirationDate()[0]);
        id_large_name.setText("" + person.id.getName()[0]);
        id_large_signature.setText("" + person.id.getName()[0]);
        id_large_sex.setText(""+person.id.getSex()[0]);
        id_large_height.setText(""+person.id.getHeight()[0]);
        id_large_photograph.setForeground(person.getPhoto().getForeground());

        id_small_address.setText("" + person.id.getAddress()[0]);
        id_small_date_of_birth.setText("" + person.id.getBirthDate()[0]);
        id_small_expires.setText("" + person.id.getExpirationDate()[0]);
        id_small_name.setText("" + person.id.getName()[0]);
        id_small_signature.setText("" + person.id.getName()[0]);
        id_small_sex.setText(""+person.id.getSex()[0]);
        id_small_height.setText(""+person.id.getHeight()[0]);
        id_small_photograph.setForeground(person.getPhoto().getForeground());

        //Passport
        passport_large_date_of_birth.setText("" + person.passport.getBirthDate()[0]);
        passport_large_expires_date.setText("" + person.passport.getExpirationDate()[0]);
        passport_large_name.setText("" + person.passport.getName()[0]);
        passport_large_signature.setText("" + person.id.getName()[0]);
        passport_large_address.setText("" + person.passport.getAddress()[0]);
        passport_large_sex.setText("" + person.passport.getSex()[0]);
        passport_large_image.setForeground(person.getPhoto().getForeground());

        passport_small_date_of_birth.setText("" + person.passport.getBirthDate()[0]);
        passport_small_expires_date.setText("" + person.passport.getExpirationDate()[0]);
        passport_small_name.setText("" + person.passport.getName()[0]);
        passport_small_signature.setText("" + person.id.getName()[0]);
        passport_small_address.setText("" + person.passport.getAddress()[0]);
        passport_small_sex.setText("" + person.passport.getSex()[0]);
        passport_small_image.setForeground(person.getPhoto().getForeground());

        counterView.setForeground(person.getPhoto().getForeground());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout background = (RelativeLayout) findViewById(R.id.gameplay_layout);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            background.setBackgroundResource(R.drawable.landscape_background);
            passport.setVisibility(View.VISIBLE);
            id.setVisibility(View.VISIBLE);
            check.setVisibility(View.VISIBLE);
            counterView.setVisibility(View.INVISIBLE);
            passport_small_image.setForeground(person.getPhoto().getDrawable());
            id_small_photograph.setForeground(person.getPhoto().getDrawable());
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            background.setBackgroundResource(R.drawable.vertical_background);
            passportLarge.setVisibility(View.INVISIBLE);
            passport.setVisibility(View.INVISIBLE);
            check.setVisibility(View.INVISIBLE);
            checkLarge.setVisibility(View.INVISIBLE);
            id.setVisibility(View.INVISIBLE);
            idLarge.setVisibility(View.INVISIBLE);
            counterView.setVisibility(View.VISIBLE);
        }
    }

    private final class TxtClickListener implements View.OnClickListener {
        public void onClick(final View view/*, MotionEvent event*/) {
            view.clearFocus();
            if ((int) view.getTag() == 1) {
                view.setBackgroundResource(R.drawable.red_border);
                view.setTag(2);
            } else if ((int) view.getTag() == 2) {
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setTag(1);
            }

            if (view == findViewById(R.id.passport_large_name)) {
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_address.setTag(1);
                passport_large_sex.setTag(1);
                passport_large_image.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_date_of_birth)) {
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_image.setTag(1);
                passport_large_address.setTag(1);
                passport_large_sex.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_expires_date)) {
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_date_of_birth.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_image.setTag(1);
                passport_large_address.setTag(1);
                passport_large_sex.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_signature)) {
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_date_of_birth.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_image.setTag(1);
                passport_large_address.setTag(1);
                passport_large_sex.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_image)) {
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_date_of_birth.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_address.setTag(1);
                passport_large_sex.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_sex)) {
                passport_large_address.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_date_of_birth.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_address.setTag(1);
                passport_large_image.setTag(1);
            }
            if (view == findViewById(R.id.passport_large_address)) {
                passport_large_sex.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setBackgroundColor(Color.TRANSPARENT);
                passport_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                passport_large_expires_date.setBackgroundColor(Color.TRANSPARENT);
                passport_large_signature.setBackgroundColor(Color.TRANSPARENT);
                passport_large_image.setBackgroundColor(Color.TRANSPARENT);
                passport_large_name.setTag(1);
                passport_large_date_of_birth.setTag(1);
                passport_large_expires_date.setTag(1);
                passport_large_signature.setTag(1);
                passport_large_sex.setTag(1);
                passport_large_image.setTag(1);
            }

            if (view == findViewById(R.id.id_large_name)) {
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_date_of_birth)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_address)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_sex)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_height)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_issued)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_expires)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_signature.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_signature)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_photograph.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_photograph.setTag(1);
            }
            if (view == findViewById(R.id.id_large_photograph)) {
                id_large_name.setBackgroundColor(Color.TRANSPARENT);
                id_large_date_of_birth.setBackgroundColor(Color.TRANSPARENT);
                id_large_address.setBackgroundColor(Color.TRANSPARENT);
                id_large_sex.setBackgroundColor(Color.TRANSPARENT);
                id_large_height.setBackgroundColor(Color.TRANSPARENT);
                id_large_issued.setBackgroundColor(Color.TRANSPARENT);
                id_large_expires.setBackgroundColor(Color.TRANSPARENT);
                id_large_signature.setBackgroundColor(Color.TRANSPARENT);
                id_large_name.setTag(1);
                id_large_date_of_birth.setTag(1);
                id_large_address.setTag(1);
                id_large_sex.setTag(1);
                id_large_height.setTag(1);
                id_large_issued.setTag(1);
                id_large_expires.setTag(1);
                id_large_signature.setTag(1);
            }


            if (view == findViewById(R.id.check_large_pay_to_the_order_of)) {
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_total_number)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_total_written)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_for)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_signature)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_routing_number)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_acount_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_acount_number)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_date).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_date.setTag(1);
            }
            if (view == findViewById(R.id.check_large_date)) {
                findViewById(R.id.check_large_pay_to_the_order_of).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_total_written).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_for).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_signature).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_routing_number).setBackgroundColor(Color.TRANSPARENT);
                findViewById(R.id.check_large_acount_number).setBackgroundColor(Color.TRANSPARENT);
                check_large_pay_to_the_order_of.setTag(1);
                check_large_total_number.setTag(1);
                check_large_total_written.setTag(1);
                check_large_for.setTag(1);
                check_large_signature.setTag(1);
                check_large_routing_number.setTag(1);
                check_large_acount_number.setTag(1);
            }


            int tagCount = 0;
            if ((int) check_large_pay_to_the_order_of.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_total_number.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_total_written.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_for.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_signature.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_routing_number.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_acount_number.getTag() == 2) {
                tagCount++;
            }
            if ((int) check_large_date.getTag() == 2) {
                tagCount++;
            }


            if ((int) id_large_name.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_date_of_birth.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_address.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_sex.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_height.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_issued.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_expires.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_signature.getTag() == 2) {
                tagCount++;
            }
            if ((int) id_large_photograph.getTag() == 2) {
                tagCount++;
            }

            if ((int) passport_large_date_of_birth.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_expires_date.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_image.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_name.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_signature.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_address.getTag() == 2) {
                tagCount++;
            }
            if ((int) passport_large_sex.getTag() == 2) {
                tagCount++;
            }


            if (tagCount > 2) {
                clearCheck();
                clearID();
                clearPassport();
            } else if (tagCount == 2) {

                ArrayList<String[]> s = new ArrayList<String[]>();

                if ((int) passport_large_date_of_birth.getTag() == 2) {
                    s.add(person.passport.getBirthDate());
                }
                if ((int) passport_large_expires_date.getTag() == 2) {
                    s.add(person.passport.getExpirationDate());
                }
                if ((int) passport_large_image.getTag() == 2) {
                    s.add(new String[] {"Who needs a girlfriend when u have this sexy code","8"});
                }
                if ((int) passport_large_name.getTag() == 2) {
                    s.add(person.passport.getName());
                }
                if ((int) passport_large_signature.getTag() == 2) {
                    s.add(person.passport.getName());
                }
                if ((int) passport_large_address.getTag() == 2) {
                    s.add(person.passport.getAddress());
                }
                if ((int) passport_large_sex.getTag() == 2) {
                    s.add(person.passport.getSex());
                }


                if ((int) check_large_pay_to_the_order_of.getTag() == 2) {
                    s.add(person.check.getName());
                }
                if ((int) check_large_total_number.getTag() == 2) {
                    s.add(person.check.getAmountTotal());
                }
                if ((int) check_large_total_written.getTag() == 2) {
                    s.add(person.check.getWrittenTotal());
                }
                if ((int) check_large_for.getTag() == 2) {

                }
                if ((int) check_large_signature.getTag() == 2) {
                    s.add(person.check.getName());
                }
                if ((int) check_large_routing_number.getTag() == 2) {
                    s.add(person.check.getRoutingNumber());
                }
                if ((int) check_large_acount_number.getTag() == 2) {
                    s.add(person.check.getAccountNumber());
                }
                if ((int) check_large_date.getTag() == 2) {
                    s.add(new String[] {"Do I smell like farts?","7"});
                }


                if ((int) id_large_name.getTag() == 2) {
                    s.add(person.id.getName());
                }
                if ((int) id_large_date_of_birth.getTag() == 2) {
                    s.add(person.id.getBirthDate());
                }
                if ((int) id_large_address.getTag() == 2) {
                    s.add(person.id.getAddress());
                }
                if ((int) id_large_sex.getTag() == 2) {
                     s.add(person.id.getSex());
                }
                if ((int) id_large_height.getTag() == 2) {
                    s.add(person.id.getHeight());
                }
                if ((int) id_large_expires.getTag() == 2) {
                    s.add(person.id.getExpirationDate());
                }
                if ((int) id_large_signature.getTag() == 2) {
                    s.add(person.id.getName());
                }
                if ((int) id_large_photograph.getTag() == 2) {
                    s.add(new String[] {"Who needs a girlfriend when u have this sexy code","8"});
                }

                checkDiscrepancies(s);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clearCheck();
                        clearID();
                        clearPassport();
                    }
                }, 1000);
            }
        }
    }

    public void checkDiscrepancies(ArrayList<String[]> s) {
        /*Toast.makeText(Gameplay.this, s.get(0)[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(Gameplay.this, s.get(0)[1], Toast.LENGTH_SHORT).show();
        Toast.makeText(Gameplay.this, s.get(1)[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(Gameplay.this, s.get(1)[1], Toast.LENGTH_SHORT).show();*/


        if (!s.get(0)[0].equals(s.get(1)[0]) && !s.get(0)[1].equals(s.get(1)[1])) {
            Toast.makeText(Gameplay.this, "No Correlation", Toast.LENGTH_SHORT).show();
        } else if (!s.get(0)[0].equals(s.get(1)[0]) && s.get(0)[1].equals(s.get(1)[1])) {
            Toast.makeText(Gameplay.this, "Discrepancies Detected", Toast.LENGTH_SHORT).show();
        } else if (s.get(0)[1].equals(s.get(1)[1]) && s.get(0)[0].equals(s.get(1)[0])) {
            Toast.makeText(Gameplay.this, "No Discrepancies", Toast.LENGTH_SHORT).show();
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(final View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    timesTouched++;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (timesTouched == 2) {
                                if (view == findViewById(R.id.check_small_layout)) {
                                    //checkLarge.setLayoutParams(view.getLayoutParams());
                                    checkLarge.setVisibility(View.VISIBLE);
                                }
                                if (view == findViewById(R.id.check_large_layout)) {
                                    //check.setLayoutParams(view.getLayoutParams());
                                    check.setVisibility(View.VISIBLE);
                                    clearCheck();

                                }
                                if (view == findViewById(R.id.id_small_layout)) {
                                    //idLarge.setLayoutParams(view.getLayoutParams());
                                    idLarge.setVisibility(View.VISIBLE);

                                }
                                if (view == findViewById(R.id.id_large_layout)) {
                                    //id.setLayoutParams(view.getLayoutParams());
                                    id.setVisibility(View.VISIBLE);
                                    clearID();
                                }
                                if (view == findViewById(R.id.passport_large)) {
                                    passport.setVisibility(View.VISIBLE);
                                    clearPassport();
                                }
                                if (view == findViewById(R.id.passport_small)) {
                                    passportLarge.setVisibility(View.VISIBLE);
                                }
                                view.setVisibility(View.INVISIBLE);
                            }
                            timesTouched = 0;
                        }
                    }, 250);


                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -5000;
                    layoutParams.bottomMargin = -5000;
                    view.setLayoutParams(layoutParams);
                    //checkLarge.setX(view.getX());
                    //checkLarge.setY(view.getY());
                    break;
            }
            main.invalidate();
            return true;
        }

    }
}
