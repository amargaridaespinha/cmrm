package cm_15037.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        println(this@MainActivity.localClassName + " onCreate")

        val layout = findViewById<ConstraintLayout>(R.id.main)
        val buttonColor = findViewById<Button>(R.id.buttonChangeColor)

        buttonColor.setOnClickListener {
            val randomColor = (0xFF000000.toInt() or (Math.random() * 0x00FFFFFF).toInt())
            layout.setBackgroundColor(randomColor)

            Toast.makeText(this, "Cor de fundo alterada!", Toast.LENGTH_SHORT).show()
        }

    }
}