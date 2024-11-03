package br.edu.fateczl.cadastroatletas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.edu.fateczl.cadastroatletas.model.AtletaComum;

/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            carregaFragment(bundle);
        }
    }

    private void carregaFragment(Bundle bundle) {
        String tipo = bundle.getString("tipo");
        if(tipo.equals("juvenil")){
            fragment = new AtletaJuvenilFragment();
        } else if(tipo.equals("comum")){
            fragment = new AtletaComumFragment();
        } else if(tipo.equals("senior")){
            fragment = new AtletaSeniorFragment();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,MainActivity.class);

        if(id == R.id.menu_atl_juv){
            bundle.putString ("tipo", "juvenil");
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        } else if(id == R.id.menu_atl_com){
            bundle.putString ("tipo", "comum");
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        } else if(id == R.id.menu_atl_sen){
            bundle.putString ("tipo", "senior");
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
            return super.onOptionsItemSelected(item);

    }
}