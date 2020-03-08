package com.example.diet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClick {

    private static final int REQUEST_CODE =1001;

    String str;
    TextView tv1,tv2;
    ImageView recycler_imageview;
    ArrayList<Data> mArrayList;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.recycler_text1);
        tv2 = findViewById(R.id.recycler_text2);
        recyclerView = findViewById(R.id.recyclerview);
        button = findViewById(R.id.add_item_button);
        recycler_imageview = findViewById(R.id.recycler_image);



        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();


        adapter = new RecyclerAdapter(mArrayList);
        recyclerView.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data data = new Data("text1","text2",R.drawable.kotlinlogo);

                mArrayList.add(data);
                adapter.notifyDataSetChanged();


            }
        });
        adapter.setOnItemClickListener(this);






    }


    public void onImageClick(int position){
        Toast.makeText(MainActivity.this, String.format("ImageView:%d",position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_CODE);

    }


    public void onText1Click(int position) {
        Toast.makeText(MainActivity.this, String.format("Text1Click:%d",position), Toast.LENGTH_SHORT).show();
        show();

    }

    public void onText2Click(int position) {

        Toast.makeText(MainActivity.this, String.format("Text2Click:%d",position), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    recycler_imageview.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    void show(){
        final EditText edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog Title");
        builder.setMessage("AlertDialog Content");
        builder.setView(edittext);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),edittext.getText().toString() ,Toast.LENGTH_LONG).show();
                        str = edittext.getText().toString();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

}
