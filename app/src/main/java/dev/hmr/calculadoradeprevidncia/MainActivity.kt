package dev.hmr.calculadoradeprevidncia

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.hmr.calculadoradeprevidncia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        biding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(biding.root)

        biding.butCalcular.setOnClickListener {
            val idade = biding.inpIdade.text.toString().toInt()
            val sexo = biding.selSexo.selectedItem
            var anosAteAposentadoria = 0

            when(sexo) {
                "Masculino" -> {
                    anosAteAposentadoria = 65 - idade
                }
                "Feminino" -> {
                    anosAteAposentadoria = 62 - idade
                }
            }

            biding.textView2.setText(
                "Você possui $anosAteAposentadoria anos até sua aposentadoria.")

        }

    }
}