package fr.wildcodeschool.hackbus;

import android.content.Intent;
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

import fr.wildcodeschool.hackbus.adapters.AskingGringAdapter;
import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.ReponseModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class AskingActivity extends SuperActivity {

    SingletonData singletonData = SingletonData.getInstance();
    Context mContext;
    boolean isFisrt = true;
    private int mSeekBarProgress = 0;
    private Singleton mSingleton;
    private SearchableSpinner mSearchableSpinner = null;
    private String typeModels;
    ArrayList<TagsModel> mTagsToQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        mSingleton = Singleton.getInstance();
        spinnerTag();
        seekBar();
        sendButton();
        infoButton();
    }

    private void infoButton() {
        ImageButton info = findViewById(R.id.ib_info);
        final View greyView = findViewById(R.id.view_grey);
        final TextView priorityMeaning = findViewById(R.id.tv_quicky);

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
        TextView priorityMeaning = findViewById(R.id.tv_quicky);

        greyView.setVisibility(View.GONE);
        priorityPopup.setVisibility(View.GONE);
        priorityMeaning.setVisibility(View.GONE);
    }

    private void showInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView priorityPopup = findViewById(R.id.tv_priority_popup);
        TextView priorityMeaning = findViewById(R.id.tv_quicky);

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
                    ProjetModel currentProject = singletonData.getProjects().get(0); //TODO A REMPLACER PAR LE VRAI CURRENT PROJECT
                    ArrayList<UserModel> usersReceptors = selectPotentialsRecipients(singletonData.getUsers(), mTagsToQuestion, currentProject);
                    QuestionModel newQuestion = new QuestionModel(titleText, questionText, mSeekBarProgress, mTagsToQuestion, true, new ArrayList<ReponseModel>());
                    singletonData.askAQuestion(newQuestion, currentProject, singletonData.getcUser(), usersReceptors);
                    startActivity(new Intent(AskingActivity.this, QuestionActivity.class));
                }
            }
        });
    }

    public void spinnerTag() {
        mSearchableSpinner = findViewById(R.id.sp_tag);

        final ArrayList<TagsModel> tagModelSingleton = singletonData.getTags();
        final ArrayList<String> typeDeProjets = new ArrayList<>();
        for (TagsModel tagModel : tagModelSingleton) {
            typeModels = tagModel.getNom();
            typeDeProjets.add(typeModels);
        }

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeDeProjets);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_type));
        mSearchableSpinner.setTitle(getString(R.string.choix_type));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        mTagsToQuestion = new ArrayList<>();
        final AskingGringAdapter adapterTag = new AskingGringAdapter(mContext, mTagsToQuestion);
        RecyclerView TagRecyclerView = findViewById(R.id.TagRecyclerView);
        TagRecyclerView.setLayoutManager(new GridLayoutManager(AskingActivity.this, 3));
        TagRecyclerView.setAdapter(adapterTag);

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Vérifie si Nous somme a l'arrivé de la page comme cela nous n'ajouton pas la valeur du premliers champs contenu dans l'input
                if (!isFisrt) {
                    TagsModel typeTag = tagModelSingleton.get(position);
                    boolean isSelected = false;
                    //Je vérifie si l'item na pas déja etais selectionné
                    for (TagsModel tagModel: mTagsToQuestion) {
                        if(tagModel.getNom().equals(typeTag.getNom())){
                            Toast.makeText(getApplicationContext(), R.string.no_similars_tag, Toast.LENGTH_SHORT).show();
                            isSelected = true;
                            break;
                        }
                    }
                    // si l'item na pas etais selectioné je l'ajoute
                    if(!isSelected){
                        mTagsToQuestion.add(typeTag);
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