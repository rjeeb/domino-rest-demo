package org.dominokit.rest.example;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.dominokit.rest.example.shared.PeopleCommands;
import org.dominokit.rest.example.shared.Person;

import static java.util.stream.Collectors.joining;

public class FirstFragment extends Fragment {

    private final PeopleCommands peopleCommands = new PeopleCommands();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listPeople(view);
        loadPerson(view);
        createPerson(view);
        updatePerson(view);
        deletePerson(view);
    }

    private void listPeople(@NonNull View view) {
        view.findViewById(R.id.listPeople).setOnClickListener(view1 -> {
            peopleCommands.listPeople(people -> {
                showDialog(people.stream()
                        .map(Person::toString)
                        .collect(joining("\n")));
            }, failedResponseBean -> {
                showDialog(failedResponseBean.getBody());
            });
        });
    }

    private void loadPerson(@NonNull View view) {
        view.findViewById(R.id.loadPerson).setOnClickListener(view1 -> {
            final EditText input = new EditText(getActivity());

            AlertDialog result = new AlertDialog.Builder(getActivity())
                    .setTitle("Person information")
                    .setView(input)
                    .setPositiveButton("Load", (dialogInterface, i) -> {
                        String id = input.getText().toString();
                        peopleCommands.loadPerson(Long.valueOf(id), person -> {
                            showDialog(person.toString());
                        }, failedResponseBean -> {
                            showDialog(failedResponseBean.getBody());
                        });
                    })
                    .create();

            result.show();
        });
    }

    private void createPerson(@NonNull View view) {
        view.findViewById(R.id.createPerson).setOnClickListener(view1 -> {
            final EditText firstName = new EditText(getActivity());
            firstName.setHint("First name");
            final EditText lastName = new EditText(getActivity());
            lastName.setHint("Last name");
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(firstName);
            linearLayout.addView(lastName);
            AlertDialog result = new AlertDialog.Builder(getActivity())
                    .setTitle("Person information")
                    .setView(linearLayout)
                    .setPositiveButton("Create", (dialogInterface, i) -> {
                        Person person = new Person();
                        person.setFirstName(firstName.getText().toString());
                        person.setLastName(lastName.getText().toString());
                        peopleCommands.createPerson(person, created -> {
                            showDialog(created.toString());
                        }, failedResponseBean -> {
                            showDialog(failedResponseBean.getBody());
                        });
                    })
                    .create();

            result.show();
        });
    }

    private void updatePerson(@NonNull View view) {
        view.findViewById(R.id.updatePerson).setOnClickListener(view1 -> {
            final EditText id = new EditText(getActivity());
            id.setHint("ID");
            final EditText firstName = new EditText(getActivity());
            firstName.setHint("First name");
            final EditText lastName = new EditText(getActivity());
            lastName.setHint("Last name");
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(id);
            linearLayout.addView(firstName);
            linearLayout.addView(lastName);

            AlertDialog result = new AlertDialog.Builder(getActivity())
                    .setTitle("Person information")
                    .setView(linearLayout)
                    .setPositiveButton("Update", (dialogInterface, i) -> {
                        Person person = new Person();
                        person.setId(Long.valueOf(id.getText().toString()));
                        person.setFirstName(firstName.getText().toString());
                        person.setLastName(lastName.getText().toString());
                        peopleCommands.updatePerson(person, updated -> {
                            showDialog(updated.toString());
                        }, failedResponseBean -> {
                            showDialog(failedResponseBean.getBody());
                        });
                    })
                    .create();

            result.show();
        });
    }

    private void deletePerson(@NonNull View view) {
        view.findViewById(R.id.deletePerson).setOnClickListener(view1 -> {
            final EditText input = new EditText(getActivity());

            AlertDialog result = new AlertDialog.Builder(getActivity())
                    .setTitle("Person information")
                    .setView(input)
                    .setPositiveButton("Delete", (dialogInterface, i) -> {
                        String id = input.getText().toString();
                        peopleCommands.deletePerson(Long.valueOf(id), aVoid -> {
                            showDialog("Person deleted successfully");
                        }, failedResponseBean -> {
                            showDialog(failedResponseBean.getBody());
                        });
                    })
                    .create();

            result.show();
        });
    }

    private void showDialog(String message) {
        AlertDialog result = new AlertDialog.Builder(getActivity())
                .setTitle("Result")
                .setMessage(message)
                .create();

        result.show();
    }
}