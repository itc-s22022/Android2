package ja.ac.it_college.std.s22022.navigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ja.ac.it_college.std.s22022.navigationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}