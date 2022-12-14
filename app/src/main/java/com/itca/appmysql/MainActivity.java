package com.itca.appmysql;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.itca.appmysql.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    TextView viewnombre, nombrehome;
    public static String apellidoss, nombree, tipoo;
    Button btnregistrarPro;
    MenuItem itemProducto, itemCategoria;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);


        viewnombre=findViewById(R.id.ethomnombre);
        nombrehome = findViewById(R.id.tvnombreheade);
        Intent i = this.getIntent();
        String tipo = i.getStringExtra("tipo");
        String usuario = i.getStringExtra("usuario");
        String apellidos = i.getStringExtra("apellidos");
        String nombre = i.getStringExtra("nombre");
         apellidoss = apellidos;
         nombree = nombre;
         tipoo = tipo;
         int tippo = Integer.parseInt(tipoo);



      /* Toast toast =
        Toast.makeText(this, "!Bienvenido " + nombree + " " + apellidoss+ "¡¡" , Toast.LENGTH_SHORT);
        toast.show();*/
        viewnombre.setText("Nombre: " + nombree +" " + apellidoss);
       // nombrehome.setText("Nombre: " + nombree +" " + apellidoss);



       /* if (tipoo.equals(1)){
            mostraritems();
        }else  {
            ocultaritems();
        };*/



        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_categorias, R.id.nav_productos, R.id.nav_QCategorias, R.id.nav_qproductos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

   private void mostraritems(){
        itemProducto = findViewById(R.id.action_addprod);

           itemProducto.setVisible(true);

    }

    private void ocultaritems(){
        itemProducto = findViewById(R.id.action_addprod);

        itemProducto.setVisible(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}