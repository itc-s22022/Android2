package ja.ac.it_college.std.s22022.navigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ja.ac.it_college.std.s22022.navigationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ToolBar を　ActionBar として使用する
        setSupportActionBar(binding.toolbar)

        // Navigation 関連のコンポーネントを取得
        val navHost = binding.fragmentContainerView.getFragment<NavHostFragment>()
        val navController = navHost.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // ToolBar と　Navigation と連携
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return binding.fragmentContainerView.findNavController().navigateUp(appBarConfiguration)
    }
}