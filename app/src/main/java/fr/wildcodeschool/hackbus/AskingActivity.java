package fr.wildcodeschool.hackbus;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.TypeModel;

public class AskingActivity extends AppCompatActivity {

    private SearchableSpinner mSearchableSpinner = null;
    private String typeModels;
    TypeModel informatique = new TypeModel("Informatique");
    TypeModel mecanique = new TypeModel("Mecanique");
    TypeModel design = new TypeModel("Design");
    TypeModel sexuel = new TypeModel("Sexuel");
    SingletonData singletonData = SingletonData.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);
        spinnerTag();
        seekBar();
    }

    //TODO IMPLEMENTER UNE LISTE TAG DE FIREBAAAASE ! (pour l'instant petite liste des compétences a la place pour tester le spinner)
    public void spinnerTag() {
        mSearchableSpinner = findViewById(R.id.sp_tag);

        final ArrayList<TypeModel> typeModelSingleton = singletonData.getTypes();
         ArrayList<String> typeDeProjets = new ArrayList<>();
        for (TypeModel typeModel: typeModelSingleton) {
            typeModels =  typeModel.getNom();
            typeDeProjets.add(typeModels);
        }

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeDeProjets);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchableSpinner.setAdapter(spinnerAdapter);
        mSearchableSpinner.setPrompt(getString(R.string.selection_type));
        mSearchableSpinner.setTitle(getString(R.string.choix_type));
        mSearchableSpinner.setPositiveButton(getString(R.string.ok));

        mSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TypeModel typeProjet = typeModelSingleton.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @TargetApi(21)
    private void seekBar() {
        SeekBar sbPriority = findViewById(R.id.sb_priority);
        final TextView tvCount = findViewById(R.id.tv_count);
        final ImageView progressColor = findViewById(R.id.iv_color_progress);

        sbPriority.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tvCount.setText(seekBarProgress + " / " + seekBar.getMax());

                if (seekBarProgress == 0) {
                    progressColor.setColorFilter(R.color.grey);
                } else if (seekBarProgress == 1) {
                    progressColor.setColorFilter(R.color.blue);
                } else if (seekBarProgress == 2) {
                    progressColor.setColorFilter(R.color.green);
                } else if (seekBarProgress == 3) {
                    progressColor.setColorFilter(R.color.yellow);
                } else if (seekBarProgress == 4) {
                    progressColor.setColorFilter(R.color.orange);
                } else if (seekBarProgress == 5) {
                    progressColor.setColorFilter(R.color.red);
                }
            }

        });
    }
}