package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.hackbus.adapters.CompetenceProjetAdapter;
import fr.wildcodeschool.hackbus.adapters.CompetenceUserPageAdapter;
import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.TypeModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class ProjetFormActivity extends SuperActivity {

    private SearchableSpinner mSearchableSpinner = null;
    private ProjetModel newProject = Singleton.getInstance().getNewProject();
    TypeModel typeProjet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_form);
        spinnerMethode1();

        TextView initUser = findViewById(R.id.tv_init);
        initUser.setText(SingletonData.getInstance().getcUser().getNom());


        //competence
        RecyclerView competenceList = findViewById(R.id.rv_competence);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        competenceList.setLayoutManager(LayoutManager);

        List<TagsModel> competences = new ArrayList<>();
        for (TagsModel comp : SingletonData.getInstance().getTags()) {
            competences.add(comp);
        }
        CompetenceProjetAdapter adapter = new CompetenceProjetAdapter(competences, this, newProject);
        competenceList.setAdapter(adapter);


        Button valid = findViewById(R.id.bt_valid);
        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText name = findViewById(R.id.et_nomproj);
                EditText description = findViewById(R.id.et_description);
                EditText git = findViewById(R.id.et_git);
                String nameValue = name.getText().toString();
                String descriptionValue = description.getText().toString();
                String gitValue = git.getText().toString();

                if (nameValue.isEmpty() && descriptionValue.isEmpty() && gitValue.isEmpty() && typeProjet == null) {
                    Toast.makeText(ProjetFormActivity.this, "Edit text is empty", Toast.LENGTH_SHORT).show();
                } else {
                    newProject.setNom(nameValue);
                    newProject.setDescription(descriptionValue);
                    newProject.setLienGitHub(gitValue);
                    newProject.setTypeProjet(typeProjet);

                    Toast.makeText(ProjetFormActivity.this, newProject.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void spinnerMethode1() {
        mSearchableSpinner = findViewById(R.id.sp_type);

        final ArrayList<TypeModel> typeDeProjet = SingletonData.getInstance().getTypes();

        final ArrayAdapter<TypeModel> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeDeProjet);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_type));
        mSearchableSpinner.setTitle(getString(R.string.choix_type));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeProjet = typeDeProjet.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
