package com.example.transactiontrial;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.provider.Telephony;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentDebit extends Fragment {

    ListView listView;
    ArrayList<String> smslist;
    String recieved_sms_uri = "content://sms/inbox";
    String sent_sms_uri = "content://sms/sent";
    ContentResolver contentResolver;
    Cursor cursor;
    String type;
    float TotalDebit=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit, container, false);

        listView = view.findViewById(R.id.listview);
        smslist = new ArrayList<String>();
        contentResolver = getActivity().getContentResolver();
        cursor = contentResolver.query(Telephony.Sms.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {

            String smsDate = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.DATE));
            String number = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.ADDRESS));
            String body = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.BODY));
            Date dateFormat = new Date(Long.parseLong(smsDate));

            switch (Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.TYPE)))) {
                case Telephony.Sms.MESSAGE_TYPE_INBOX:
                    type = "inbox";
                    break;
                case Telephony.Sms.MESSAGE_TYPE_SENT:
                    type = "sent";
                    break;
                case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                    type = "outbox";
                    break;
                default:
                    break;
            }
            if  ((body.contains("Debited") || body.contains("debited") || body.contains("INR")) && (body.contains("Rs.")) &&  (!body.contains("failed")) ) {
                if (number.matches("[a-zA-Z0-9]{2}-[a-zA-Z0-9]{6}")) {
                     //getting only bank sms
                    Pattern regEx
                            = Pattern.compile(" (?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)");
                    // getting amount from sms
                    // Find instance of pattern matches
                    Matcher m = regEx.matcher(body);
                    if (m.find()) {
                        try {  smslist.add(number + "\n \n" + body + "\n" + dateFormat +"\n");
                            Log.e("amount_value= ", "" + m.group(0));
                            String amount = (m.group(0).replaceAll("inr", ""));
                            amount = amount.replaceAll("rs", "");
                            amount = amount.replaceAll("inr", "");
                            amount = amount.replaceAll(" ", "");
                            amount = amount.replaceAll(",", "");
                            amount = amount.replaceAll("Rs.", "");
                            amount = amount.replaceAll("INR", "");
                            amount = amount.replaceAll("RS", "");

                            float debited= Float.parseFloat(amount);
                            TotalDebit=TotalDebit+debited;
                            Log.i("Transactional messages", "Credit    " + debited  + "   date  " +dateFormat +"  type  " +type );
                        }catch (Exception e)
                        {
                            e.printStackTrace();}
                    }
                }
            }
        }
        cursor.close();
        Toast.makeText(getContext(), "Total Debit : Rs."+TotalDebit, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getActivity(),MainActivity2.class);
        intent.putExtra("TotalDebit",TotalDebit);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, smslist);
        listView.setDividerHeight(10);
        listView.setAdapter(arrayAdapter);

        return view;
    }
}