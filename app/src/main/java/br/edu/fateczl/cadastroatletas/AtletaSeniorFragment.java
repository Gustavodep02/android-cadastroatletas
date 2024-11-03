package br.edu.fateczl.cadastroatletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.fateczl.cadastroatletas.controller.IOperacao;
import br.edu.fateczl.cadastroatletas.controller.OperacaoSenior;
import br.edu.fateczl.cadastroatletas.model.AtletaSenior;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaSeniorFragment extends Fragment {

    private View view;
    private EditText etNomeAS, etNascimentoAS, etBairroAS;
    private CheckBox cbProbCardAS;
    private TextView tvSaidaAS;
    private Button btnCadastrarAS;

    public AtletaSeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);

        etNomeAS = view.findViewById(R.id.etNomeAS);
        etNascimentoAS = view.findViewById(R.id.etNascimentoAS);
        etBairroAS = view.findViewById(R.id.etBairroAS);
        cbProbCardAS = view.findViewById(R.id.cbProbCardAS);
        tvSaidaAS = view.findViewById(R.id.tvSaidaAS);
        tvSaidaAS.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCadastrarAS = view.findViewById(R.id.btnCadastrarAS);

        btnCadastrarAS.setOnClickListener(op -> cadastro());
        return view;
    }
    private void cadastro() {
        AtletaSenior as = new AtletaSenior();
        as.setNome(etNomeAS.getText().toString());
        String dataTexto = etNascimentoAS.getText().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataTexto, formatter);
        as.setDataNascimento(dataNascimento);
        as.setBairro(etBairroAS.getText().toString());
        as.setProblemasCardiacos(cbProbCardAS.isChecked());
        tvSaidaAS.setText(as.toString());

        IOperacao<AtletaSenior> op = new OperacaoSenior();
        op.cadastrar(as);
        List<AtletaSenior> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaSenior a : lista) {
            buffer.append(a.toString() + "\n");
        }
        tvSaidaAS.setText(buffer.toString());
        limpaCampos();
    }
    private void limpaCampos() {
        etNomeAS.setText("");
        etNascimentoAS.setText("");
        etBairroAS.setText("");
        cbProbCardAS.setChecked(false);
    }
}