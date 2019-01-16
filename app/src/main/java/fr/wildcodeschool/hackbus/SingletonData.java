package fr.wildcodeschool.hackbus;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class SingletonData {
    private static final SingletonData ourInstance = new SingletonData();
    private ArrayList<ProjetModel> projects = new ArrayList<>();
    private ArrayList<TagsModel> tags = new ArrayList<>();
    private ArrayList<UserModel> users = new ArrayList<>();

    public void initTagsList(){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refTags = firebaseDatabase.getReference("tags");
        refTags.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tags.clear();
                TagsModel tag = new TagsModel();
                for (DataSnapshot tagsSnapshot : dataSnapshot.getChildren()){
                    tag = tagsSnapshot.getValue(TagsModel.class);
                    tags.add(tag);
                }
                initProjectsList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void initProjectsList(){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refProjets = firebaseDatabase.getReference("projets");
        refProjets.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                projects.clear();
                ProjetModel projet = new ProjetModel();
                for (DataSnapshot projetSnapshot : dataSnapshot.getChildren()) {
                    projet = projetSnapshot.getValue(ProjetModel.class);
                    projects.add(projet);
                }
                initUserLists();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void initUserLists(){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refUsers = firebaseDatabase.getReference("users");
        refUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                UserModel user = new UserModel();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    user = userSnapshot.getValue(UserModel.class);
                    users.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void addProjects(ProjetModel projet){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refProjets = firebaseDatabase.getReference("projets");
        String key = refProjets.push().getKey();
        projet.setId(key);
        refProjets.child(key).setValue(projet);
    }

    public void addTags(TagsModel tag){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refTags = firebaseDatabase.getReference("tags");
        String key = refTags.push().getKey();
        tag.setuId(key);
        refTags.child(key).setValue(tag);
    }

    public void addUsers(UserModel user){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refProjets = firebaseDatabase.getReference("users");
        String key = refProjets.push().getKey();
        user.setuId(key);
        refProjets.child(key).setValue(user);
    }


    public static SingletonData getInstance() {
        return ourInstance;
    }



    private SingletonData() {
    }
}
