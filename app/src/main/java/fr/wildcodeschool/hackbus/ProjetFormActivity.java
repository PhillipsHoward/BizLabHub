package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.TypeModel;

public class ProjetFormActivity extends AppCompatActivity {

    private SearchableSpinner mSearchableSpinner = null;
    TypeModel informatique = new TypeModel("Informatique");
    TypeModel mecanique = new TypeModel("Mecanique");
    TypeModel design = new TypeModel("Design");
    TypeModel sexuel = new TypeModel("Sexuel");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_form);
        spinnerMethode1();
        spinnerMethode2();







    }

    public void spinnerMethode1() {
        mSearchableSpinner = findViewById(R.id.sp_type);

        final ArrayList<String> typeDeProjet = new ArrayList<>();
        typeDeProjet.add(informatique.getNom());
        typeDeProjet.add(mecanique.getNom());
        typeDeProjet.add(design.getNom());
        typeDeProjet.add(sexuel.getNom());

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeDeProjet);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_type));
        mSearchableSpinner.setTitle(getString(R.string.choix_type));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String typeProjet = typeDeProjet.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void spinnerMethode2() {
        mSearchableSpinner = findViewById(R.id.sp_competence);

        final ArrayList<CompetenceModel> competence = new ArrayList<>(); // TODO récuperer les competenceModels

        final ArrayAdapter<CompetenceModel> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, competence);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_competence));
        mSearchableSpinner.setTitle(getString(R.string.choix_competence));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CompetenceModel comp = competence.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
