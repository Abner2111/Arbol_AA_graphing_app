package com.estudiantec.arbolaagraphing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.StringTokenizer;

public class TreeVisualizer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_visualizer2);
        Button rootNodeBtn = (Button) findViewById(R.id.rootNodeBtn);

        /**
         * Botones para visualizar nodos
         */
        Button[] level2NodesBtn = new Button[]{(Button) findViewById(R.id.secondLevelNodeBtn1), (Button) findViewById(R.id.secondLevelNodeBtn2)};
        Button[] level3NodesBtn = new Button[]{(Button) findViewById(R.id.thirdLevelNodeBtn1),(Button) findViewById(R.id.thirdLevelNodeBtn2),
               (Button) findViewById(R.id.thirdLevelNodeBtn3),(Button) findViewById(R.id.thirdLevelNodeBtn4)};

        if (getIntent().hasExtra("com.estudiantec.arbolaagraph.codedtree")){

             //Arbol codificado como string

            String treeCode = getIntent().getExtras().getString("com.estudiantec.arbolaagraph.codedtree");

           //String tokenizer para descodificar arbol en niveles

            StringTokenizer tokens = new StringTokenizer(treeCode, "/");


            //Primer nivel (raiz)

            StringTokenizer rootStringTokens = new StringTokenizer(tokens.nextToken(), ",");
            String rootString = rootStringTokens.nextToken();
            rootNodeBtn.setText(rootString);

            /*
            //Segundo nivel

            StringTokenizer level2Tokens = new StringTokenizer(tokens.nextToken(), ",");

            for (int i=0; i<=2; i++){
                String nodeData = level2Tokens.nextToken();
                if (!nodeData.equals("null")){
                    level2NodesBtn[i].setText(nodeData);
                }
            }


            //Tercer nivel

            StringTokenizer level3Tokens = new StringTokenizer(tokens.nextToken(), ",");

            for (int i=0; i<=4; i++){
                String nodeData = level2Tokens.nextToken();
                if (!nodeData.equals("null")){
                    level3NodesBtn[i].setText(nodeData);
                }
            }

             */
        }







    }
}