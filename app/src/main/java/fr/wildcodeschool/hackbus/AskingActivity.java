package fr.wildcodeschool.hackbus;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.TypeModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class AskingActivity extends SuperActivity {

    SingletonData singletonData = SingletonData.getInstance();
    Context mContext;
    boolean isFisrt = true;
    private int mSeekBarProgress = 0;
    private Singleton mSingleton;
    private SearchableSpinner mSearchableSpinner = null;
    private String typeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        mSingleton = Singleton.getInstance();

        spinnerTag();

        seekBar();

        //sendButton();

        infoButton();
    }

    private void infoButton() {
        ImageButton info = findViewById(R.id.ib_info);
        final View greyView = findViewById(R.id.view_grey);
        final TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoPopup();
            }
        });

        greyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeInfoPopup();
            }
        });

        priorityMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeInfoPopup();

            }
        });
    }

    private void closeInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView priorityPopup = findViewById(R.id.tv_priority_popup);
        TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        greyView.setVisibility(View.GONE);
        priorityPopup.setVisibility(View.GONE);
        priorityMeaning.setVisibility(View.GONE);
    }

    private void showInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView priorityPopup = findViewById(R.id.tv_priority_popup);
        TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        greyView.setVisibility(View.VISIBLE);
        priorityPopup.setVisibility(View.VISIBLE);
        priorityMeaning.setVisibility(View.VISIBLE);
    }

    private void sendButton() {
        Button send = findViewById(R.id.send);
        final EditText title = findViewById(R.id.et_title_question);
        final EditText question = findViewById(R.id.et_question);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString();
                String questionText = question.getText().toString();

                if (titleText.isEmpty() || questionText.isEmpty()) {
                    Toast.makeText(AskingActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    QuestionModel newQuestion = new QuestionModel(mSingleton.getUser(), titleText, questionText, mSeekBarProgress);
                    //TODO: model question tout prêt à balancer quelque part
                }
            }
        });
    }

    //TODO IMPLEMENTER UNE LISTE TAG DE FIREBAAAASE ! (pour l'instant petite liste des compétences a la place pour tester le spinner)
    public void spinnerTag() {
        mSearchableSpinner = findViewById(R.id.sp_tag);

        final ArrayList<TypeModel> typeModelSingleton = singletonData.getTypes();
        final ArrayList<String> typeDeProjets = new ArrayList<>();
        for (TypeModel typeModel : typeModelSingleton) {
            typeModels = typeModel.getNom();
            typeDeProjets.add(typeModels);
        }

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeDeProjets);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_type));
        mSearchableSpinner.setTitle(getString(R.string.choix_type));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        //TODO récuperer cette liste de tag (typeDeProjetAdapter) pour transferé les info de la question
        final ArrayList<TypeModel> typeDeProjetAdapter = new ArrayList<>();
        final AskingGringAdapter adapterTag = new AskingGringAdapter(mContext, typeDeProjetAdapter);
        RecyclerView TagRecyclerView = findViewById(R.id.TagRecyclerView);
        TagRecyclerView.setLayoutManager(new GridLayoutManager(AskingActivity.this, 3));
        TagRecyclerView.setAdapter(adapterTag);

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (!isFisrt) {
                    TypeModel typeProjet = typeModelSingleton.get(position);
                    boolean isSelected = false;
                    for (TypeModel typeModel: typeDeProjetAdapter) {
                        if(typeModel.getNom().equals(typeProjet.getNom())){
                            Toast.makeText(getApplicationContext(), "Vous ne pouvez pas avoir deux tags similaire", Toast.LENGTH_SHORT).show();
                            isSelected = true;
                            break;
                        }
                    }
                    if(!isSelected){
                        typeDeProjetAdapter.add(typeProjet);
                        adapterTag.notifyDataSetChanged();
                    }
                }
                isFisrt = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void seekBar() {
        SeekBar sbPriority = findViewById(R.id.sb_priority);
        final TextView tvCount = findViewById(R.id.tv_count);
        final ImageView progressColor = findViewById(R.id.iv_color_progress);

        sbPriority.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSeekBarProgress = progress;
                tvCount.setText(mSeekBarProgress + " / " + seekBar.getMax());
                if (mSeekBarProgress == 0) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_grey);
                } else if (mSeekBarProgress == 1) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_blue);
                } else if (mSeekBarProgress == 2) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_green);
                } else if (mSeekBarProgress == 3) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_yellow);
                } else if (mSeekBarProgress == 4) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_orange);
                } else if (mSeekBarProgress == 5) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_red);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    private ArrayList<UserModel> selectPotentialsRecipients(ArrayList<UserModel> users, ArrayList<TagsModel> tags, ProjetModel currentProject) {

        ArrayList<UserModel> recipients = new ArrayList<>(users);

        for (UserModel user : recipients) {

            if (!user.isDispo()) {
                recipients.remove(user);
                break;
            }

            boolean isPresentInProject = false;

            for (ProjetModel project : user.getProjetEnCours()) {

                if (project.getId() == currentProject.getId()) {
                    isPresentInProject = true;
                    break;
                }
            }

            if (!isPresentInProject) {
                recipients.remove(user);
                break;
            }

            for (TagsModel tag : tags) {
                boolean hasTheGoodTag = false;
                for (CompetenceModel competence : user.getCompetence()) {
                    if (competence.getTag().getuId() == tag.getuId()) {
                        hasTheGoodTag = true;
                        break;
                    }
                }
                if (!hasTheGoodTag) {
                    recipients.remove(user);
                }
            }
        }
        return recipients;
    }
}