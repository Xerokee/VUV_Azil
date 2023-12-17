package com.activity.vuv_azil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.activity.vuv_azil.Models.Animal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertAnimalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button ButtonSend;
    private Spinner SpinnerDropdown;
    private TextView ImeEditText;
    private static final ArrayList<String> VrsteŽivotinja = new ArrayList<>(Arrays.asList("Lav", "Tigar", "Zmija", "Žirafa"));

    public InsertAnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertAnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertAnimalFragment newInstance(String param1, String param2) {
        InsertAnimalFragment fragment = new InsertAnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_animal, container, false);
        ButtonSend = view.findViewById(R.id.ButtonSend);
        ImeEditText = view.findViewById(R.id.ImeEditText);
        SpinnerDropdown = view.findViewById(R.id.SpinnerDropdown);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,VrsteŽivotinja);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerDropdown.setAdapter(adapter);
        ButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal animal = new Animal();
                animal.setIme(ImeEditText.getText().toString());
                animal.setVrstaZivotinje(SpinnerDropdown.getSelectedItem().toString());
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference reference = db.getReference("zivotinje");
                reference.child(ImeEditText.getText().toString()).setValue(animal).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        ImeEditText.setText("");
                    }
                });
            }
        });
        return view;
    }
}