package com.example.adminmedi_capsuniversity.faculty;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.adminmedi_capsuniversity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fabs;
    private RecyclerView csDepartment,MechenicalDepartment,PhysicasDepartment,chemistryDepartment;
    private LinearLayout csNOData,mechNOData,PhysicasNOData,chemistryNOData;
    private List<TeacherData> list1,list2,list3,list4;
    private TeacherAdapter adapter;
    private DatabaseReference reference,dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        chemistryDepartment= findViewById(R.id.chemistryDepartment);
        PhysicasDepartment=findViewById(R.id.PhysicasDepartment);
        csDepartment= findViewById(R.id.csDepartment);
        MechenicalDepartment=findViewById(R.id.MechenicalDepartment);

        csNOData= findViewById(R.id.csNOData);
        mechNOData= findViewById(R.id.mechNOData);
        PhysicasNOData= findViewById(R.id.PhysicasNOData);
        chemistryNOData= findViewById(R.id.chemistryNOData);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        MechenicalDepartment();
        PhysicasDepartment();
        chemistryDepartment();




        fabs =findViewById(R.id.fabs);

        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this,AddTeachers.class));
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
             list1= new ArrayList<>();
             if(!datasnapshot.exists()){
                 csNOData.setVisibility(View.VISIBLE);
                 csDepartment.setVisibility(View.GONE);

             }else {
                 csNOData.setVisibility(View.GONE);
                 csDepartment.setVisibility(View.VISIBLE);
                 for(DataSnapshot snapshot:datasnapshot.getChildren()){
                     TeacherData data = snapshot.getValue(TeacherData.class);
                     list1.add(data);

                 }
                 csDepartment.setHasFixedSize(true);
                 csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                 adapter= new TeacherAdapter(list1,UpdateFaculty.this);
                 csDepartment.setAdapter(adapter);


             }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseerror) {
                Toast.makeText(UpdateFaculty.this,databaseerror.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void PhysicasDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list3= new ArrayList<>();
                if(!datasnapshot.exists()){
                    PhysicasNOData.setVisibility(View.VISIBLE);
                    PhysicasDepartment.setVisibility(View.GONE);

                }else {
                    PhysicasNOData.setVisibility(View.GONE);
                    PhysicasDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);

                    }
                    PhysicasDepartment.setHasFixedSize(true);
                    PhysicasDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list3,UpdateFaculty.this);
                    PhysicasDepartment.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseerror) {
                Toast.makeText(UpdateFaculty.this,databaseerror.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void MechenicalDepartment() {
        dbRef = reference.child("Mechenical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list2= new ArrayList<>();
                if(!datasnapshot.exists()){
                    mechNOData.setVisibility(View.VISIBLE);
                    MechenicalDepartment.setVisibility(View.GONE);

                }else {
                    mechNOData.setVisibility(View.GONE);
                    MechenicalDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);

                    }
                    MechenicalDepartment.setHasFixedSize(true);
                    MechenicalDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list2,UpdateFaculty.this);
                    MechenicalDepartment.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseerror) {
                Toast.makeText(UpdateFaculty.this,databaseerror.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list4= new ArrayList<>();
                if(!datasnapshot.exists()){
                    chemistryNOData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);

                }else {
                    chemistryNOData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);

                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list4,UpdateFaculty.this);
                    chemistryDepartment.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseerror) {
                Toast.makeText(UpdateFaculty.this,databaseerror.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}