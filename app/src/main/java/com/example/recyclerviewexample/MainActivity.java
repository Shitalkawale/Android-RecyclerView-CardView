package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Name> name;
    Button b1;
    EditText edname,edemail,edphone;
    Name nm;
    NameAdapter nameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerview);
        b1=findViewById(R.id.btnadd);
        edname=findViewById(R.id.name);
        edemail=findViewById(R.id.email);
        edphone=findViewById(R.id.phone);

        name=new ArrayList<>();
        nameAdapter=new NameAdapter(this,name);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        b1.setOnClickListener(new AddName());
        rv.setAdapter(nameAdapter);
    }
    class AddName implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            nm =new Name();
            String edName=edname.getText().toString();
            String edEmail=edemail.getText().toString();
            String edPhone=edphone.getText().toString();
            nm.setName(edName);
            nm.setEmail(edEmail);
            nm.setPhone(edPhone);
            name.add(nm);
            nameAdapter.notifyDataSetChanged();
        }
    }
}