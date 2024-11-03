package br.edu.fateczl.cadastroatletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.fateczl.cadastroatletas.controller.IOperacao;
import br.edu.fateczl.cadastroatletas.controller.OperacaoComum;
import br.edu.fateczl.cadastroatletas.model.AtletaComum;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaComumFragment extends Fragment {

    private View view;
    private EditText etAcademiaAC, etRecordeAC, etNomeAC, etNascimentoAC, etBairroAC;
    private Button btnCadastrarAC;
    private TextView tvSaidaAC;

    public AtletaComumFragment() {
        super();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_atleta_comum, container, false);
        etNomeAC = view.findViewById(R.id.etNomeAC);
        etNascimentoAC = view.findViewById(R.id.etNascimentoAC);
        etBairroAC = view.findViewById(R.id.etBairroAC);
        etAcademiaAC = view.findViewById(R.id.etAcademiaAC);
        etRecordeAC = view.findViewById(R.id.etRecordeAC);
        btnCadastrarAC = view.findViewById(R.id.btnCadastrarAC);
        tvSaidaAC = view.findViewById(R.id.tvSaidaAC);
        tvSaidaAC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarAC.setOnClickListener(op -> cadastro());
        return view;
    }

    private void cadastro() {
        AtletaComum ac = new AtletaComum();
        ac.setNome(etNomeAC.getText().toString());
        String dataTexto = etNascimentoAC.getText().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataTexto, formatter);
        ac.setDataNascimento(dataNascimento);
        ac.setBairro(etBairroAC.getText().toString());
        ac.setAcademia(etAcademiaAC.getText().toString());
        ac.setRecorde(Double.parseDouble(etRecordeAC.getText().toString()));

        IOperacao<AtletaComum> op = new OperacaoComum();
        op.cadastrar(ac);
        List<AtletaComum> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaComum p : lista){
            buffer.append(p.toString() + "\n");
    }
        tvSaidaAC.setText(buffer.toString());
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeAC.setText("");
        etNascimentoAC.setText("");
        etBairroAC.setText("");
        etAcademiaAC.setText("");
        etRecordeAC.setText("");
    }
}