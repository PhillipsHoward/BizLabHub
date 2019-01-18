package fr.wildcodeschool.hackbus;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.TypeModel;
import fr.wildcodeschool.hackbus.models.UserModel;

import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class SingletonData {


    public static final String UID_PERSO = "-LWSHtu9_W5Tg74p8wsU";

    public static final SingletonData ourInstance = new SingletonData();
    private ArrayList<ProjetModel> projects = new ArrayList<>();
    private ArrayList<TagsModel> tags = new ArrayList<>();
    private ArrayList<UserModel> users = new ArrayList<>();
    private ArrayList<TypeModel> types = new ArrayList<>();
    private UserModel cUser = new UserModel();

    public static String getUidPerso() {
        return UID_PERSO;
    }

    public UserModel getcUser() {
        return cUser;
    }

    public void setcUser(UserModel cUser) {
        this.cUser = cUser;
    }

    public void initDatas(final SingletonDataListener mySingletonDataListener){
        initTypesListe();
        initTagsList(mySingletonDataListener);
    }

    public void initTypesListe(){
        TreeSet<TypeModel> typesTemp = new TreeSet<>();
        typesTemp.add(new TypeModel("Informatique"));
        typesTemp.add(new TypeModel("Développement"));
        typesTemp.add(new TypeModel("Physique Théorique"));
        typesTemp.add(new TypeModel("Physique Appliquée"));
        typesTemp.add(new TypeModel("Mathématiques"));
        typesTemp.add(new TypeModel("Relations Humaines"));
        typesTemp.add(new TypeModel("Communication"));
        typesTemp.add(new TypeModel("Sociologie"));
        typesTemp.add(new TypeModel("Biologie"));
        typesTemp.add(new TypeModel("Chimie"));
        typesTemp.add(new TypeModel("Mécanique"));
        typesTemp.add(new TypeModel("Electronique Analogique"));
        typesTemp.add(new TypeModel("Artisanat"));
        typesTemp.add(new TypeModel("Ecriture"));
        typesTemp.add(new TypeModel("Investigation"));
        typesTemp.add(new TypeModel("Journalisme"));
        typesTemp.add(new TypeModel("Négociation"));
        typesTemp.add(new TypeModel("Finance"));
        typesTemp.add(new TypeModel("Comptabilité"));
        typesTemp.add(new TypeModel("Architecture réseau"));
        typesTemp.add(new TypeModel("Economie"));
        typesTemp.add(new TypeModel("Modélisation 3D"));
        typesTemp.add(new TypeModel("Design"));
        typesTemp.add(new TypeModel("Mécatronique"));
        typesTemp.add(new TypeModel("Electronique numérique"));
        typesTemp.add(new TypeModel("UX/UI"));
        typesTemp.add(new TypeModel("Chasse & pêche"));
        typesTemp.add(new TypeModel("Nature et Tradition"));
        typesTemp.add(new TypeModel("Religion"));
        typesTemp.add(new TypeModel("Developpement Mobile"));
        typesTemp.add(new TypeModel("Ta maman"));
        typesTemp.add(new TypeModel("Mécanique des fluides"));
        typesTemp.add(new TypeModel("DSP et microcontroleurs"));
        typesTemp.add(new TypeModel("Algorithmie"));
        typesTemp.add(new TypeModel("Mécanique quantique"));
        types = new ArrayList<>(typesTemp);
    }

    public void initTagsList(final SingletonDataListener mysingletonDataListener){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refTags = firebaseDatabase.getReference("tags");
        refTags.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tags.clear();
                TagsModel tag = new TagsModel();
                for (DataSnapshot tagsSnapshot : dataSnapshot.getChildren()){
                    tag = tagsSnapshot.getValue(TagsModel.class);
                    tags.add(tag);
                }
                initProjectsList(mysingletonDataListener);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void initProjectsList(final SingletonDataListener mySingletonDataListener){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refProjets = firebaseDatabase.getReference("projets");
        refProjets.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                projects.clear();
                ProjetModel projet = new ProjetModel();
                for (DataSnapshot projetSnapshot : dataSnapshot.getChildren()) {
                    projet = projetSnapshot.getValue(ProjetModel.class);

                    if (projet.getQuestions() == null) {
                        projet.setQuestions(new ArrayList<QuestionModel>());
                    }

                    if (projet.getTeam() == null) {
                        projet.setTeam(new ArrayList<UserModel>());
                    }

                    if (projet.getCompetence() == null) {
                        projet.setCompetence(new ArrayList<TagsModel>());
                    }


                    projects.add(projet);
                }
                initUserLists(mySingletonDataListener);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void initUserLists(final SingletonDataListener myDataListener){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refUsers = firebaseDatabase.getReference("users");
        refUsers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                UserModel user = new UserModel();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    user = userSnapshot.getValue(UserModel.class);

                    if(user.getCompetence() == null) {
                        user.setCompetence(new ArrayList<CompetenceModel>());
                    }

                    if(user.getProjetEnCours() == null) {
                        user.setProjetEnCours(new ArrayList<ProjetModel>());
                    }

                    if(user.getProjetInitie() == null) {
                        user.setProjetInitie(new ArrayList<ProjetModel>());
                    }

                    if(user.getQuestionAsked() == null) {
                        user.setQuestionAsked(new ArrayList<QuestionModel>());
                    }

                    if(user.getQuestionNeedAnswer() == null) {
                        user.setQuestionNeedAnswer(new ArrayList<QuestionModel>());
                    }
                    users.add(user);
                }
                myDataListener.onResponse(true);

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
        projects.add(projet);
        refProjets.child(key).setValue(projet);
    }

    public void addTags(TagsModel tag){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refTags = firebaseDatabase.getReference("tags");
        String key = refTags.push().getKey();
        tag.setuId(key);
        tags.add(tag);
        refTags.child(key).setValue(tag);
    }

    public void addUsers(UserModel user){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refProjets = firebaseDatabase.getReference("users");
        String key = refProjets.push().getKey();
        user.setuId(key);
        users.add(user);
        refProjets.child(key).setValue(user);
    }

    public ArrayList<ProjetModel> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<ProjetModel> projects) {
        this.projects = projects;
    }

    public ArrayList<TagsModel> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagsModel> tags) {
        this.tags = tags;
    }

    public ArrayList<UserModel> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
    }

    public ArrayList<TypeModel> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<TypeModel> types) {
        this.types = types;
    }

    public static SingletonData getInstance() {
        return ourInstance;
    }

    private SingletonData() {
    }

    public void updateUser(UserModel user){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refUser = firebaseDatabase.getReference("users").child(user.getuId());
        refUser.setValue(user);
    }

    public void updateProjet(ProjetModel projetModel){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference refUser = firebaseDatabase.getReference("projets").child(projetModel.getId());
        refUser.setValue(projetModel);
    }

    public void initListenerQuestionReponse(){}

    public void initListenerPresence(final PresenceListener presenceListenerInterface) {

        ChildEventListener presenceListener = new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dataSnapshot.getKey();
                for(UserModel userModel : SingletonData.getInstance().getUsers()){

                    if(userModel.getuId().equals(dataSnapshot.getKey())){
                        if((boolean) dataSnapshot.child("dispo").getValue() && !userModel.isDispo()) {
                            userModel.setDispo((boolean) dataSnapshot.child("dispo").getValue());
                            presenceListenerInterface.onChange(userModel);
                        }
                    }
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
            databaseReference.addChildEventListener(presenceListener);
    }

    public void askAQuestion(QuestionModel question, ProjetModel projetModel, UserModel sender, ArrayList<UserModel> answerer){
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String projetID = projetModel.getId();
        String senderId = sender.getuId();
        question.setSenderId(senderId);

        for(UserModel user : answerer){
            if(question.getAnswererId() == null) question.setAnswererId(new ArrayList<String>());
            question.getAnswererId().add(user.getuId());
        }

        DatabaseReference projetRef = firebaseDatabase.getReference("projets").child(projetID);
        String key = projetRef.push().getKey();
        question.setId(key);
        projetRef.child(key).setValue(question);

        projetModel.getQuestions().add(question);
        updateProjet(projetModel);

        sender.getQuestionNeedAnswer().add(question);
        DatabaseReference senderRef = firebaseDatabase.getReference("users");
        updateUser(sender);

        for(UserModel user : answerer){
            user.getQuestionAsked().add(question);
            updateUser(user);
        }


    }

    public UserModel findUserById(String uId){
        for (UserModel userModel : users){
            if(userModel.getuId().equals(uId)) return userModel;
        }
        return new UserModel();
    }

    public void getANewQuestionListener(final QuestionReponseListener questionReponseListener, UserModel user){
        user = cUser;
        final UserModel finalUser = user;
        ChildEventListener getAquestionListener = new ChildEventListener() {


            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                QuestionModel question = dataSnapshot.getValue(QuestionModel.class);
                questionReponseListener.onChange(question);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                boolean test = true;
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

    };
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(finalUser.getuId()).child("questionAsked");
        databaseReference.addChildEventListener(getAquestionListener);

}
}
