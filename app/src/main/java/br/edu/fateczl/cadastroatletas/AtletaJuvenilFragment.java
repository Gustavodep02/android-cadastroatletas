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
import br.edu.fateczl.cadastroatletas.controller.OperacaoJuvenil;
import br.edu.fateczl.cadastroatletas.model.AtletaComum;
import br.edu.fateczl.cadastroatletas.model.AtletaJuvenil;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaJuvenilFragment extends Fragment {

    private View view;
    private EditText etNomeAJ, etNascimentoAJ, etBairroAJ, etAnosAJ;
    private Button btnCadastrarAJ;
    private TextView tvSaidaAJ;
    public AtletaJuvenilFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);
        etNomeAJ = view.findViewById(R.id.etNomeAJ);
        etNascimentoAJ = view.findViewById(R.id.etNascimentoAJ);
        etBairroAJ = view.findViewById(R.id.etBairroAJ);
        etAnosAJ = view.findViewById(R.id.etAnosAJ);
        btnCadastrarAJ = view.findViewById(R.id.btnCadastrarAJ);
        tvSaidaAJ = view.findViewById(R.id.tvSaidaAJ);
        tvSaidaAJ.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCadastrarAJ.setOnClickListener(op -> cadastro());
        return view;
    }

    private void cadastro() {
        AtletaJuvenil aj = new AtletaJuvenil();
        aj.setNome(etNomeAJ.getText().toString());
        String dataTexto = etNascimentoAJ.getText().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataTexto, formatter);
        aj.setDataNascimento(dataNascimento);
        aj.setBairro(etBairroAJ.getText().toString());
        aj.setAnosPraticados(Integer.parseInt(etAnosAJ.getText().toString()));
        tvSaidaAJ.setText(aj.toString());

        IOperacao<AtletaJuvenil> op = new OperacaoJuvenil();
        op.cadastrar(aj);
        List<AtletaJuvenil> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaJuvenil p : lista) {
            buffer.append(p.toString() + "\n");
        }
        tvSaidaAJ.setText(buffer.toString());
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeAJ.setText("");
        etNascimentoAJ.setText("");
        etBairroAJ.setText("");
        etAnosAJ.setText("");
    }

}